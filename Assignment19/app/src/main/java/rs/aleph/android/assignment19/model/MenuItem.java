package rs.aleph.android.assignment19.model;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {

    private int id;
    private String name;
    private String description;
    private float price;
    private float calories;
    private String image;

    private Category category;

    private List<Ingredient> ingredients;

    public MenuItem() {
        this.ingredients = new ArrayList<>();
    }

    public MenuItem(int id, String image, String name, String description, Category category, float price, float calories, List<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.calories = calories;
        this.category = category;
        this.image = image;
        this.ingredients = ingredients;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) { this.category = category; }

    public List<Ingredient> getIngredients() { return this.ingredients; }

    public void setIngredients(List<Ingredient> ingredients) { this.ingredients = ingredients; }
}
