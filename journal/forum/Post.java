/*
A text message that consists of:
	-name of the user that submits the message
	-date and time the message was submitted
	-message text
*/
package forum;

public class Post {
	private String username;
	private String date;
	private String time;
	private String message;
	private boolean originalPost;

	public void setUsername(String n) {username = n;}
	public void setDate(String d) {date = d;}
	public void setTime(String t) {time = t;}
	public void setMessage(String m) {message = m;}
	public void setOriginalPost(boolean b) {originalPost = b;}
	
	public String getUsername() {return username;}
	public String getDate() {return date;}
	public String getTime() {return time;}
	public String getMessage() {return message;}
	public boolean getOriginalPost() {return originalPost;}
	
	public Post(String name, String date, String time, String message, boolean originalPost) {
		setUsername(name);
		setDate(date);
		setTime(time);
		setMessage(message);
		setOriginalPost(originalPost);
	}
}