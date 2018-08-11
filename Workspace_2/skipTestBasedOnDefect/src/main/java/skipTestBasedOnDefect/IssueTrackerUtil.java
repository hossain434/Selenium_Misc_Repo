package skipTestBasedOnDefect;

import org.apache.http.entity.ContentType;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class IssueTrackerUtil {

    private static final String ISSUE_TRACKER_API_BASE_URL = "https://api.github.com/repos/username/dummy-project/issues/";
    private static final String ISSUE_TRACKER_USERNAME = "username";
    private static final String ISSUE_TRACKER_PASSWORD = "password";
    
    public static IssueStatus getStatus(String issueID) {
        String githubIssueStatus = "CLOSED";
        try {
            githubIssueStatus = Unirest.get(ISSUE_TRACKER_API_BASE_URL.concat(issueID))
                                       .asJson()
                                       .getBody()
                                       .getObject()
                                       .getString("state")
                                       .toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IssueStatus.valueOf(githubIssueStatus);
    }

    public static void updateStatus(String issueID, IssueStatus status) {
        try {
            
            Unirest.post(ISSUE_TRACKER_API_BASE_URL.concat(issueID).concat("/comments"))
                    .header("accept", ContentType.APPLICATION_JSON.toString())
                    .basicAuth(ISSUE_TRACKER_USERNAME, ISSUE_TRACKER_PASSWORD)
                    .body("{ \"body\" : \" testng method passed now. closing automatically.\" }")
                    .asJson();
            
            Unirest.patch(ISSUE_TRACKER_API_BASE_URL.concat(issueID))
                    .header("accept", ContentType.APPLICATION_JSON.toString())
                    .basicAuth(ISSUE_TRACKER_USERNAME, ISSUE_TRACKER_PASSWORD)
                    .body("{ \"state\" : \""+ status.toString().toLowerCase() + "\" }")
                    .asJson();
            
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
    
}