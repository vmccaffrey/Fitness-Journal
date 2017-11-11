/*
A series of posts under a single topic
	-every Thread object has a topic
	-store Post objects
	-format and display Post object data
	-only a certain number a Post objects can be viewed at once; scrollbar to view additional Post objects
		-Post objects over a limit are split up over additional pages
		-buttons to advance to next or previous page
		-button and textfield to jump to specific page
	-textfield and button to allow making new Post objects
	-button to return to the main Forum
	
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