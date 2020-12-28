package main.structures;

public class Category {
    private String title;
    public int num = 5; //todo remove this

    public Category(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    //todo remove this
    public int getNum() {
        return num;
    }
}
