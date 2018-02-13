package com.artiomlevchuk.onenote.data.task;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.Date;

@Table(database = TaskDatabase.class)
public class Task extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = true)
    private int id;

    @Column
    private int type;

    @Column
    private String title;

    @Column
    private String body;

    @Column
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setData(int type, String title, String body) {
        this.type = type;
        this.title = title;
        this.body = body;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}