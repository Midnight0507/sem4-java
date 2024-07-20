import java.lang.Thread;

class Chat {

	static int GroupMembers = 5; 

	boolean flag = true;
	int counter = 0;

	public synchronized void Question(String ques) throws InterruptedException{
		if (!flag) {
			wait();
		}
		System.out.println(Thread.currentThread().getName()  + " Question: " + ques + counter);
		flag = false;
		notifyAll();
	}

	public synchronized void Answer(String ans) {
		try {
			if (flag) {
				wait();
			}
			counter += 1;
			System.out.println(Thread.currentThread().getName()  + " Answer: " + ans + counter);
			if (counter == GroupMembers) {
				counter = 0;
				flag = true;
				notifyAll();
			}
		} catch(InterruptedException e) {
			System.out.println(e);
		}	
	}
}

class QRunnable implements Runnable {

	Chat chat;

	QRunnable(Chat ChatObject ) {
		this.chat = ChatObject;
	}

	@Override
	public void run() {
		try{
			for(int i = 0;i < 19; i++) {
				chat.Question("Hi , How are you?");
			}
		} catch(InterruptedException e) {
			System.out.println(e);
		}
		
	}
}


class ARunnable implements Runnable {

	Chat chat;

	ARunnable(Chat ChatObject ) {
		this.chat = ChatObject;
	}

	@Override
	public void run() {
		for(int i = 0;i < 100; i++) {
			chat.Answer("I am good. How are you?");
		}
	}
}

 public class ChatBot {
	public static void main(String[] args) {
		Chat chat = new Chat();

		QRunnable question = new QRunnable(chat);
		ARunnable answer = new ARunnable(chat);

		Thread quesitonThread = new Thread(question);
		Thread answerThread = new Thread(answer);

		quesitonThread.start();
		answerThread.start();
	}
}