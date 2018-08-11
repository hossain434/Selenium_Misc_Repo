package main.java.elasticsearch_Kibana_On_Docker1;

import java.time.LocalDateTime;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExecutionListener implements ITestListener {

    private TestStatus testStatus;

    public void onTestStart(ITestResult iTestResult) {
        this.testStatus = new TestStatus();
    }

    public void onTestSuccess(ITestResult iTestResult) {
        this.sendStatus(iTestResult,"PASS");
    }

    public void onTestFailure(ITestResult iTestResult) {
        this.sendStatus(iTestResult,"FAIL");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        this.sendStatus(iTestResult,"SKIPPED");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        //skip
    }

    public void onStart(ITestContext iTestContext) {
        //skip
    }

    public void onFinish(ITestContext iTestContext) {
        //skip
    }

    private void sendStatus(ITestResult iTestResult, String status){
        this.testStatus.setTestClass(iTestResult.getTestClass().getName());
        this.testStatus.setDescription(iTestResult.getMethod().getDescription());
        this.testStatus.setStatus(status);
        this.testStatus.setExecutionDate(LocalDateTime.now().toString());
        ResultSender.send(this.testStatus);
    }

}