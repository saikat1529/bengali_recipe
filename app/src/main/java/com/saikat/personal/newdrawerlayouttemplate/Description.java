package com.saikat.personal.newdrawerlayouttemplate;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by fojlesaikat on 18/12/15.
 */
public class Description extends Fragment {

    Context context;
    TextView textView;

    public Description(Context context){
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.description_layout,null);
        textView = (TextView)view.findViewById(R.id.rec_desc);
        textView.setText(context.getResources().getString(R.string.description));
        return view;

    }
}
