package test;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.ITestContext;

public class TestListeners implements ITestListener 
{

	Logger tstlog = (Logger) LogManager.getLogger(SiteTest.class);

    public void onFinish(ITestContext Result){
    	tstlog.info("Test is finished: "+ Result.getName());
    }		
	
    public void onStart(ITestContext Result){						  		
    }		
	
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0){
    }		
	
    public void onTestFailure(ITestResult Result){
    }		

    public void onTestSkipped(ITestResult Result) {
    }		

    public void onTestStart(ITestResult Result) {
    }		

    public void onTestSuccess(ITestResult Result) {
    }
}
