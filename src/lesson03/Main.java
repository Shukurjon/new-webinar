package lesson03;

import ru.javawebinar.webapp.model.Contact;
import ru.javawebinar.webapp.model.ContactType;
import ru.javawebinar.webapp.model.Link;

import java.lang.reflect.Field;

/**
 * Created by shukur on 04/09/17.
 */
// alt+inter - import
public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        //Contact c = new Contact("ContactType.PHONE","1234567899");
        ContactType c2 = ContactType.ICQ;
        System.out.println(ContactType.ICQ==c2);

        Field f = Link.class.getDeclaredField("url");
        f.setAccessible(true);
        Link l = new Link("fdsf","URL");
        System.out.println(f.get(l));
        System.out.println(l instanceof Link);
        System.out.println(l.getClass().isInstance(Link.class));
      //  System.out.println(l.getURL());
            }
}
