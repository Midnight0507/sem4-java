public class shareThread{
	public static void main(String[] args) {
		counter C = new counter();
		Thread thr0 = new Thread(C);
		Thread thr1 = new Thread(C);
		Thread thr2 = new Thread(C);
		thr0.start();
		thr1.start();
		thr2.start();
	}
}