package W3;

import java.util.concurrent.*;

public class W3{

    private static int sum(int []arr){
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        System.out.println(Thread.currentThread().getId());
    return sum;
    }

    static int result;
    public static void collable() throws ExecutionException, InterruptedException {
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

        private static void fututreTask() throws ExecutionException, InterruptedException {
        //new collable argument
            FutureTask<Integer> task = new FutureTask<Integer>(() -> sum(new int []{1,2,3,4,5,6,7,8,9,10}));
            //выполнение в том же потоке
            task.run();
            System.out.println("sum:" +task.get());
            //выполнение в новом потоке
            new Thread().start();
            System.out.println("sum:" +task.get() );
        }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        fututreTask();
        collable();
    }
}
