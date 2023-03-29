package model;

import java.io.Serializable;

public class Programme implements Serializable {

    private String code;
    private String name;
    private String faculty;

    public Programme() {
    }

    public Programme(String code) {
        this.code = code;
    }

    public Programme(String code, String name, String faculty) {
        this.code = code;
        this.name = name;
        this.faculty = faculty;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

}
