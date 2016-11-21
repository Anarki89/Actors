package rs.aleph.android.assignment19.provider;

import java.util.ArrayList;
import java.util.List;

import rs.aleph.android.assignment19.model.Category;
import rs.aleph.android.assignment19.model.Ingredient;
import rs.aleph.android.assignment19.model.MenuItem;

public class ProductProvider {

    public static List<MenuItem> getProducts() {
        Category food = new Category(0, "Food");
        Category drinks = new Category(1, "Drinks");

        List<Ingredient> beerIngredients = new ArrayList<>();
        beerIngredients.add(new Ingredient(5, "Water"));
        beerIngredients.add(new Ingredient(6, "Malt"));
        beerIngredients.add(new Ingredient(7, "Hops"));
        beerIngredients.add(new Ingredient(8, "Yeast"));

        List<Ingredient> sausagesIngredients = new ArrayList<>();
        sausagesIngredients.add(new Ingredient(0, "Meat"));
        sausagesIngredients.add(new Ingredient(1, "Spices"));
        sausagesIngredients.add(new Ingredient(2, "Salt"));

        List<Ingredient> frenchcFriesIngredients = new ArrayList<>();
        frenchcFriesIngredients.add(new Ingredient(3, "Potato"));
        frenchcFriesIngredients.add(new Ingredient(4, "Ketchup"));

        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(0, "beer.jpg", "Beer", "Natura IPA craft beer", drinks, 150.0f, 400.0f, beerIngredients));
        menuItems.add(new MenuItem(1, "sausages.jpg", "Sausages", "The best sausages in the town, spicy and salty", food, 440.0f, 1200.0f, sausagesIngredients));
        menuItems.add(new MenuItem(2, "french_fries.jpg", "French Fries", "Starters pack", food, 200.0f, 600.0f, frenchcFriesIngredients));
        return menuItems;
    }

    public static MenuItem getProductById(int id) {
        Category food = new Category(0, "Food");
        Category drinks = new Category(1, "Drinks");

        List<Ingredient> beerIngredients = new ArrayList<>();
        beerIngredients.add(new Ingredient(5, "Water"));
        beerIngredients.add(new Ingredient(6, "Malt"));
        beerIngredients.add(new Ingredient(7, "Hops"));
        beerIngredients.add(new Ingredient(8, "Yeast"));

        List<Ingredient> sausagesIngredients = new ArrayList<>();
        sausagesIngredients.add(new Ingredient(0, "Meat"));
        sausagesIngredients.add(new Ingredient(1, "Spices"));
        sausagesIngredients.add(new Ingredient(2, "Salt"));

        List<Ingredient> frenchcFriesIngredients = new ArrayList<>();
        frenchcFriesIngredients.add(new Ingredient(3, "Potato"));
        frenchcFriesIngredients.add(new Ingredient(4, "Ketchup"));

        switch (id) {
            case 0:
                return new MenuItem(0, "beer.jpg", "Beer", "Natura IPA craft beer", drinks, 150.0f, 400.0f, beerIngredients);
            case 1:
                return new MenuItem(1, "sausages.jpg", "Sausages", "The best sausages in the town, spicy and salty", food, 440.0f, 1200.0f, sausagesIngredients);
            case 2:
                return new MenuItem(2, "french_fries.jpg", "French Fries", "Starters pack", food, 200.0f, 600.0f, frenchcFriesIngredients);
            default:
                return null;
        }
    }
}
