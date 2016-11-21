package rs.aleph.android.assignment19.model;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private int id;
    private String name;

    private List<MenuItem> menuItems;

    public Category() {
        menuItems = new ArrayList<>();
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;

        menuItems = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
