package com.saikat.personal.newdrawerlayouttemplate;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.saikat.personal.newdrawerlayouttemplate.Adpter.RecipeAdapter;
import com.saikat.personal.newdrawerlayouttemplate.Object.Recipe;

import java.util.ArrayList;

/**
 * Created by fojlesaikat on 18/12/15.
 */
public class AllRecipe extends Fragment {

    Context context;
    int catgory_id;
    String category;
    ArrayList<Recipe> recipes;
    ListView listView;
    RecipeAdapter adapter;
    FragmentManager manager;

    public AllRecipe(Context ctx, int cat_id, String category){
        context = ctx;
        catgory_id = cat_id;
        this.category = category;
        setRecipe();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cat_recipe_layout,null);
        manager = getFragmentManager();
        adapter = new RecipeAdapter(getActivity(),recipes);
        listView = (ListView)view.findViewById(R.id.cat_rec_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view.findViewById(R.id.recipe_title);
                String title = textView.getText().toString();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.container, new RecipeTab()).commit();
            }
        });
        return view;
    }

    private int getRecipeId(String text){
        for(int i=0;i<recipes.size();i++){
            if(recipes.get(i).getRecipe_title().equals(text)){
                return recipes.get(i).getRecipe_id();
            }
        }
        return -1;
    }

    private void setRecipe(){
        /*Call jsonObject with category*/
        recipes = new ArrayList<Recipe>();
        for(int i =0; i<5; i++){
            Recipe recipe = new Recipe();
            recipe.setRecipe_id(i);
            recipe.setRecipe_image(R.drawable.food);
            recipe.setRecipe_title(category + (i + 1));
            recipe.setRecipe_provider("by saikat");
            recipes.add(recipe);
        }
    }


}
