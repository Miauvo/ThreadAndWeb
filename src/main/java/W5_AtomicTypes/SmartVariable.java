package W5_AtomicTypes;

import java.util.Scanner;

public class SmartVariable {
    static String[]book = new String[]{
            "page 0: hello",
            "page 1: jhkhkjhkj",
            "page 2: jiuyouyoiyooj",
            "page 3: aaaaaaaaaaaa",
            "page 4: 444",
            "page 5: 888"
    };
    static int cout=0;
    public static void main(String[] args) {
        SmartObject<Integer> page = new SmartObject<>();
        page.getOnUpdate().add(() -> System.out.println(book[page.getValue()]));

        Runnable onAnimation= () -> System.out.println("animations");

        Runnable onFiveUpdate = () -> page.getOnUpdate().remove(onAnimation);

        Runnable onAnimationUpdate= () -> {
            cout++;
            if(cout==5) onFiveUpdate.run();
        };

        page.getOnUpdate().add(onAnimation);
        page.getOnUpdate().add(onAnimationUpdate);

        Scanner sc =new Scanner(System.in);

        while(true){
            int userPage = sc.nextInt();
            page.setValue(userPage);
        }
    }
}
