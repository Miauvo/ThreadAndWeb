package L3;

public class Test3 {

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

        }
    };

    public void start(int x) {
        this.x =x;
        Thread thread = new Thread(r);
        thread.start();
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        test3.start(5);
        test3.start(20);
        test3.start(2);
    }
}
