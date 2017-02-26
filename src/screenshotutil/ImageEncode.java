package screenshotutil;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
 
public class ImageEncode {
 
 /*public static void main(String[] args) throws Exception {
 
         File imageFile= new File("d:/abc.jpg");
         String img=imageToBase64String(imageFile);
 
         System.out.println("Converted String "+img);
 }//main(-)
*/ 
 public static String imageToBase64String(File imageFile)throws Exception{
	 Base64 base=new Base64();
          String image=null;
          /*BufferedImage buffImage = ImageIO.read(imageFile);
 
    if (buffImage != null) {
          java.io.ByteArrayOutputStream os = new 
                      java.io.ByteArrayOutputStream();
          ImageIO.write(buffImage, "jpg", os);
          byte[] data = os.toByteArray();*/
         // image = MyBase64.encode(data);
          image=base.encodeAsString(FileUtils.readFileToByteArray(imageFile));
// write to file the encoded character
 /*FileOutputStream fout =new FileOutputStream("c:\\temp\\encodedImage.txt");
 OutputStreamWriter out = new OutputStreamWriter(fout, "utf-8");
 out.write(image);
 out.close();*/
        //    }//if
          return image;
         }
 }//class