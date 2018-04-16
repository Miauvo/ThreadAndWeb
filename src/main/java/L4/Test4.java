package L4;

public class Test4 {

    int x=0;
    Runnable r = new Runnable(){
        public void run() {
            int seconds=0;
            while (x>seconds){
                try {
                    Thread.sleep(1000); //1 sec
                    System.out.println(Thread.currentThread().getName()+"\t"+x--);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
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
        Test4 test3 = new Test4();
        try {
            test3.start(5);

            test3.start(20);

            test3.start(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
