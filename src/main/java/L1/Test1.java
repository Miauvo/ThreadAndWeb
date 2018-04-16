package L1;

public class Test1 {
    public static void main(String[] args) {
        Runnable r = new Runnable(){
            public void run() {
                System.out.println("Второй - дополнительный поток");
            }
        };

        Thread thread = new Thread(r);
    }
}
