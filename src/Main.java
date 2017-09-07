import ru.javawebinar.webapp.model.Link;

/**
 * Created by shukur on 29/08/17.
 */
public class Main {
    public static void main(String[] args) {
        // System.out.println("fj");
        int i =5;
        Link l1 = new Link("Javawebinar","javawebinar.ru");
        Link l2 = l1;
        Link l3 = new Link(l2);
        System.out.println(l1.getClass());
        System.out.println(l1.equals(l2));
        System.out.println(l1.equals(l3));
        System.out.println(l1.EMPTY);
    }



/*//    @Override

//    public int hashCode() {
//        return super.hashCode();
//    }
//
//    @Override
//    public boolean equals(Object o) {
////        if (this == o) return true;
////        if ((o==null)|| getClass()!=o.getClass()) return false;
////
////        Link link = (Link)o;
////        if (!name.equals)
//       return super.equals(o);
//    }*/

}
