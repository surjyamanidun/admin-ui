package io.mosip.testrig.adminui.testcase;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
// Generated by Selenium IDE
//import org.junit.Test;
//import org.junit.Before;
//import org.junit.After;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.paulhammant.ngwebdriver.NgWebDriver;

import io.mosip.testrig.adminui.utility.BaseClass;
import io.mosip.testrig.adminui.utility.Commons;
import io.mosip.testrig.adminui.utility.JsonUtil;
public class DeviceTest extends BaseClass{
   @Test(groups = "D")
  public void deviceCRUD() throws InterruptedException {
	   String validityDate;
	try {
		validityDate = JsonUtil.JsonObjParsing(Commons.getTestData(),"validityDate");
		 test=extent.createTest("DeviceTest", "verify Login");
	   Commons.click(test,driver,By.id("admin/resources"));
	   Commons.click(test,driver,By.id("/admin/resources/devices"));
	   Commons.click(test,driver,By.id("Create Device"));
	   test.log(Status.INFO, "Click on Create Device");
	   
	   Commons.enter(test,driver, By.id("name"),data);
	   Commons.enter(test,driver, By.id("serialNumber"),data);

	   Commons.enter(test,driver, By.id("macAddress"),"1.1234");
	   test.log(Status.INFO, "Enters MACAddress");
 
	   Commons.enter(test,driver, By.id("ipAddress"),"2.2345");
	//   Commons.enter(test,driver, By.id("validity"),validityDate);
      Commons.calendar(validityDate);
    Commons.dropdown(test,driver,By.id("deviceSpecId"));
    try{   Commons.dropdown(test,driver, By.id("zone"));
	 
	 }catch(Exception e) {
		 test.log(Status.INFO, e);
	 }
      Commons.dropdown(test,driver,By.id("regCenterId"));
      

      	Commons.createRes(test,driver);
      	test.log(Status.INFO, "Click on Create");
     	Commons.filter(test,driver, By.id("name"), data);
     	

     	Commons.editRes(test,driver,data+1,By.id("name"));
     	Commons.filter(test,driver, By.id("name"), data+1);
     	
     	Commons.activate(test,driver);
     	test.log(Status.INFO, "Click on Activate");
     	Commons.editRes(test,driver,data+2,By.id("name"));
     	Commons.filter(test,driver, By.id("name"), data+2);
     	Commons.deactivate(test,driver);
     	Commons.decommission(test,driver);
     	test.log(Status.INFO, "Click on Decommission");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     	
    }
  }
