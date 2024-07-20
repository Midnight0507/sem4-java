// package threading;
class counter3 implements Runnable{
    public void run(){
        for(int i=0; i<100;i++){
            System.out.println(i);
            System.out.println("THREAD NAME :    "+Thread.currentThread().getName());
            
        }
    }
}
class counter1 implements Runnable{
    public void run(){
        for(int i=500; i<1000;i++){
            System.out.println(i);
            System.out.println("THREAD NAME :    "+Thread.currentThread().getName());

            
        }
    }
}
class counter2 implements Runnable{
    public void run(){
        for(int i=2000; i<3000;i++){
            System.out.println(i);
            System.out.println("THREAD NAME :    "+Thread.currentThread().getName());

            
        }
    }
}
//tast1 1-100
//task2 500-1000
//task3 2000-3000
public class thread{
    public static void main(String[] args) {
        counter3 c = new counter3();
        counter1 c1 = new counter1();
        counter2 c2 = new counter2();


        Thread t = new Thread(c,"T0");
        Thread t1 = new Thread(c1,"T1");
        Thread t2 = new Thread(c2,"T2");

        t.start();
        t1.start();
        t2.start();

    }
}