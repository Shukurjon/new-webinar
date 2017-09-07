package ru.javawebinar.webapp.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import ru.javawebinar.webapp.model.Contact;
import ru.javawebinar.webapp.model.ContactType;
import ru.javawebinar.webapp.model.Resume;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by shukur on 06/09/17.
 */
class ArrayStorageTest {
   private static Resume R1,R2,R3;
   private ArrayStorage storage = new ArrayStorage();
   //int idx=0; // текущая позиция в массиве


   static {
       R1=new Resume("Полное имя","location1");
       R1.addContact(new Contact(ContactType.MAIL,"mail1@ya.ru"));
       R1.addContact(new Contact(ContactType.PHONE,"11111"));
       R2=new Resume("Полное имя2",null);
       R2.addContact(new Contact(ContactType.SKYPE,"skype2"));
       R2.addContact(new Contact(ContactType.PHONE,"22222"));
       R3=new Resume("Полное имя3",null);
   }

   @BeforeClass
   public static void beforeClass(){
        // The same as static {}
   }

   @Before
   public  void before(){

    //   storage  - хранилище
       storage.clear();
       storage.save(R1);
       storage.save(R2);
       storage.save(R3);

   }

    private ArrayStorage arrayStorage = new ArrayStorage();

    static {

    }
    @Test
    void clear() {
    }

    @Test
    void save() {

    }

    @org.junit.Test
    void update() {
    }

    @Test
    void load() {
    }

    @Test
    void delete() {
        storage.delete(R1.getUuid());
        Assert.assertEquals(2,storage.size());
        Assert.assertEquals(null,storage.load(R1.getUuid()));
    }

    @Test
    void getAllSorted() {
    }

    @Test
    void size() {
    }

}