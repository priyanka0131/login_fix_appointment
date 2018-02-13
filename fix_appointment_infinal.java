package testingibet36;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class fix_appointment_infinal {

		public static void main(String[] args) throws InterruptedException, AWTException
		{
			System.setProperty("webdriver.chrome.driver", "/home/aj/Music/chromedriver");
			WebDriver driver=new ChromeDriver();
	//========================================open the erp=======================================================================================		
			    driver.navigate().to("https://myswaastherp.sia.co.in");
	//==============================================login in erp==================================================================================		    
			    driver.findElement(By.xpath("(//*[@href='/login'])[1]")).click();
		        Thread.sleep(8000);
		        driver.findElement(By.xpath("(//*[@formcontrolname='email'])")).sendKeys("username");
		        driver.findElement(By.xpath("(//*[@formcontrolname='password'])")).sendKeys("password");
		        driver.findElement(By.xpath("(//*[@class='ui-button-text ui-clickable'])[2]")).click();
		        Thread.sleep(8000);	
		   //================================================location copy========================================================================     
		        String p=driver.findElement(By.xpath("(//*[@class='clinic_address text-right'])")).getText();
	//====================================================open thye new tab=======================================================================	     
		        Robot r=new Robot();
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_T);
				r.keyRelease(KeyEvent.VK_CONTROL);
				r.keyRelease(KeyEvent.VK_T);
	//====================================================handle the to tabs======================================================================		
				Set<String> set= driver.getWindowHandles();
				Iterator<String> it = set.iterator();
		        String parentwindowid= it.next();
		        String childwindowid= it.next();
	//==================================================switch to final tab=======================================================================	        
		        driver.switchTo().window(childwindowid);
		        Thread.sleep(5000);
		        driver.navigate().to("https://myswaasthfinal.sia.co.in/");
	//==================================================login in final tab========================================================================	        
	            driver.findElement(By.xpath("(//*[@class='ui-button-text ui-clickable'])[1]")).click();
			    driver.findElement(By.xpath("(//*[@placeholder='Email Address'])")).sendKeys("username");
		        driver.findElement(By.xpath("(//*[@type='password'])")).sendKeys("password");
			    driver.findElement(By.xpath("(//*[@type='text'])[2]")).click();
				Thread.sleep(5000); 
	//============================================select consult=================================================
				driver.findElement(By.xpath("(//*[@class='text-center'])[2]")).click();
	//============================================select all text and delete in location =================================================      
		        Thread.sleep(5000);
				driver.findElement(By.xpath("(//*[@class='city_name'])")).click();
		        Thread.sleep(1000);
		        WebElement toClear = driver.findElement(By.xpath("(//*[@id='global_autocomplete'])"));
		        toClear.sendKeys(Keys.CONTROL + "a");
		        toClear.sendKeys(Keys.DELETE);
		        Thread.sleep(5000);
	//======================================================paste location text====================================================================	        
		        driver.findElement(By.xpath("(//*[@id='global_autocomplete'])")).sendKeys(p);
				Thread.sleep(8000);
		        driver.findElement(By.xpath("(//*[@class='pac-matched'])[1]")).click();
		        Thread.sleep(5000);
	//=============================================================================================================================================
		        driver.switchTo().window(parentwindowid);
		        Thread.sleep(8000);
	//==================================================copy Speciality============================================================================	        
			    String  s=driver.findElement(By.xpath("//*[@class='doc_speciality']")).getText();				
	//=============================================================================================================================================
		        driver.switchTo().window(childwindowid);
	//===================================input doctors Speciality================================================================================================	        
		        Thread.sleep(7000);
		        driver.findElement(By.xpath("(//*[@class='text-center'])[3]")).click();
		        driver.findElement(By.xpath("(//*[@routerlinkactive='active'])[9]")).click();
		        Thread.sleep(8000);
		        driver.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys(s);
		        Thread.sleep(5000);
		        driver.findElement(By.xpath("(//*[@class='ui-g-11 list_name'])[1]")).click();
	//=============================================apply filter====================================================================================	        
		        driver.findElement(By.xpath("(//*[@label='Apply Filters'])")).click();
		        Thread.sleep(5000);
		        driver.findElement(By.xpath("(//*[@class='ui-button-text ui-clickable'])[3]")).click();
	//===============================================select date===================================================================================        
		        Thread.sleep(5000);
		        driver.findElement(By.xpath("(//*[@placeholder='Select date'])[1]")).click();
		        driver.findElement(By.linkText("17")).click();
	//=======================================================select time===========================================================================       
		        Thread.sleep(5000);
		        driver.findElement(By.xpath("(//*[@class='ui-g-9 ui-g-nopad'])[6]")).click();  
	//================================================fixed appointment=============================================================================================
		        Thread.sleep(5000);
		        driver.findElement(By.xpath("(//*[@class='ui-button-text ui-clickable'])[1]")).click();
		        driver.findElement(By.xpath("(//*[@label='continue'])")).click();
		        Thread.sleep(5000);
	//================================================get the id of appointment ==================================	       
		        String I =driver.findElement(By.xpath("(//*[@class='ui-g-10 ui-md-10 ui-lg-10 appointment_details'])")).getText();
		        System.out.print(I);
	//=============================================appointment done==================================================================	       
		        Thread.sleep(5000);
		        driver.findElement(By.xpath("(//*[@label='done'])")).click();
		        driver.findElement(By.xpath("(//*[@class='text-center'])[6]")).click();
		        Thread.sleep(8000);
	//============================================click on my appointment============================================	        
		        driver.findElement(By.xpath("(//*[@routerlinkactive='active'])[8]")).click();
	//===========================================get data of appointment id =====================================================	        
		        Thread.sleep(5000);
		        String D =driver.findElement(By.xpath("(//*[@class='bule-text'])[3]")).getText();
			    System.out.println(D);    

	}

}
