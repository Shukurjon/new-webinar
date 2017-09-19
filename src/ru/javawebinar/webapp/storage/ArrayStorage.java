package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.WebAppException;
import ru.javawebinar.webapp.model.Resume;

import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Logger;

/**
 * Created by shukur on 06/09/17.
 */
public class ArrayStorage extends AbsrtactStorage {
    private static final int LIMIT = 100;
//Логи, или журнал действий пользователя, помогает тестировщикам понять, что означает ошибка,
// а также - откуда она взялась.
    //
    protected Logger LOGGER = Logger.getLogger(getClass().getName());

// если у нас один класс то мы можем использовать - static


    private Resume[] array = new Resume[LIMIT];   //alt+ctrl+c выделяется константа
        private int size;                                        // alt+insert добавление класса и т.д.

    @Override
    public void clear() {

        LOGGER.info("DELETE all resumes.");
        /*
        for (int i = 0;i<LIMIT;i++){
            array[i]=null;
        }*/
        Arrays.fill(array,null);
        size = 0;
    }

    @Override
    public void save(Resume r)  {

        /*for (int i = 0;i<LIMIT;i++){
    Resume resume = array[i];
    if ( resume !=null){          //alt+ctrl+V  - экстракт варейбл.  выделим array[i]! как элемент
        if (r.equals(resume)){
            throw new IllegalStateException("Already present");
        }
    }
}
*/

        logger.info("save resume with uuid"+r.getUuid());

/*
for (int i =0; i<LIMIT;i++){
    if (array[i]==null){
        array[i]=r;
    }
}
*/

    }

    @Override
    protected void doSave(Resume r) {

         int idx = getIndex(r.getUuid());
 if (idx != -1) try {
     throw new WebAppException("Resume"+r.getUuid()+"already exist",r);
 } catch (WebAppException e) {
     e.printStackTrace();
 }
        array[size++]=r;
    }

    public ArrayStorage(Logger LOGGER) {
        this.LOGGER = LOGGER;
    }

    @Override
    public void update(Resume r) throws WebAppException {
LOGGER.info("Update reseme with uuid"+r.getUuid());
int idx = getIndex(r.getUuid());
if (idx==-1) throw new WebAppException("Resume"+r.getUuid()+"not exist",r);
array[idx]=r;
    }

    @Override
    public Resume load(String uuid) {
        return null;
    }

    @Override
    public void delete(String uuid) throws WebAppException {
LOGGER.info("Delete resume with uuid"+uuid);
int idx = getIndex(uuid);                                    //shift+F6 - все переменные менят за одно
if (idx==-1)throw new WebAppException("Resume"+ uuid+"not exist");
  int numMoved = size - idx -1;
  if (numMoved>0) System.arraycopy(array, idx+1, array, idx,numMoved);
  array[--size] = null;   // clear to let GC do its work

    }

    @Override
    public Collection<Resume> getAllSorted() {
        // TODO via comparator
        Arrays.sort(array, 0, size);
        return Arrays.asList(Arrays.copyOf(array,size));
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < LIMIT; i++) {
            if (array[i] != null) {
                if (array[i].getUuid().equals(uuid)) {
                    return i;
                }
            }
        }
        return -1;

    }

}

