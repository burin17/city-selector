package com.example.cityselector.domain;

public class Point {
    private int id;
    private String title;
    private Point yes;
    private Point no;

    public Point(int id, String title) {
        this.id = id;
        this.title = title;
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

    @Override
    public String toString() {
        return "Point{" +
                "title='" + title + '\'' +
                ", yes=" + yes +
                ", no=" + no +
                '}';
    }
}
