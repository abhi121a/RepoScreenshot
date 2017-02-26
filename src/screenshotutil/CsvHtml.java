package screenshotutil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CsvHtml {
	String SEP= System.getProperty("file.separator");

	//String csvReport="http://10.41.57.141:8080/job/Monetization_Release-Test_ITE/ws/target/site/serenity/result.csv";
	//String csvReport=System.getProperty("user.dir") + SEP + "target"+SEP + "site" + SEP + "serenity" + SEP+"result.csv";
	//static String csvReport="D:\\BDD_Project\\Monetization-Automation\\target\\site\\serenity\\results.csv";
	String csvReport=SEP+"var"+SEP+"lib"+SEP+"jenkins"+SEP+"workspace"+SEP+"Monetization_Release-Test_ITE"+SEP+"target"+SEP+"site"+SEP+"serenity"+SEP+"results.csv";
	
	
	
	public void csvtoHTML(){
		System.out.println(csvReport);
		String line = null;
		int count =0;
		String testname=null;
		String temp=null;
		
		try {
			File f = new File(System.getProperty("user.dir") + SEP + "target"
					+ SEP + "selenium" + SEP + "report.html");
			System.out.println(System.getProperty("user.dir") + SEP + "target"
					+ SEP + "selenium" + SEP + "report.html");
					BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML Transitional//EN\"><META http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\">"+ System.getProperty("line.separator"));

				bw.write("<html>" + System.getProperty("line.separator"));
				bw.write("<head>" + System.getProperty("line.separator"));
				bw.write("<title>MonetizationReport</title>"
						+ System.getProperty("line.separator"));
				bw.write("</head>" + System.getProperty("line.separator"));
				bw.write("<body>" + System.getProperty("line.separator"));
				bw.write("<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"1\" align=\"center\">" + System.getProperty("line.separator"));
			
			BufferedReader br = null;
			
			
			
			br = new BufferedReader(new FileReader(csvReport));
			while ((line = br.readLine()) != null) {
				count++;
				
				bw.write("<tr>"+ System.getProperty("line.separator"));
				line = line.replaceAll("\"", "");
				String[] data = line.split(",");
		
				
				for(int i=0;i<data.length;i++){
					if(count==1){
						bw.write("<th>" + System.getProperty("line.separator"));
						bw.write(data[i] + System.getProperty("line.separator"));
						bw.write("</th>" + System.getProperty("line.separator"));
					}
					else
					{
					bw.write("<td>" + System.getProperty("line.separator"));
					bw.write(data[i] + System.getProperty("line.separator"));
					bw.write("</td>" + System.getProperty("line.separator"));
					}	
				}
				bw.write("</tr>"+ System.getProperty("line.separator"));
				
				
	}br.close();
	bw.write("</table>" + System.getProperty("line.separator"));
	bw.write("</body>" + System.getProperty("line.separator"));
	bw.write("</html>" + System.getProperty("line.separator"));
	bw.close();

			}
		
			catch (Exception e) {
				// TODO: handle exception
			}
}
	
	public void findRowSpan(String file) throws IOException{
		String line;
		String testname;
		String temp=null;
		ArrayList<Integer> al = new ArrayList<>();
		int count=0;
		int x=0;
		BufferedReader br = new BufferedReader(new FileReader(csvReport));
		while ((line = br.readLine()) != null) {
			
			line=line.replaceAll("\"", "");
			testname=line.split(",")[0];
			while(!testname.equalsIgnoreCase(temp)){
				al.add(count);
				count=1;
				x++;
				temp=testname;
			}
			count++;
			System.out.println(count);
				System.out.println(al.toString());
			
		}al.add(count);
		System.out.println(al.toString());
		
	}
}
