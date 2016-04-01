package com.saikat.personal.newdrawerlayouttemplate.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.saikat.personal.newdrawerlayouttemplate.Object.Category;
import com.saikat.personal.newdrawerlayouttemplate.R;

import java.util.ArrayList;

/**
 * Created by fojlesaikat on 16/12/15.
 */
public class CategoryAdapter extends BaseAdapter {

    private Context ctx;
    ArrayList<Category> category;
    int cad;
    boolean hasfile;

    public CategoryAdapter(Context context, ArrayList<Category> items){
        ctx = context;
        category = items;
        if (items.size()>0)
            hasfile = true;
        else
            hasfile = false;
    }

    @Override
    public int getCount() {
        return category.size();
    }

    @Override
    public Object getItem(int position) {
        return category.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.category_layout, null);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.category_image);
        TextView title = (TextView) convertView.findViewById(R.id.category_title);
        TextView subtitle = (TextView) convertView.findViewById(R.id.category_subtitle);
        imageView.setImageDrawable(ctx.getResources().getDrawable(R.drawable.food));
        title.setText(category.get(position).getTitle());
        return convertView;
    }
}
