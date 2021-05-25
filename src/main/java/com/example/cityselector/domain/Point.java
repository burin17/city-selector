package com.example.cityselector.domain;

public class Point {
    private int id;
    private String title;
    private Point yes;
    private Point no;
    private String desc;

    public Point(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Point(int id, String title, String desc) {
        this.id = id;
        this.title = title;
        this.desc = desc;
    }

    public Point() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Point getYes() {
        return yes;
    }

    public void setYes(Point yes) {
        this.yes = yes;
    }

    public Point getNo() {
        return no;
    }

    public void setNo(Point no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", yes=" + yes +
                ", no=" + no +
                ", desc='" + desc + '\'' +
                '}';
    }
}
