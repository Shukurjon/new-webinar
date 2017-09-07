package ru.javawebinar.webapp;

import ru.javawebinar.webapp.model.Resume;

/**
 * Created by shukur on 07/09/17.
 */
public class WebAppException extends RuntimeException{
    private Resume resume = null;
    private String uuid = null;

    public WebAppException(String message) {
        super(message);

    }
public WebAppException(String message,Throwable e) {
        super(message,e);

    }

    public WebAppException(String message,Resume resume) {
        super(message);
        this.resume = resume;
    }
public WebAppException(String message,Resume resume,Throwable e) {
        super(message,e);
        this.resume = resume;
    }

    /*
    public WebAppException(String s, Resume resume) {
        super(s);
        this.resume = resume;
    }
*/

/*
    public WebAppException(String s, Throwable throwable, Resume resume) {
        super(s, throwable);
        this.resume = resume;
    }
*/
/*
    public WebAppException(Throwable throwable, Resume resume) {
        super(throwable);
        this.resume = resume;
    }*/

    public WebAppException(String message, String uuid) {
        super(message);
        this.uuid = uuid;
    }

    public Resume getResume() {
        return resume;
    }

    public String getUuid() {
        return uuid;
    }
}
