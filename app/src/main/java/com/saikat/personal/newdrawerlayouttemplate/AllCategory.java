package com.saikat.personal.newdrawerlayouttemplate;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.saikat.personal.newdrawerlayouttemplate.Adpter.CategoryAdapter;
import com.saikat.personal.newdrawerlayouttemplate.Object.Category;

import java.util.ArrayList;

/**
 * Created by fojlesaikat on 16/12/15.
 */
public class AllCategory extends Fragment {
    CategoryAdapter CategoyAdapter;
    Context context;
    ListView listView;
    ArrayList<Category> category_list;
    FragmentManager manager;
    String[] catItems;

    public AllCategory(Context context){
        this.context = context;
        getJsonData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.all_recipe,null);
        listView = (ListView)view.findViewById(R.id.all_recipe_list);
        CategoyAdapter =  new CategoryAdapter(getActivity(),category_list);
        listView.setAdapter(CategoyAdapter);
        manager = getFragmentManager();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView title = (TextView)view.findViewById(R.id.category_title);
                String text = title.getText().toString();
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                fragmentTransaction.replace(R.id.container,new AllRecipe(getActivity(),getCategoryId(text),text)).commit();
            }
        });
        return view;
    }

    private int getCategoryId(String text){
        int i = -1;
        for(int j=0;j<category_list.size();j++){
            if(category_list.get(j).getTitle().equals(text)){
                return category_list.get(j).getCategory_id();
            }
        }
        return i;
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
