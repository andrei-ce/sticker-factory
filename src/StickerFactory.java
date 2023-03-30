import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickerFactory {
  
  public void create(InputStream inputStream, String fileName) throws IOException{
    //read image
    
    //InputStream inputStream = new FileInputStream(new File("input_storage/example_movie.jpeg"));
    //InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_10.jpg").openStream();
    BufferedImage originalImage = ImageIO.read(inputStream);

    //create new resizedimage with transparency in memory
    int width = originalImage.getWidth();
    int height = originalImage.getHeight();
    int newHeight = height + 200;
    
    //create new transparent image
    BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);
    Graphics2D graphics = (Graphics2D) newImage.createGraphics();
    //copy original image on new image (still in memory)
    graphics.drawImage(originalImage, null, 0, 0);

    //set font & color
    Font customFont = new Font(Font.SANS_SERIF, Font.BOLD, 64);
    Color customColor = new Color(82, 218, 124);
    graphics.setFont(customFont);
    graphics.setColor(customColor);

    //write a new funny subtitle
    String subtitle = "BOM DIA GRUPO";
    FontMetrics metrics = graphics.getFontMetrics(customFont);
    int x = (width - metrics.stringWidth(subtitle)) / 2;
    int y = newHeight - 70;
    graphics.drawString(subtitle, x, y);

    // Create the directory if it doesn't exist
    File outputDirectory = new File("output_storage");
    if (!outputDirectory.exists()) {
      System.out.println("Folder does not exist, creating one now...");
      outputDirectory.mkdirs();
    }

    //write new image on new file
    ImageIO.write(newImage, "png", new File("output_storage/"+fileName));
  }

}
