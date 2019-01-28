package UnitTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CameraTests.class, PlaneTest.class, RenderTest.class, SphereTest.class, TriangleTest.class,
		VectorTest.class, WriteImagetTest.class })
public class AllTests {

}
