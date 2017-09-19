package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.WebAppException;
import ru.javawebinar.webapp.model.Resume;

import java.util.Collection;

/**
 * Created by shukur on 06/09/17.
 */
public interface IStorage {
    void clear();
    void save(Resume r) throws WebAppException;
    void update(Resume r) throws WebAppException;
    Resume load(String uuid);
    void delete(String uuid) throws WebAppException;
    Collection<Resume> getAllSorted();
    int size();
    }
