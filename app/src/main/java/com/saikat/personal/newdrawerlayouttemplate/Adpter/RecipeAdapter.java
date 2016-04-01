package com.saikat.personal.newdrawerlayouttemplate.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.saikat.personal.newdrawerlayouttemplate.Object.Recipe;
import com.saikat.personal.newdrawerlayouttemplate.R;

import java.util.ArrayList;

/**
 * Created by fojlesaikat on 18/12/15.
 */
public class RecipeAdapter extends BaseAdapter {

    Context context;
    ArrayList<Recipe> recipes;

    public RecipeAdapter(Context context, ArrayList<Recipe> recipes){
        this.recipes = recipes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return recipes.size();
    }

    @Override
    public Object getItem(int position) {
        return recipes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.cat_recipe_item_view, null);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.recipe_image);
        TextView title = (TextView) convertView.findViewById(R.id.recipe_title);
        TextView subtitle = (TextView) convertView.findViewById(R.id.recipe_provider);
        imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.food));
        title.setText(recipes.get(position).getRecipe_title());
        subtitle.setText(recipes.get(position).getRecipe_provider());
        return convertView;
    }
}
