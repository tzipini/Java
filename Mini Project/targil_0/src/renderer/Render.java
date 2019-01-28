package renderer;

import java.awt.Color;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import elements.AmbientLight;
import elements.Camera;
import elements.LightSource;

import java.util.Iterator;

import geometries.FlatGeometry;
import geometries.Geometry;
import geometries.Sphere;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import scene.Scene;

public class Render {
	private Scene scene;
	private ImageWriter imageWriter;
	// ***************** Constructors ********************** //

	public Render() {
		this.scene = new Scene();
		this.imageWriter = new ImageWriter("image", 3, 3, 3, 3);
	}

	public Render(Render r) {
		scene = new Scene(r.scene);
		imageWriter = new ImageWriter(r.imageWriter);
	}

	public Render(String name, int width, int height, String name1, Color c1, Color c2, double k, List<Geometry> g,
			List<LightSource> l, double d) {
		this.imageWriter = new ImageWriter(name, width, height, width, height);
		this.scene = new Scene(name, c1, c2, k, g, l, d);
	}

	public Render(Scene scene2, ImageWriter imageWriter2) {
		this.scene = new Scene(scene2);
		this.imageWriter = new ImageWriter(imageWriter2);
		// TODO Auto-generated constructor stub
	}

	// ***************** Getters/Setters ********************** //
	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public ImageWriter getImageWriter() {
		return imageWriter;
	}

	public void setImagewriter(ImageWriter imagewriter) {
		this.imageWriter = imagewriter;
	}

	// ***************** Operations ******************** //

	public ImageWriter printGrid(int a) {
		for (int i = 0; i < imageWriter.getHeight(); i++)
			for (int j = 0; j < imageWriter.getWidth(); j++)
				if (i % a == 0 || j % a == 0)
					imageWriter.writePixel(i, j, new Color(255, 255, 255));
		return imageWriter;
	}

	// private Color calcColor(Geometry geometry, Point3D point) {
	// Color ambientLight = scene.getAmbientlight().getIntensity();
	// Color emissionLight = geometry.getEmmission();
	// Color I0 = new Color(ambientLight.getRed() + emissionLight.getRed(),
	// ambientLight.getGreen()
	// + emissionLight.getGreen(), ambientLight.getBlue() +
	// emissionLight.getBlue());
	// return I0;
	// }
	private Color calcColor(Geometry geometry, Point3D point) throws Exception {

		Color ambientLight = scene.getAmbientlight().getIntensity();
		Color emissionLight = geometry.getEmmission();
		Color diffuseLight = new Color(0, 0, 0);
		Color specularLight = new Color(0, 0, 0);
		int r;
		int g;
		int b;
		Iterator<LightSource> lights = scene.getLightsIterator();
		LightSource light;
		Point3D p = new Point3D(scene.getCamera().getP0());
		p.distance(point);
		while (lights.hasNext()) {
			light = lights.next();
			if (occluded(light, point, geometry)) {
				Color d = calcDiffusiveComp(geometry.getMaterial().getKd(), geometry.getNormal(point),
						light.getL(point), light.getIntensity(point));
				r = diffuseLight.getRed() + d.getRed();
				g = diffuseLight.getGreen() + d.getGreen();
				b = diffuseLight.getBlue() + d.getBlue();
				if (r > 255)
					r = 255;
				if (g > 255)
					g = 255;
				if (b > 255)
					b = 255;
				diffuseLight = new Color(r, g, b);

				Color s = calcSpecularComp(geometry.getMaterial().getKs(), new Vector(p), geometry.getNormal(point),
						light.getL(point), geometry.getMaterial().getnShininess(), light.getIntensity(point));

				r = specularLight.getRed() + s.getRed();
				g = specularLight.getGreen() + s.getGreen();
				b = specularLight.getBlue() + s.getBlue();
				if (r > 255)
					r = 255;
				if (g > 255)
					g = 255;
				if (b > 255)
					b = 255;
				specularLight = new Color(r, g, b);

			}
		}
		r = ambientLight.getRed() + emissionLight.getRed() + diffuseLight.getRed() + specularLight.getRed();
		b = ambientLight.getGreen() + emissionLight.getGreen() + diffuseLight.getGreen() + specularLight.getGreen();
		g = ambientLight.getBlue() + emissionLight.getBlue() + diffuseLight.getBlue() + specularLight.getBlue();
		if (r > 255)
			r = 255;
		if (g > 255)
			g = 255;
		if (b > 255)
			b = 255;
		Color c = new Color(r, g, b);
		return c;
	}
	
	private Color calcSpecularComp(double ks, Vector V, Vector N, Vector L, double n, Color intensity) {
		// KS(V・R)nILi
		Vector R = new Vector(L);
		Vector normal = new Vector(N);
		normal.scale(2 * L.dotProduct(N));
		R.subtract(normal);
		double k = ks * Math.pow(V.dotProduct(R), n);
		if (k < 0)
			k *= -1;

		int r = (int) (intensity.getRed() * k);
		int g = (int) (intensity.getGreen() * k);
		int b = (int) (intensity.getBlue() * k);
		if (r > 255)
			r = 255;
		if (g > 255)
			g = 255;
		if (b > 255)
			b = 255;
		return new Color(r, g, b);
	}

	private Color calcDiffusiveComp(double kd, Vector normal, Vector l, Color intensity) {
		double k = kd * (normal.dotProduct(l));
		if (k < 0)
			k *= -1;
		int r = (int) (intensity.getRed() * k);
		int g = (int) (intensity.getGreen() * k);
		int b = (int) (intensity.getBlue() * k);
		if (r > 255)
			r = 255;
		if (g > 255)
			g = 255;
		if (b > 255)
			b = 255;
		return new Color(r, g, b);
	}

	private boolean occluded(LightSource light, Point3D point, Geometry geometry) throws Exception {
		Vector lightDirection = light.getL(point);
		lightDirection.scale(-1);
		Point3D geometryPoint = new Point3D(point);
		Vector epsVector = new Vector(geometry.getNormal(point));
		epsVector.scale(2);

		geometryPoint.add(epsVector.getHead());
		Ray lightRay = new Ray(geometryPoint, lightDirection);
		Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(lightRay);

		// Flat geometry cannot self intersect
		if (geometry instanceof FlatGeometry) {
			intersectionPoints.remove(geometry);
		}
		return !intersectionPoints.isEmpty();
	}

	private Map<Geometry, Point3D> getClosestPoint(Map<Geometry, List<Point3D>> intersectionPoints) {
		double distance = Double.MAX_VALUE;
		Point3D P0 = scene.getCamera().getP0();
		Map<Geometry, Point3D> minDistancePoint = new HashMap<Geometry, Point3D>();
		for (Entry<Geometry, List<Point3D>> entry : intersectionPoints.entrySet())
			for (Point3D point : entry.getValue())
				if (P0.distance(point) < distance) {
					minDistancePoint.clear();
					minDistancePoint.put(entry.getKey(), new Point3D(point));
					distance = P0.distance(point);
				}
		return minDistancePoint;
	}

	private boolean checkSphere(Geometry geometry) {
		if (geometry instanceof Sphere) {
			geometry = (Sphere) geometry;
			if (((Sphere) geometry).getCenter().getZ().getCoordinate() >= (-scene.getScreenDistance()))
				return false;
			else
				return true;
		} else
			return true;

	}

	private Map<Geometry, List<Point3D>> getSceneRayIntersections(Ray ray) throws Exception {
		Iterator<Geometry> geometries = scene.getGeometriesIterator();
		Map<Geometry, List<Point3D>> intersectionPoints = new HashMap<Geometry, List<Point3D>>();
		List<Point3D> geometryIntersectionPoints;

		Geometry geometry;
		while (geometries.hasNext()) {
			geometry = geometries.next();
			geometryIntersectionPoints = geometry.FindIntersections(ray);
			if (checkSphere(geometry)) {
				intersectionPoints.put(geometry, geometryIntersectionPoints);
			}

		}

		return intersectionPoints;

	}

	public ImageWriter renderImage() throws Exception {

		for (int i = 0; i < imageWriter.getHeight(); i++)
			for (int j = 0; j < imageWriter.getWidth(); j++) {
				Ray ray = scene.getCamera().constructRayThroughPixel(imageWriter.getNx(), imageWriter.getNy(), j, i,
						scene.getScreenDistance(), imageWriter.getWidth(), imageWriter.getHeight());
				Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(ray);

				if (intersectionPoints.isEmpty())
					imageWriter.writePixel(j, i, scene.getBackground());
				else {
					Map<Geometry, Point3D> closestPoint = getClosestPoint(intersectionPoints);
					for (Entry<Geometry, Point3D> entry : closestPoint.entrySet())
						imageWriter.writePixel(j, i, calcColor(entry.getKey(), new Point3D(entry.getValue())));
				}

			}
		return imageWriter;
	}
}