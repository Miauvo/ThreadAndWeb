package W5_AtomicTypes;

import java.util.ArrayList;

public class SmartObject<T> {
    private ArrayList<Runnable> onUpdate = new ArrayList<>();
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
//        for (Runnable onUpdate: onUpdate){
//            onUpdate.run();
//        }
        for (int i = 0; i < onUpdate.size(); i++) {
            onUpdate.get(i).run();
        }
   }

    public ArrayList<Runnable> getOnUpdate() {
        return onUpdate;
    }
}
