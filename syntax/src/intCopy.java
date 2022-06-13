public class intCopy {
    static int target = 1;
    public static void main(String[] args) {
        int obj = target;

        obj += 10;

        System.out.println(target);
        System.out.println(obj);

    }
}
