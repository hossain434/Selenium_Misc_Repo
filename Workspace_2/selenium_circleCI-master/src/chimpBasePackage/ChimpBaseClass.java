package chimpBasePackage;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import chimpPackage.ReadData;
import chimpPackage.Waitforanelement;
import chimpPackage.WriteData;

public class ChimpBaseClass {
	//global variable declare to read a file
	public ReadData objBDReadFile = new ReadData();
	//global variable declared to write a file
	public WriteData objWriteFile = new WriteData();
	//global variable declared to read property files
	public Properties prop = new Properties();
	//global variable declared to read an input stream - mainly used along with properties
	public InputStream input = null;
	//To Wait for an element
	public static Waitforanelement objWaitforanelement=new Waitforanelement();
	//To list down the status of different modules
	public static Map<Integer,String> hashlistModule= new LinkedHashMap<Integer,String>();
	//To be used to before sending email to consolidate the results
	public static Map<String, String> lstResultStatus = new LinkedHashMap<String, String>();
	public String strBrowsertype,strOutputzipfile,strSourcefolder,strFirefoxDriver,strBaseUrlDev,strBaseUrlStage,strChromeDriver;
	//To Backup the results in the previous run
	//To define Capblities for Webdriver
	public DesiredCapabilities capability;
	//To wait and locate element through out the suite
	public By byElement;
	//Browser Stack Details
	public static String USERNAME;
	public static  String AUTOMATE_KEY;
	public static String URL;
	public String strBSPlatform;
	public String strBSBrowserVersion,strBSSeleniumversion;
		
}
