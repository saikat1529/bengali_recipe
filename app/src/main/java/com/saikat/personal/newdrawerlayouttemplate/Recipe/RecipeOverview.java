package com.saikat.personal.newdrawerlayouttemplate.Recipe;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.saikat.personal.newdrawerlayouttemplate.R;

/**
 * Created by fojlesaikat on 18/12/15.
 */
public class RecipeOverview extends Fragment {

    Context context;
    TextView cooktext, savetext;
    boolean cookflag = false;
    boolean saveflag = false;

    public RecipeOverview(Context context){
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rec_over_layout,null);
        cooktext = (TextView)view.findViewById(R.id.cooked_text);
        savetext = (TextView)view.findViewById(R.id.saved_text);
        cooktext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!cookflag){
                    cooktext.setCompoundDrawablesWithIntrinsicBounds(0,
                            0,
                            android.R.drawable.star_big_on,
                            0);
                    cookflag = !cookflag;
                }
                else{
                    cooktext.setCompoundDrawablesWithIntrinsicBounds(0,
                            0,
                            android.R.drawable.star_big_off,
                            0);
                    cookflag = !cookflag;
                }
            }
        });
        savetext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!saveflag){
                    savetext.setCompoundDrawablesWithIntrinsicBounds(
                            android.R.drawable.star_big_on,
                            0,
                            0,
                            0);
                    saveflag = !saveflag;
                }
                else{
                    savetext.setCompoundDrawablesWithIntrinsicBounds(
                            android.R.drawable.star_big_off,
                            0,
                            0,
                            0);
                    saveflag = !saveflag;
                }
            }
        });
        return view;
    }
}
