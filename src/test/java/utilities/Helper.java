package utilities;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {
	
	public static void captureScreenshots(WebDriver driver, String Screenshotname)
	{
		
		Path dest=Paths.get("/Screenshots",Screenshotname+".png");
		try {
			
			
			Files.createDirectories(dest.getParent());
			FileOutputStream out=new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			out.close();
			
		} catch (Exception e) {
			
			
			System.out.println("Exception while taking screenshot"+e.getMessage());
				}
	}
	
	
	static public Integer AdjustLength(WebElement element)
	{
		String temp=element.getText();
		String tempnumber="";
		
		for (int i = 0; i <temp.length(); i++)
			{
				int charc=temp.charAt(i);
				if(charc>48 && charc<58 )
				{
					tempnumber=tempnumber+temp.charAt(i);
				}
			}
		
		return Integer.parseInt(tempnumber);
	}

}
