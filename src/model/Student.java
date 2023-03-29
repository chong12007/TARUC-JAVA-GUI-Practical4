package model;

import java.io.Serializable;

public class Student implements Serializable {

    private String id;
    private String ic;
    private String name;
    private char level;
    private Programme programme;
    private int years;

    public Student() {
    }

    public Student(String id) {
        this.id = id;
    }

    public Student(String id, String ic, String name, char level, Programme programme, int years) {
        this.id = id;
        this.ic = ic;
        this.name = name;
        this.level = level;
        this.programme = programme;
        this.years = years;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getLevel() {
        return level;
    }

    public void setLevel(char level) {
        this.level = level;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public int getYear() {
        return years;
    }

    public void setYear(int years) {
        this.years = years;
    }

}
