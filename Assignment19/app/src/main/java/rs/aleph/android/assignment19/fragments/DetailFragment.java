package rs.aleph.android.assignment19.fragments;

import android.app.Fragment;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import rs.aleph.android.assignment19.R;
import rs.aleph.android.assignment19.model.Category;
import rs.aleph.android.assignment19.model.Ingredient;
import rs.aleph.android.assignment19.model.MenuItem;
import rs.aleph.android.assignment19.provider.CategoryProvider;
import rs.aleph.android.assignment19.provider.IngredientProvider;
import rs.aleph.android.assignment19.provider.ProductProvider;

public class DetailFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private static int NOTIFICATION_ID = 1;

    private MenuItem menuItem = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (menuItem == null) { menuItem = ProductProvider.getProductById(0); }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            menuItem = new MenuItem();
            menuItem.setId(savedInstanceState.getInt("id"));
            menuItem.setImage(savedInstanceState.getString("image"));
            menuItem.setName(savedInstanceState.getString("name"));
            menuItem.setDescription(savedInstanceState.getString("description"));
            int categoryId = savedInstanceState.getInt("category_id");
            Category category = CategoryProvider.getCategoryById(categoryId);
            menuItem.setCategory(category);
            menuItem.setPrice(savedInstanceState.getFloat("price"));
            menuItem.setCalories(savedInstanceState.getFloat("calories"));
            ArrayList<Integer> ingredientIds = savedInstanceState.getIntegerArrayList("ingredientIds");
            List ingredients = new ArrayList<>();
            for (int ingredientId: ingredientIds) {
                Ingredient ingredient = IngredientProvider.getIngredientById(ingredientId);
                ingredients.add(ingredient);
            }
            menuItem.setIngredients(ingredients);

        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        if (savedInstanceState != null) {
            savedInstanceState.putInt("id", menuItem.getId());
            savedInstanceState.putString("image", menuItem.getImage());
            savedInstanceState.putString("name", menuItem.getName());
            savedInstanceState.putString("description", menuItem.getDescription());
            savedInstanceState.putFloat("price", menuItem.getPrice());
            savedInstanceState.putInt("category_id", menuItem.getCategory().getId());
            savedInstanceState.putFloat("calories", menuItem.getCalories());
            ArrayList<Integer> ingredientIds = new ArrayList<>();
            for (Ingredient ingredient: menuItem.getIngredients()) {
                int ingredientId = ingredient.getId();
                ingredientIds.add(ingredientId);
            }
            savedInstanceState.putIntegerArrayList("ingredientIds", ingredientIds);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.v("DetailFragment", "onCreateView()");

        View view = inflater.inflate(R.layout.detail_fragment, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        InputStream is = null;
        try {
            is = getActivity().getAssets().open(menuItem.getImage());
            Drawable drawable = Drawable.createFromStream(is, null);
            imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView name = (TextView) view.findViewById(R.id.name);
        name.setText(menuItem.getName());

        TextView description = (TextView) view.findViewById(R.id.description);
        description.setText(menuItem.getDescription());

        Spinner category = (Spinner) view.findViewById(R.id.category);
        String[] categories = getActivity().getResources().getStringArray(R.array.category_names);
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, categories);
        category.setAdapter(categoryAdapter);
        category.setSelection(menuItem.getCategory().getId());

        TextView price = (TextView) view.findViewById(R.id.price);
        price.setText(Float.toString(menuItem.getPrice()));

        TextView calories = (TextView) view.findViewById(R.id.calories);
        calories.setText(Float.toString(menuItem.getCalories()));

        ListView ingredients = (ListView) view.findViewById(R.id.ingredients);
        ArrayAdapter<String> ingredientsAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, menuItem.getIngredients());
        ingredients.setAdapter(ingredientsAdapter);

        FloatingActionButton button = (FloatingActionButton) view.findViewById(R.id.buy);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creates notification with the notification builder
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity());
                Bitmap bitmap = BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.ic_stat_buy);
                builder.setSmallIcon(R.drawable.ic_stat_buy);
                builder.setContentTitle(getActivity().getString(R.string.notification_title));
                builder.setContentText(getActivity().getString(R.string.notification_text));
                builder.setLargeIcon(bitmap);

                // Shows notification with the notification manager (notification ID is used to update the notification later on)
                NotificationManager manager = (NotificationManager)getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(NOTIFICATION_ID, builder.build());
            }
        });

        return view;
    }

    public void setMenuItem(int id) {
        menuItem = ProductProvider.getProductById(id);
    }

    public void updateProduct(int id) {
        menuItem = ProductProvider.getProductById(id);

        ImageView imageView = (ImageView) getActivity().findViewById(R.id.image);
        InputStream is = null;
        try {
            is = getActivity().getAssets().open(menuItem.getImage());
            Drawable drawable = Drawable.createFromStream(is, null);
            imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView name = (TextView) getActivity().findViewById(R.id.name);
        name.setText(menuItem.getName());

        TextView description = (TextView) getActivity().findViewById(R.id.description);
        description.setText(menuItem.getDescription());

        Spinner category = (Spinner) getActivity().findViewById(R.id.category);
        category.setSelection(menuItem.getCategory().getId());

        TextView price = (TextView) getActivity().findViewById(R.id.price);
        price.setText(Float.toString(menuItem.getPrice()));

        TextView calories = (TextView) getActivity().findViewById(R.id.calories);
        calories.setText(Float.toString(menuItem.getCalories()));

        ListView ingredients = (ListView) getActivity().findViewById(R.id.ingredients);
        ArrayAdapter<String> ingredientsAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, menuItem.getIngredients());
        ingredients.setAdapter(ingredientsAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // You can retrieve the selected item using
        //menuItem.setCategory(CategoryProvider.getCategoryById((int)id));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //menuItem.setCategory(null);
    }
}
