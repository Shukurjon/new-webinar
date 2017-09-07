package ru.javawebinar.webapp.model;

/**
 * Created by shukur on 04/09/17.
 */
public class Link {
    public static Link EMPTY = new Link("",null);
    private final String name;
    private final String url;

    public Link(){
        this("",null);
        // this - конструктор
    }

    public Link(String name, String url) {
        this.name = name;
        this.url = url;
    }
public Link(Link link){
        this.name = link.name;
        this.url = link.url;
}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (!name.equals(link.name)) return false;
        return url.equals(link.url);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + url.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Link{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
