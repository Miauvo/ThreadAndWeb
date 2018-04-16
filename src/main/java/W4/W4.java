package W4;
//Отслеживание потоков
public class W4 {
    public  static void download (Runnable onComplete){
        System.out.println("start download");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end download");
        onComplete.run();
    }

    public static void main(String[] args) {
        Runnable onComlpete =()-> {
            System.out.println("file done");
        };
        Runnable onComlpete2 =()-> {
            System.out.println("file done2");
        };
        //cобытие
        Runnable downloadInThread =()-> {download(onComlpete);};//доставить 2
        new Thread(downloadInThread).start();



    }
}
