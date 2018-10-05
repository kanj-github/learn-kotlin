import java.util.ArrayList;

public class KotlinUser {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("abc");
        list1.add("bcd");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("cde");
        list2.add("def");
        JustAClass kotlinClass = new JustAClass(list1);
        kotlinClass.addMoreStuff(list2);
        kotlinClass.printShit();

        kotlinClass.setStuff(list2);
        System.out.println(kotlinClass.getCount());
        kotlinClass.printShit();

        /*kotlinClass.setStuff(null); Can't pass null to kotlin
        System.out.println(kotlinClass.getCount());*/
    }
}
