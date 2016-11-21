package rs.aleph.android.assignment19.provider;

import java.util.ArrayList;
import java.util.List;

import rs.aleph.android.assignment19.model.Category;
import rs.aleph.android.assignment19.model.Ingredient;

public class IngredientProvider {

    public static List<Ingredient> getIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient(0, "Meat"));
        ingredients.add(new Ingredient(1, "Spices"));
        ingredients.add(new Ingredient(2, "Salt"));
        ingredients.add(new Ingredient(3, "Potato"));
        ingredients.add(new Ingredient(4, "Ketchup"));
        ingredients.add(new Ingredient(5, "Water"));
        ingredients.add(new Ingredient(6, "Malt"));
        ingredients.add(new Ingredient(7, "Hops"));
        ingredients.add(new Ingredient(8, "Yeast"));
        return ingredients;
    }

    public static Ingredient getIngredientById(int id) {
        switch (id) {
            case 0:
                return new Ingredient(0, "Meat");
            case 1:
                return new Ingredient(1, "Spices");
            case 2:
                return new Ingredient(2, "Salt");
            case 3:
                return new Ingredient(3, "Potato");
            case 4:
                return new Ingredient(4, "Ketchup");
            case 5:
                return new Ingredient(5, "Water");
            case 6:
                return new Ingredient(6, "Malt");
            case 7:
                return new Ingredient(7, "Hops");
            case 8:
                return new Ingredient(8, "Yeast");

            default:
                return null;
        }
    }
}
