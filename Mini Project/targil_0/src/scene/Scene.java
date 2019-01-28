package scene;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.Color;

import elements.AmbientLight;
import elements.Camera;
import elements.LightSource;
import geometries.Geometry;
import primitives.Vector;

public class Scene {
	private String sceneName;
	private Color background;
	private AmbientLight ambientlight;
	private List<Geometry> geometries;
	private List<LightSource> lights;
	private Camera camera;
	private double screenDistance;
	// ***************** Constructors ********************** //

	public Scene(String sceneName, Color background, Color ambientlight, double ka, List<Geometry> geometries,
			List<LightSource> lights,double screenDistance) {
		setSceneName(sceneName);
		this.background = background;
		this.ambientlight = new AmbientLight(ambientlight, ka);
		this.geometries = new ArrayList<Geometry>(geometries);
		this.setLights(new ArrayList<LightSource>(lights));
		this.camera = new Camera();
		setScreenDistance(screenDistance);
	}

	public Scene(Scene s) {
		setSceneName(s.sceneName);
		background = s.getBackground();
		this.ambientlight = new AmbientLight(s.getAmbientlight());
		this.geometries = new ArrayList<Geometry>(s.getGeometries());
		this.setLights(new ArrayList<LightSource>(s.getLights()));
		this.camera = new Camera(s.getCamera());
		setScreenDistance(s.screenDistance);
	}

	public Scene() {
		setSceneName(null);
		background = Color.BLACK;
		this.ambientlight = new AmbientLight();
		this.geometries = new ArrayList<Geometry>();
		this.lights = new ArrayList<LightSource>();
		this.camera = new Camera();
		setScreenDistance(100);
	}

	// ***************** Getters/Setters ********************** //
	public String getSceneName() {
		return sceneName;
	}

	public void setSceneName(String sceneName) {
		this.sceneName = sceneName;
	}

	public Color getBackground() {
		return background;
	}

	public void setBackground(Color background) {
		this.background = background;
	}

	public List<Geometry> getGeometries() {
		return geometries;
	}

	public void setGeometries(List<Geometry> geometries) {
		this.geometries = geometries;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	public double getScreenDistance() {
		return screenDistance;
	}

	public void setScreenDistance(double screenDistance) {
		this.screenDistance = screenDistance;
	}

	public AmbientLight getAmbientlight() {
		return ambientlight;
	}

	public void setAmbientlight(AmbientLight ambientlight) {
		this.ambientlight = ambientlight;
	}
	public List<LightSource> getLights() {
		return lights;
	}

	public void setLights(List<LightSource> lights) {
		this.lights = lights;
	}
	// ***************** Operations ******************** //

	public void addGeometry(Geometry geometry) {
		geometries.add(geometry);
	}
	public void addLight(LightSource lightSource) {
		lights.add(lightSource);
	}

	public Iterator<Geometry> getGeometriesIterator() {
		return geometries.iterator();
	}

	public Iterator<LightSource>  getLightsIterator() {
		return getLights().iterator();
	}

	public void clearAllGeometry() {
		geometries.clear();
	}

	

	// ***************** Administration ******************** //

}
