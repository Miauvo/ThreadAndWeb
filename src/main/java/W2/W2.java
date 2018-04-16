package W2;

import java.util.concurrent.*;


public class W2 {
    private static int sum(int []arr){
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        return sum;
    }

    static int result;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(1);
        int []arr = {0,1,2,3,4,5,6,7,8,9};

        //1
        Runnable r = new Runnable() {
            @Override
            public void run() {
                int result1 = sum(arr); //обработка в потоке
                result = sum(arr); //обработка в потоке и передача результата
            }
        };
        Thread th = new Thread(r);
        th.start();
        th.join();//Заккоментировать
        System.out.println("сумма:" + result);

        //2
        Future futureRannoble = service.submit(r);
        futureRannoble.get(); // генерирует exeption, ждет выполнения потока
        System.out.println("сумма:" + result);


        Callable<Integer> c = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return sum(arr); //обработка в потоке
            }
        };
        Future<Integer> futureCollable = service.submit(c);
        System.out.println("сумма:" +futureCollable.get());

    }
}

