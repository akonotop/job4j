package ru.job4j.tracker;
/**
 * @author Alex Konotop (mailto:a.konotop@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Item {

    private String id;
    private String name;
    private String desc;
    private long created;

    public Item(String name, String desc, Long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }
    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }



    @Override
    public String toString() {
        return "Item{"
                + "id='"
                + id + '\'' + ", name='"
                + name + '\'' + ", desc='"
                + desc + '\''
                + '}';
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
