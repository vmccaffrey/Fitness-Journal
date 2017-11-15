/*
A series of posts under a single topic
	-every Thread object has a topic
	-each thread is created with a single original post
	-store Post objects
*/
package forum;

public class Thread {
	private java.util.List<Post> topicThread = new java.util.ArrayList<Post>();
	private String subject;
	private String username;
	private String date;
	private String time;
	private int id;

	public java.util.List<Post> getThread() {return topicThread;}
	public String getSubject() {return subject;}
	public String getUsername() {return username;}
	public String getDate() {return date;}
	public String getTime() {return time;}
	public int getID() {return id;}

	public void newPost(Post post) {topicThread.add(post);}
	
	public Thread(String subject, Post op, int id) {
		this.subject = subject;
		this.username = op.getUsername();
		this.date = op.getDate();
		this.time = op.getTime();
		this.id = id;
		topicThread.add(op);
	}
}