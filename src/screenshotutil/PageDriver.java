package screenshotutil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageDriver {
	static Logger log = Logger.getLogger(PageDriver.class);

	public static void main(String args[]) throws Exception {
		log.info("Started");
		String SEP = System.getProperty("file.separator");
		log.info("file seperator::" + SEP);
		FirefoxDriver fd = new FirefoxDriver();
		fd.manage().window().setSize(new Dimension(1343, 878) );
		System.out.println("WEBPAGE");
		log.info("OPENING WEB PAGE");
		fd.get("http://10.41.57.141:8080/job/Monetization_Release-Test_ITE/lastSuccessfulBuild/buildNumber");
		fd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		/*WebElement user = fd.findElement(By.id("j_username"));
		user.clear();
		user.sendKeys("av16853");
		WebElement pwd = fd.findElement(By.name("j_password"));
		pwd.clear();
		pwd.sendKeys("av16853");
		fd.findElement(By.id("yui-gen1-button")).click();

		*/
		WebElement buildNoElement=fd.findElement(By.xpath("xhtml:html/xhtml:body/xhtml:pre"));
		String buildNo=buildNoElement.getText();
		fd.get(" http://10.41.57.141:8080/job/Monetization_Release-Test_ITE/"+buildNo+"//thucydidesReport/");
		log.info("TAKING SCREENSHOT");
		File src = ((TakesScreenshot) fd).getScreenshotAs(OutputType.FILE);
		try {
			System.out.println("copying file");
			log.info("COPYING FILE TO BELOW PATH");
			// now copy the screenshot to desired location using copyFile
			// //method
			long current_time =1;// System.currentTimeMillis();
			String imagefilepath = System.getProperty("user.dir") + SEP + "target"
					+ SEP + "selenium" + SEP + current_time + "REPORT.png";
			System.out.println(imagefilepath);
			FileUtils.copyFile(src, new File(imagefilepath));
			File f = new File(System.getProperty("user.dir") + SEP + "target"
					+ SEP + "selenium" + SEP + "report.html");
			File imageFile= new File(imagefilepath);
			String img=ImageEncode.imageToBase64String(imageFile);
					
			
			
			
			
			
			//System.out.println(img);
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		bw.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML Transitional//EN\"><META http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\">"+ System.getProperty("line.separator"));

			bw.write("<html>" + System.getProperty("line.separator"));
			bw.write("<head>" + System.getProperty("line.separator"));
			bw.write("<title>MonetizationReport</title>"
					+ System.getProperty("line.separator"));
			bw.write("</head>" + System.getProperty("line.separator"));
			bw.write("<body>" + System.getProperty("line.separator"));
					//bw.write("<img src=\"data:image/png;base64,"+img+"\" alt=\"Test Image\" />"
					//			bw.write("<img src=\"1REPORT.png\" alt=\"Test Image\" />"
				//	+ System.getProperty("line.separator"));
			bw.write("</body>" + System.getProperty("line.separator"));
			bw.write("</html>" + System.getProperty("line.separator"));
			bw.close();

		}

		catch (IOException e) {
			log.info("Exception found " + e.getMessage());
			System.out.println(e.getMessage());

		}

		fd.close();
		fd.quit();
		
		CsvHtml ch=new CsvHtml();
		//ch.findRowSpan(csvReport);
		ch.csvtoHTML();
		
	}
	
}
