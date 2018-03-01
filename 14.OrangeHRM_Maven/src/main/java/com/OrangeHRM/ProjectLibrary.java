package com.OrangeHRM;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ProjectLibrary {
static	WebDriver driver;
	public static void open_Browser() throws Throwable{
		System.setProperty("webdriver.chrome.driver", "D:\\Vikram Selenium\\5.BrowserDrivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		 LogFile.writeIntoLogFile("Chrome browser launched successfully");
	}
	
	public static void access_Application() throws Throwable{
		driver.get("http://apps.qaplanet.in/qahrm/login.php");
		LogFile.writeIntoLogFile("Application access Successfull");

	}
	
	public static void user_Login() throws Throwable{
		WebElement userName = driver.findElement(By.name("txtUserName"));
		WebElement password = driver.findElement(By.name("txtPassword"));
		WebElement login = driver.findElement(By.name("Submit"));

		// statements to perform login action
		userName.sendKeys("qaplanet1");
		password.sendKeys("lab1");
		login.click();
		Thread.sleep(5000);
		LogFile.writeIntoLogFile("Login Successfull");
	}
	
	public static void user_Logout() throws Throwable{
		WebElement logout = driver.findElement(By.linkText("Logout"));
		logout.click();
		LogFile.writeIntoLogFile("Logout successfull");
	}
	
	public static void close_Browser() throws Throwable{
		driver.quit();	
		LogFile.writeIntoLogFile("Browser closed Successfully");
	}
	
	
  public static void add_Employee() throws Throwable{

		// ++++++Add employee++++++
		// +++++++++Actions class+++
		Actions mouse = new Actions(driver);
		mouse.moveToElement(driver.findElement(By.linkText("PIM"))).perform();
		Thread.sleep(1000);
		mouse.moveToElement(driver.findElement(By.linkText("Add Employee"))).perform();
		Thread.sleep(1000);
			
		mouse.click(driver.findElement(By.linkText("Add Employee"))).perform();

		// Sitching into frame
		driver.switchTo().frame("rightMenu");
		driver.findElement(By.name("txtEmpLastName")).sendKeys("nami");
		driver.findElement(By.name("txtEmpFirstName")).sendKeys("Vikram");
		driver.findElement(By.name("photofile")).click();
		Thread.sleep(1000);

		// code for file upload from the window --using Robot class
		// robot class will simulate the keyboard options

		// statement to Copy the given string to the system clip board(Control+C)
		StringSelection ss = new StringSelection("C:\\Users\\vikra\\Pictures\\iphone pics\\IMG_0835.JPG");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		
		//++++++Robot Class+++++++
		// initiating the robot class to simulate the keyboard operations present in awt
		// package(java)
		// awt -stands for-ABSTRACT WINDOW TOOLKIT
		Robot r = new Robot();
		// pressing control +C keys on keyboard
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		// releasing control+C keys on keyboard
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		// pressing the enter key on keyboard
		r.keyPress(KeyEvent.VK_ENTER);
		// releasing the Enter key on keyboard
		r.keyRelease(KeyEvent.VK_ENTER);

		driver.findElement(By.id("btnEdit")).click();
		Thread.sleep(5000);

		// to capture the newly generated Employee Code/id
		String EmployeeId = driver.findElement(By.id("txtEmployeeId")).getAttribute("value");
		System.out.println("The New employee Id is : " + EmployeeId);

		// switching back to the default frame
		driver.switchTo().defaultContent();

	   LogFile.writeIntoLogFile("Add employee Succesffull with new id : "+EmployeeId);
  }
  
  
  public static void delete_Employee() throws Throwable {
		// delete employee
		// +++++++++Actions class+++
		Actions mouse = new Actions(driver);
		mouse.moveToElement(driver.findElement(By.linkText("PIM"))).perform();
		Thread.sleep(1000);
		mouse.moveToElement(driver.findElement(By.linkText("Employee List"))).perform();
		Thread.sleep(1000);
		mouse.click(driver.findElement(By.linkText("Employee List"))).perform();

		// Sitching into frame
		driver.switchTo().frame("rightMenu");
		
		String EmployeeCodeToBeDeleted="2993";
		//to get the row count of a table
		int rc=driver.findElements(By.xpath("//form[@name='standardView']/table/tbody/tr")).size();
		System.out.println(rc);
		
		
		
		//to get the Employee id from the second column of all rows in the table
		//and verify with the given employee id to be deleted and exit the loop after deletion
		
    //note as the number of rows get deleted  we have to use <rc-1> in loop
		for(int j=1; j<=rc-1;j++) {
			String EmployeeID=driver.findElement(By.xpath("//form[@name='standardView']/table/tbody/tr[" +j+ "]/td[2]")).getText();
			System.out.println(EmployeeID);
			
			if(EmployeeID.equals(EmployeeCodeToBeDeleted)) {
				driver.findElement(By.xpath("//form[@name='standardView']/table/tbody/tr[" +j+ "]/td[1]/input")).click();
				driver.findElement(By.xpath("//input[@class='plainbtn'][@value='Delete']")).click();
              System.out.println("employee delteted");
              
             break;				
			}
		}
		

		
		//switching back to the default frame
		driver.switchTo().defaultContent();
		LogFile.writeIntoLogFile("Delete Employee Successfull");
  }

}
