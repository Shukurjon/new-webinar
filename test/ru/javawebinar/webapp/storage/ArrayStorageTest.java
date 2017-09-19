package ru.javawebinar.webapp.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import ru.javawebinar.webapp.WebAppException;
import ru.javawebinar.webapp.model.Contact;
import ru.javawebinar.webapp.model.ContactType;
import ru.javawebinar.webapp.model.Resume;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by shukur on 06/09/17.
 */
class ArrayStorageTest {
   private Resume R1,R2,R3;
   private ArrayStorage storage = new ArrayStorage();
   //int idx=0; // текущая позиция в массиве




   @BeforeClass
   public static void beforeClass(){
        // The same as static {}
   }

   @Before
   public  void before() throws WebAppException {

       R1=new Resume("Полное имя","location1");
       R1.addContact(new Contact(ContactType.MAIL,"mail1@ya.ru"));
       R1.addContact(new Contact(ContactType.PHONE,"11111"));
       R2=new Resume("Полное имя2","location2");
       R2.addContact(new Contact(ContactType.SKYPE,"skype2"));
       R2.addContact(new Contact(ContactType.PHONE,"22222"));
       R3=new Resume("Полное имя3",null);

    //   storage  - хранилище
       storage.clear();

       storage.save(R1);
       storage.save(R2);
       storage.save(R3);

   }

    private ArrayStorage arrayStorage = new ArrayStorage();


    @Test
    void name() {

    }

    @Test
   public void testClear() throws Exception {

 storage.clear();
 assertEquals(0,storage.size());
    }


    @Test
    public void testSave() throws Exception {

    }

    @Test
    public void testUpdate() throws NullPointerException, WebAppException {
R2.setFullName("Updated N2");
storage.update(R2);
assertEquals(R2, storage.load(R2.getUuid()));
     }

// ctrl+N  -- информация о классе встроенного
    // ctrl + H -- иерархия ...
    @Test
   public void testLoad() throws Exception {

        assertEquals(R1,storage.load(R1.getUuid()));
        assertEquals(R2,storage.load(R2.getUuid()));
        assertEquals(R3,storage.load(R3.getUuid()));
    }

    @Test
    public void testDelete() throws NullPointerException {
        try {
            storage.delete(R1.getUuid());
        } catch (WebAppException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(2,storage.size());
        Assert.assertEquals(null,storage.load(R1.getUuid()));
    }

    @Test
   public void getAllSorted() throws Exception{
        Resume[] src = new Resume[]{R1,R2,R3};
        Arrays.sort(src);
        assertArrayEquals(src,storage.getAllSorted().toArray()); //Сравнивает массивы
    }

    @Test
    void size() {
    Assert.assertEquals(3,storage.size());
    }

}