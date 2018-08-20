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
    private String comment;
    private long created;

    public Item() {
    }

    public Item(String name, String desc, Long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }
    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getId() {
        return this.id;
    }
    public String getDesc() {
        return desc;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getStringItem() {
        String result =this.id + this.name + this.desc + this.created;
        return result;
    }
}
