package L7;

public class Test7 {

    static void Method(int timer){
        for (int i=0; i<timer; i++) {
        final int fi =i;
        new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() +" i = " + fi);
            }
        }).start();
    }}
    public static void main(String[] args) {

       Method(10);
       Method(2);
        }
}
