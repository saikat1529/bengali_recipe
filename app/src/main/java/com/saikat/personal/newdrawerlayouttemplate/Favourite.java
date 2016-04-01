package com.saikat.personal.newdrawerlayouttemplate;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.saikat.personal.newdrawerlayouttemplate.Adpter.FavouriteAdapter;
import com.saikat.personal.newdrawerlayouttemplate.Object.Category;

import java.util.ArrayList;

/**
 * Created by fojlesaikat on 16/12/15.
 */
public class Favourite extends Fragment {
    ListView listView;
    FavouriteAdapter adapter;
    ArrayList<Category> fav_categories;
    Context context;
    String[] catItems;
    ArrayList<Category> category_list;

    public Favourite(Context context){
        this.context = context;
        getJsonData();
        setFav_categories();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        if (fav_categories!=null) {
            view = inflater.inflate(R.layout.favourite_layout, null);
        }
        else {
            view = inflater.inflate(R.layout.nofile_layout, null);
        }
        listView = (ListView)view.findViewById(R.id.favourite_list);
        adapter = new FavouriteAdapter(getActivity(), fav_categories);
        listView.setAdapter(adapter);
        return view;
    }

    private void setFav_categories(){
        fav_categories = new ArrayList<Category>();
        for(int i=0;i<category_list.size();i++){
            if(category_list.get(i).isFavourite()){
                Category cat = new Category();
                cat = category_list.get(i);
                fav_categories.add(cat);
            }
        }
    }

    private void getJsonData(){
        catItems = context.getResources().getStringArray(R.array.category);
        category_list = new ArrayList<Category>();
        for(int i=0;i<catItems.length;i++){
            Category category = new Category();
            category.setCategory_id(i+2);
            category.setBitmap(R.drawable.food);
            category.setTitle(catItems[i]);
            category.setSubtitle("SubTitle Goes Here");
            if(i%3==0)
                category.setFavourite(true);
            else
                category.setFavourite(false);
            category_list.add(category);
        }
    }

}
