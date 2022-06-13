import java.util.ArrayList;

public class shallow {

    public static void main(String[] args) {
        //shallow copy origin
        ArrayList<Integer> origin = new ArrayList<>();

        origin.add(1);
        origin.add(2);
        origin.add(3);

        System.out.println("원본 출력");
        origin.forEach(i -> System.out.println(i)); // 1, 2, 3

        //shallow copy target
        ArrayList<Integer> target = origin;

        //change original
        origin.set(0,4);
        origin.set(1,5);
        origin.set(2,6);

        System.out.println("얕은 복사본 출력");
        target.forEach(i -> System.out.println(i));// 4,5,6
    }
}
