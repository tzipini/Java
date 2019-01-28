package renderer;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageWriter {

	private int imageWidth;
	private int imageHeight;
	
	private int Ny, Nx;
	
	final String PROJECT_PATH = System.getProperty("user.dir");
	
	private BufferedImage image;
	
	private String imageName;
	
	// ***************** Constructors ********************** // 
	public ImageWriter() {
	}
	public ImageWriter(String imageName, int width, int height, int Ny, int Nx){
		
		this.Nx = Nx;
		this.Ny = Ny;
		
		this.imageWidth = width;
		this.imageHeight = height;
		
		this.imageName = imageName;
		
		this.image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);;
	}
	
	public ImageWriter (ImageWriter imageWriter){
		this.Nx = imageWriter.Nx;
		this.Ny = imageWriter.Ny;
		
		this.imageWidth = imageWriter.getWidth();
		this.imageHeight = imageWriter.getHeight();
		
		this.imageName = imageWriter.imageName;
		
		this.image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
	}
	
	// ***************** Getters/Setters ********************** //
	
	public int getWidth()  { return imageWidth;  }
	public int getHeight() { return imageHeight; }

	public int getNy() { return Ny; }
	public int getNx() { return Nx; }

	public void setNy(int Ny) { this.Ny = Ny; }
	public void setNx(int Nx) { this.Nx = Nx; }
		
	// ***************** Operations ******************** // 
	
	public void writeToimage(){
		
		File ouFile = new File(PROJECT_PATH + "/" + imageName + ".jpg");

		try {
			ImageIO.write(image, "jpg", ouFile);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writePixel(int xIndex, int yIndex, int r, int g, int b){
		
		int rgb = new Color(r, g, b).getRGB();
		image.setRGB(xIndex, yIndex, rgb);
		
	}
	
	public void writePixel(int xIndex, int yIndex, int[] rgbArray){
		
		int rgb = new Color(rgbArray[0], rgbArray[1], rgbArray[2]).getRGB();
		image.setRGB(xIndex, yIndex, rgb);
		
	}
	
	public void writePixel(int xIndex, int yIndex, Color color){
		
		image.setRGB(xIndex, yIndex, color.getRGB());
		
	}
	public BufferedImage getImage() { 
        return image; 
    } 

	
}
