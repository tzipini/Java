/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTests;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import elements.AmbientLight;
import elements.Camera;
import elements.PointLight;
import elements.SpotLight;
import geometries.Geometry;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

import static org.junit.Assert.*;

public class RenderTest {

	@Test
	public void basicRendering() throws Exception {

		Scene scene = new Scene();
		scene.addGeometry(new Sphere(50, new Point3D(0, 0, -100.01)));

		Triangle triangle = new Triangle(new Point3D(100, 0, -100.01), new Point3D(0, 100, -100.01),
				new Point3D(100, 100, -100.01));

		Triangle triangle2 = new Triangle(new Point3D(100, 0, -100.01), new Point3D(0, -100, -100.01),
				new Point3D(100, -100, -100.01), new Color(0, 0, 100));

		Triangle triangle3 = new Triangle(new Point3D(-100, 0, -100.01), new Point3D(0, 100, -100.01),
				new Point3D(-100, 100, -100.01), new Color(0, 100, 0));

		Triangle triangle4 = new Triangle(new Point3D(-100, 0, -100.01), new Point3D(0, -100, -100.01),
				new Point3D(-100, -100, -100.01), new Color(100, 0, 0));

		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);
        
		ImageWriter imageWriter = new ImageWriter("Render test", 500, 500, 500, 500);
        
		Render render = new Render(scene, imageWriter);

		render.renderImage();
		render.printGrid(50);
		render.getImageWriter().writeToimage();

	}

	@Test
	public void Light()throws Exception {
		Scene scene = new Scene();
		scene.addLight(new PointLight(new Color(15, 15, 10), new Point3D(7, 0, 25), 0.002, 0.0015, 0.001));
		Vector v=new Vector(10,-15,-45);
		v.normalize();
		scene.addLight(new SpotLight(new Color(15, 15, 10),v,new Point3D(-10,20,50),0.002,0.0015,0.001));
		Vector v1=new Vector(10, -7, -0.5);
		v1.normalize();
		scene.addLight(new SpotLight(new Color(10, 15, 15),v1, new Point3D(-10, 20, 10), 0.002, 0.0015, 0.001));
		Vector v2=new Vector(10, 20, 10);
		v2.normalize();
		scene.addLight(new SpotLight(new Color(15, 10, 10),v2, new Point3D(-10, -20, -10), 0.002, 0.0015, 0.001));
		
		Vector v3=new Vector(10, -47, -67);
		v3.normalize();
		scene.addLight(new SpotLight(new Color(10, 50, 0),v3, new Point3D(-10, 5, 7), 0.02, 0.015, 0.01));
		scene.addGeometry(new Sphere(50, new Point3D(0, 0, -100.01)));


		Triangle triangle = new Triangle(new Point3D(100, 0, -100.01), new Point3D(0, 100, -100.01),
				new Point3D(100, 100, -100.01));

		Triangle triangle2 = new Triangle(new Point3D(100, 0, -100.01), new Point3D(0, -100, -100.01),
				new Point3D(100, -100, -100.01), new Color(0, 0, 100));

		Triangle triangle3 = new Triangle(new Point3D(-100, 0, -100.01), new Point3D(0, 100, -100.01),
				new Point3D(-100, 100, -100.01), new Color(0, 100, 0));

		Triangle triangle4 = new Triangle(new Point3D(-100, 0, -100.01), new Point3D(0, -100, -100.01),
				new Point3D(-100, -100, -100.01), new Color(100, 0, 0));

		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);
		// scene.addGeometry(t);

		ImageWriter imageWriter = new ImageWriter("LIGHT3 test", 500, 500, 500, 500);

		Render render = new Render(scene, imageWriter);

		render.renderImage();
		render.printGrid(50);
		render.getImageWriter().writeToimage();
	}
}
