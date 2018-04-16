package L6;

//https://habrahabr.ru/post/277669/ - семафор

import java.util.concurrent.Semaphore;

public class Test6 {

    static Semaphore semaphore = new Semaphore(1);
    static void writeDataInDataBase() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " чекаемо симофор");
        semaphore.acquire();
        System.out.println(Thread.currentThread().getName() + " отримали симофор");

        //white in database...

        System.out.println("whiting in database...");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " симофор звільняється");
        semaphore.release();
        System.out.println(Thread.currentThread().getName() + " симофор отриманий ");

    }


    public static void main(String[] args) {
    for (int i=0; i<10; i++) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    writeDataInDataBase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println(Thread.currentThread().getName() + " створений");
    }
    }
}
