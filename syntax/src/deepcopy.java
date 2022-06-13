import java.util.ArrayList;

public class deepcopy {

    static class Deep implements Cloneable{
        String str;

        public Deep(String str){
            this.str = str;
        }
        @Override
        protected Deep clone() throws CloneNotSupportedException{
            return (Deep) super.clone();
        }
    }

    public static void main(String[] args) {
        //origin
        Deep origin = new Deep("origin");
        Deep target;
        //clone
        try {
            target = origin.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        origin.str = "change";
        System.out.println(origin.str); //change
        System.out.println(target.str); //origin

        //addAll()
        ArrayList<Deep> deepArray = new ArrayList<>();
        ArrayList<Deep> targetArray = new ArrayList<>();

        deepArray.add(new Deep("first"));
        deepArray.add(new Deep("second"));
        deepArray.add(new Deep("third"));
        System.out.println("==========");

        targetArray.addAll(deepArray); // addAll 도 얕은 복사 수행함
        targetArray.get(2).str = "change";

        System.out.println("origin array:");
        deepArray.forEach(deep -> System.out.println(deep.str));// first second change

        System.out.println("target array:");
        targetArray.forEach(deep -> System.out.println(deep.str));// first second change

        //deep copy implements
        ArrayList<Deep> copyArray = new ArrayList<>();

        for(Deep deep : deepArray){
            try {
                copyArray.add(deep.clone()); // 복사 수행
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }

        copyArray.get(2).str = "copied!";
        System.out.println("========");
        System.out.println("origin array:");
        deepArray.forEach(deep -> System.out.println(deep.str)); //first second change
        System.out.println("deep copy array:");
        copyArray.forEach(deep -> System.out.println(deep.str)); //first second copied!

    }
}
