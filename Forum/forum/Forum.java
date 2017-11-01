/*
A series of threads
	-store Thread objects
*/
package forum;

public class Forum {
	private java.util.List<Thread> forum = new java.util.ArrayList<Thread>();

	public java.util.List<Thread> getForum() {return forum;}

	public void createThread(String subject, String username, String date, String time, String message) {
		Post post = new Post(username, date, time, message, true);
		Thread thread = new Thread(subject, post);
		forum.add(thread);
	}
	public void createPost(Thread thread, String username, String date, String time, String message) {
		Post post = new Post(username, date, time, message, false);
		thread.getThread().add(post);
	}
}