package rs.aleph.android.assignment19.provider;

import java.util.ArrayList;
import java.util.List;

import rs.aleph.android.assignment19.model.Category;

public class CategoryProvider {

    public static List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(0, "Food"));
        categories.add(new Category(1, "Drinks"));
        return categories;
    }

    public static Category getCategoryById(int id) {
        switch (id) {
            case 0:
                return new Category(0, "Food");
            case 1:
                return new Category(1, "Drinks");
            default:
                return null;
        }
    }
}
