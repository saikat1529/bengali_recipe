package com.saikat.personal.newdrawerlayouttemplate.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.saikat.personal.newdrawerlayouttemplate.Object.Category;
import com.saikat.personal.newdrawerlayouttemplate.R;

import java.util.ArrayList;

/**
 * Created by fojlesaikat on 17/12/15.
 */
public class FavouriteAdapter extends BaseAdapter {
    ArrayList<Category> categories;
    Context context;
    public FavouriteAdapter(Context ctx, ArrayList<Category> cat){
        categories = cat;
        context = ctx;
    }
    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int position) {
        return categories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater lf = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = lf.inflate(R.layout.favoruite_list_item_layout,null);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.fav_image);
        TextView title = (TextView) convertView.findViewById(R.id.fav_title);
        CheckBox checkBox = (CheckBox)convertView.findViewById(R.id.fav_check);
        imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.food));
        title.setText(categories.get(position).getTitle());
        checkBox.setChecked(true);
        return convertView;
    }
}
