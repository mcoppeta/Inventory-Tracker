package main.structures;

public class Item {
    private String title;

    public Item(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return false;
        }
        if (!(other instanceof Item)) {
            return false;
        }

        Item o = (Item) other;
        if (o.getTitle().equals(this.getTitle())) {
            return true;
        }
        return false;
    }
}
