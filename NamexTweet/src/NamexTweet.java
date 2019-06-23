import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class NamexTweet {
    private final static String CONSUMER_KEY = "hOuhpkzRfSODwzH0uZVzef1aH";
    private final static String CONSUMER_KEY_SECRET = "OOjFIP8nn24X3Rjgv9MvvvMJoygxUXDq2XadRqxUEWhb9dWeWC";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("Hello guys. nama saya Dondo. salam knal smua. ok :)");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "vwjJbdEczVz3ayeiCHQ6nCknzA1itKAVI2ZCAclhTWcQ3";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "1140531101032570885-DSIOqA5HIMlH3GM1jJoDpFY3QtLjLD";
    }

    public static void main(String[] args) throws Exception {
	new NamexTweet().start();
    }
}