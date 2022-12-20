import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class somethingisnotright {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < 10000; i++) {
            //numbers.add((int)(Math.random()*200));
            int a = (int)(Math.random()*99)+1;
            numbers.add(a);
            sum += a;
        }
        System.out.println(sum/10000);
    }
}
