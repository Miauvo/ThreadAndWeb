package L5;

public class Test5 {

    int x=0;
    Runnable r = new Runnable(){
        public void run() {
            int seconds=0;
            while (x>seconds)
                System.out.println(Thread.currentThread().getName()+"\t"+x--);

            System.out.println("------------------");
        }
    };

    public void start(int x) throws InterruptedException {
        this.x =x;
        Thread thread = new Thread(r);
        thread.start();
        thread.join();

    }

    public static void main(String[] args) {
        Test5 test3 = new Test5();
        try {
            test3.start(5);

            test3.start(20);

            test3.start(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
