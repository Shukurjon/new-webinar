package ru.javawebinar.webapp.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.javawebinar.webapp.WebAppException;
import ru.javawebinar.webapp.model.ContactType;
import ru.javawebinar.webapp.model.Resume;
import ru.javawebinar.webapp.model.SectionType;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by shukur on 20/09/17.
 */
public class AbstractStorageTest {
    private Resume R1,R2,R3;

    protected IStorage storage;

    @BeforeClass
    public static void beforeClass(){

    }

    @Before
    public void before() {
        R1 = new Resume("Полное Имя1", "location");
        R1.addContact(ContactType.HOME_PHONE, "11111");
        R1.addContact(ContactType.MAIL, "mail1@ya.ru");
        R2 = new Resume("Полное Имя2", null);
        R2.addContact(ContactType.SKYPE, "skype2");
        R2.addContact(ContactType.PHONE, "22222");
        R3 = new Resume("Полное имя3", null);

        R1.addMultiTextSection(SectionType.ACHIEVEMENT, "Achievement11","Achievement12");
        R1.addMultiTextSection(SectionType.QUALIFICATIONS,"Java","SQL");
//TODO
/*
       R1.addOrganizationSection(SectionType.EXPIRIENCE, new Organization("Organization11",null,
               new Organization.Period(LocalDate.of(2005, Month.NOVEMBER,1),Organization.Period.NOW,"position1","content1"),
               new Organization.Period(2001,Month.MARCH,2005,Month.JANUARY,"position2","content2")),
               new Organization("Organization12","http://Organization12.ru"));

       R1.addOrganizationSection(SectionType.EDUCATION,
               new Organization("Institute",null,
                       new Organization.Period(1996,Month.JANUARY,2000,Month.DECEMBER,"aspirant",null),
                       new Organization.Period(2001,Month.MARCH,2005,Month.JANUARY,"student","IT facultet")),
               new Organization("Organization12","http://Organization12.ru")));

*/

        storage.clear();
        try {
            storage.save(R3);
        } catch (WebAppException e) {
            e.printStackTrace();
        }
        try {
            storage.save(R2);
        } catch (WebAppException e) {
            e.printStackTrace();
        }
        try {
            storage.save(R1);
        } catch (WebAppException e) {
            e.printStackTrace();
        }


        R1.addObjective("Objective1");
        R1.addMultiTextSection(SectionType.ACHIEVEMENT,"Achivment11","Achivment12");
        R1.addMultiTextSection(SectionType.QUALIFICATIONS,"Java","SQL");
    // TODO add Expirance and Education

        //@org.junit.jupiter.api.Test
  //      void name() {
//
       // }
    }
        @Test
        public void testClear(){

            storage.clear();
            assertEquals(0,storage.size());
        }

        @org.junit.jupiter.api.Test
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

        public void testDeleteNotFound() throws Exception{
            storage.load("dummy");
        }
        @Test
        public void testDelete() throws NullPointerException {
            try {
                storage.delete(R1.getUuid());
            } catch (WebAppException e) {
                e.printStackTrace();
            }
            Assert.assertEquals(2,storage.size());
            try {
                Assert.assertEquals(null,storage.load(R1.getUuid()));
            } catch (WebAppException e) {
                e.printStackTrace();
            }
        }

        @Test
        public void getAllSorted() throws Exception{
            Resume[] src = new Resume[]{R1,R2,R3};
            Arrays.sort(src);
            assertArrayEquals(src,storage.getAllSorted().toArray()); //Сравнивает массивы
            List<Resume> list =Arrays.asList(R1, R2, R3);
            Collections.sort(list, new Comparator<Resume>() {
                @Override
                public int compare(Resume o1, Resume o2) {
                    return 0;
                }
            });
            assertEquals(list,storage.getAllSorted());
        }

        @org.junit.jupiter.api.Test
        void size() {
            Assert.assertEquals(3,storage.size());
        }

}
