package com.example.demo.model;

public class BookModel {
    private int ID;
    private String Name;
    private String Description;
    private String Author;
    private int Year;
    private boolean isDeleted;

    public BookModel (int id, String name, String description, String author, int year, boolean isDeleted){
        ID = id;
        Name = name;
        Description = description;
        Author = author;
        Year = year;
        this.isDeleted = isDeleted;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
