/*
A series of threads
	-store Thread objects
*/
package forum;

public class Forum {
	private java.util.List<Thread> forum = new java.util.ArrayList<Thread>();

	public java.util.List<Thread> getForum() {return forum;}

	public Thread getThread(int id) {
		for(Thread thread : forum) {
			if(thread.getID() == id) {
				return thread;
			}
		}
		return null;
	}

	public void createThread(String subject, String username, String date, String time, String message, int id) {
		Post post = new Post(username, date, time, message, true);
		Thread thread = new Thread(subject, post, id);
		forum.add(thread);
	}
	public void createPost(Thread thread, String username, String date, String time, String message) {
		Post post = new Post(username, date, time, message, false);
		thread.getThread().add(post);
	}
}