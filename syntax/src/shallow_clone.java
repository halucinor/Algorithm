import java.util.ArrayList;

public class shallow_clone {
    static class Shallow{
        int value;

        public Shallow(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        ArrayList<Shallow> origin = new ArrayList<>();
        origin.add(new Shallow(1));
        origin.add(new Shallow(2));
        origin.add(new Shallow(3));

        //clone()
        ArrayList<Shallow> target = (ArrayList<Shallow>) origin.clone();

        //change origin value
        origin.get(0).value = 9; // 1 -> 9

        System.out.println("origin");
        origin.forEach(shallow -> System.out.println(shallow.value)); // 9 2 3

        System.out.println("shallow");
        target.forEach(shallow -> System.out.println(shallow.value)); // 9 2 3
    }
}
