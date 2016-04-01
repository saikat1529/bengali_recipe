package com.saikat.personal.newdrawerlayouttemplate.Object;

/**
 * Created by fojlesaikat on 16/12/15.
 */
public class Category {
    int category_id;
    int bitmap;
    String title;
    String subtitle;
    boolean favourite;

    public int getCategory_id() {
        return category_id;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getTitle() {
        return title;
    }

    public int getBitmap() {
        return bitmap;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setBitmap(int bitmap) {
        this.bitmap = bitmap;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
