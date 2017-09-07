package ru.javawebinar.webapp.model;

/**
 * Created by shukur on 04/09/17.
 */
public enum ContactType {
    PHONE("Тел"),
    MOBILE("Мобильный"),
    HOME_PHONE("Домашний тел"),
    SKYPE("Skype"),
    MAIL("Почта"),
    ICQ("ICQ");



    private String title;

    ContactType(String title){this.title=title;}
    public String getTitle(){return title;}
    }

