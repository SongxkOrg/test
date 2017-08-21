package song.test;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class Test {
	public static void main(String[] args) throws ImageFormatException, IOException {
		int i=1;
        int j=2;
        InputStream imagein = new FileInputStream("E:/程序/workspace/test/src/"+i + ".jpg");
        InputStream imagein2 = new FileInputStream("E:/程序/workspace/test/src/"+j + ".JPEG");
        BufferedImage image = ImageIO.read(imagein);
        BufferedImage image2 = ImageIO.read(imagein2);
        Graphics g = image.getGraphics();
        g.drawImage(image2, image.getWidth() - image2.getWidth() - 15, image.getHeight() - image2.getHeight() - 10,
                image2.getWidth() + 10, image2.getHeight() + 5, null);
        OutputStream outImage = new FileOutputStream("custom" + j + "-" + i + ".jpg");
        JPEGImageEncoder enc = JPEGCodec.createJPEGEncoder(outImage);
        enc.encode(image);
        imagein.close();
        imagein2.close();
        outImage.close();
	}
}
