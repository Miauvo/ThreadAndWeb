package L2;

public class Test2 {
    public static void main(String[] args) {

       Runnable r = new Runnable(){
            public void run() {
                int i=0;
                while (true){
                    try {
                        Thread.sleep(1000); //1 sec
                        System.out.println(i++);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }

            }
        };

        Thread thread = new Thread(r);
        thread.start();
    }
}
