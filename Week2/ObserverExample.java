/**
 * @author		DJ Kim <djkim@cs.ucla.edu>
 *
 * CS 130 Fall 2016
 *
 * Created to illustrate a real-life example of Observer Design Pattern
 * Users who are following a group post get notification when the post 
 * gets new like / comment.
 *
 */

// subject
public interface FacebookPost {
	public void registerObserver(FacebookUser user);
	public void removeObserver(FacebookUser user);
	public void notifyObservers();
}

// observer
public interface FacebookUser {
	public void update();
}


// concreteSubject
public class FacebookGroupPost implements FacebookPost {
	private ArrayList<FacebookUser> followers = new ArrayList();

	public void registerObserver(FacebookUser follower) {
		followers.add(follower);
	}

	public void removeObserver(FacebookUser user) {
		followers.remove(follower);
	}

	public void notifyObservers(String message) {
		for (FacebookUser follower : followers) {
			follower.update(message);
		}
	}

	// notification sent when someone likes the post
	public void newLike() {
		notifyObservers("New Like");
	}

	// notification sent when someone comments on the post
	public void newComment() {
		notifyObservers("New comment");
	}
}

// concreteObserver
public class FacebookGroupMember implements FacebookUser {
	public void update(String message) {
		// You got a new notification! Notification bar has been updated
		createNotification(message);
	}
}