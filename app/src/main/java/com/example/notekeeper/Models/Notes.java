package com.example.notekeeper.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "notes")
public class Notes implements Serializable {
    @PrimaryKey(autoGenerate = true)
    int ID=0;

    @ColumnInfo(name = "Title")
    String Title="";

    @ColumnInfo(name = "Notes")
    String Notes="";

    @ColumnInfo(name = "Date")
    String Date="";

    @ColumnInfo(name= "Pinned")
    boolean Pinned=false;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public boolean isPinned() {
        return Pinned;
    }

    public void setPinned(boolean pinned) {
        Pinned = pinned;
    }
}
