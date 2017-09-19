package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.WebAppException;
import ru.javawebinar.webapp.model.Resume;

import java.util.logging.Logger;

/**
 * Created by shukur on 14/09/17.
 */
abstract public class AbsrtactStorage implements IStorage {

    protected Logger logger = Logger.getLogger(getClass().getName());

    @Override
    public void save(Resume r) {
        logger.info("Save resume with uuid = "+r.getUuid());
        // TODO try to move here exeption treatment
        doSave(r);
        //


    }
    protected abstract void doSave(Resume r);
}
