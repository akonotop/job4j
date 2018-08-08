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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return  this.name;
    }

    public void setName (String id) {
        this.name = name;
    }

    public  String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public  String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Item(String name, String desc, long created) {
       this.name = name;
       this.desc = desc;
       this.created = created;
    }

    public  long getCreated() {
        return this.created;
    }

    public void setCreated(){
        this.created = created;
    }


}
