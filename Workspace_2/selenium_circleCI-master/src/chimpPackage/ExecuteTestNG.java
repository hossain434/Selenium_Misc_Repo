package chimpPackage;

import java.util.List;

import org.testng.ITestNGListener;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

import chimpBasePackage.ChimpBaseClass;


/* public class ExecuteTestNG extends ChimpBaseClass{

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG objtng = new TestNG();
		List<String> suites = Lists.newArrayList();
		//path to testng xml..
		//String myCurrentDir1 = System.getProperty("user.dir") + File.separator+"testNG/" ;
		//System.out.println(" myCurrentDir1 " +  myCurrentDir1);
		String myCurrentDir ="../chimpProject/testNG/";
		System.out.println(myCurrentDir+"testngTestCode.xml");
		suites.add(myCurrentDir+"testngTestCode.xml");
		objtng.setTestSuites(suites);
		objtng.addListener((ITestNGListener)tla);
		objtng.run();
	}

} */
