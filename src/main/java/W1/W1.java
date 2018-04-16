package W1;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class W1 {
    public static void main(String[] args) {
        //Пулл потоков
        //сколько потоков
        ExecutorService service = Executors.newFixedThreadPool(2);

        for (int i = 0; i <20 ; i++) {
            service.submit(() -> {//відправка завдання на виконання
                System.out.println("Thread pool, current thead:" + Thread.currentThread().getName());
                //return 0;  -с пулом сработает
            });
        }
        service.shutdown(); //остановить програму как все потоки с пула отработают
        // service.shutdownNow(); //остановить програму как только 1й поток к даной задаче подойдет.
    }
    //можно потоку выставить больший приоритет, тогда система будет больше ресурсов отдаавать потоку.
    //если поток выполнил задачу, он спит
}


