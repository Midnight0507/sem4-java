import java.lang.Thread;
import java.util.*;

public class questionAnswer {

	boolean flag = false;

	public static void main(String[] args) {
		Chat m = new Chat();

		T1 answer = new T1();
		T2 question = new T2();
	}

}

class T1 implements Runnable {
	Chat chat;

	T1(Chat m1) {
		this.chat = m1;
	}

	@Override
	public void run() {
		System.out.println("Entered thread " + Thread.currentThread().getName());
		chat.Answer("Hello, I am good.");
	}
}

class T2 implements Runnable {
	Chat chat;

	T2(Chat m1) {
		this.chat = m1;
	}

	@Override
	public void run() {
		System.out.println("Entered thread " + Thread.currentThread().getName());
		chat.Question("Hi, How are you ?");
	}
}

class chat {
	public synchronized void Question(String msg) {
		if (flag) {
			try {
				wait();
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "Question Thread" + msg);
		flag = true;
		notify();
	}

	public synchronized void Answer(String msg) {
		if (!flag) {
			try {
				wait();
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "Answer Thread" + msg);
		flag = false;
		notify();
	}
}