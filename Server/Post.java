/*
A text message that consists of:
	-name of the user that submits the message
	-date and time the message was submitted
	-message text
*/

public class Post {
	private String username;
	private String date;
	private String time;
	private String message;
	
	public setUsername(String n) {username = n;}
	public setDate(String d) {date = d;}
	public setTime(String t) {time = t;}
	public setMessage(String m) {message = m;}
	
	public getUsername() {return username;}
	public getDate() {return date;}
	public getTime() {return time;}
	public getMessage() {return message;}
	
	public Post(n, d, t, m) {
		setUsername(n);
		setDate(d);
		setTime(t);
		setMessage(m);
	}
}