package com.saikat.personal.newdrawerlayouttemplate;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by fojlesaikat on 18/12/15.
 */
public class Ingredients extends Fragment {

    ListView listView;
    LinearLayout linearLayout;
    String[] ingredienst;
    Context context;

    public Ingredients(Context context){
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rec_ingre_layout,null);
        //listView = (ListView)view.findViewById(R.id.ingrdients_list);
        ingredienst = context.getResources().getStringArray(R.array.ingredient);
        linearLayout = (LinearLayout)view.findViewById(R.id.ingre_list);
        for(int i=0;i<ingredienst.length;i++){
            TextView textView = new TextView(context);
            textView.setText(i+1+". "+ingredienst[i]);
            textView.setTextColor(context.getResources().getColor(R.color.blue));
            textView.setTextSize(20);
            linearLayout.addView(textView);
        }
        return view;
    }
}
