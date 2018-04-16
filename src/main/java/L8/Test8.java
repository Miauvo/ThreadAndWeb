package L8;

public class Test8 {

    static Thread Method(final int timer){
        Thread thread = new Thread(new Runnable() {
            public void run() {
                int time = timer;
                while (time>0)
                System.out.println(Thread.currentThread().getName() + "\t" +time--);
            }
        });
        thread.start();
    return thread;
    }
    public static void main(String[] args) {

        Method(5);

        try {
            Method(10).join();
            Method(2).join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
