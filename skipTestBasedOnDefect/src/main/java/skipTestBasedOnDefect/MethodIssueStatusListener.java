package skipTestBasedOnDefect;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import skipTestBasedOnDefect.UserRegistrationTest.Issue;

public class MethodIssueStatusListener implements IInvokedMethodListener {

    @Override
    public void afterInvocation(IInvokedMethod invokedMethod, ITestResult result) {
        
        Issue issue = invokedMethod.getTestMethod()
                                    .getConstructorOrMethod()
                                    .getMethod()
                                    .getAnnotation(Issue.class);
            
        if (null != issue) {
            if(IssueStatus.OPEN.equals(IssueTrackerUtil.getStatus(issue.value()))){
                switch(result.getStatus()){
                    case ITestResult.FAILURE:
                            // no need to fail as we might have expected this already.
                            result.setStatus(ITestResult.SKIP);  
                            break;
                            
                    case ITestResult.SUCCESS:
                            // It is a good news. We should close this issue.
                            IssueTrackerUtil.updateStatus(issue.value(), IssueStatus.CLOSED);
                            break;
                }
            }
        }
    }

    @Override
    public void beforeInvocation(IInvokedMethod invokedMethod, ITestResult result) {
        // nothing to do
    }

}