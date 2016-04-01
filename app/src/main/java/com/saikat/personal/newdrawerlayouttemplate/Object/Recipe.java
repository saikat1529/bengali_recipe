package com.saikat.personal.newdrawerlayouttemplate.Object;

/**
 * Created by fojlesaikat on 18/12/15.
 */
public class Recipe {
    int recipe_id;
    int recipe_image;
    String recipe_title;
    String recipe_provider;

    public int getRecipe_id() {
        return recipe_id;
    }

    public int getRecipe_image() {
        return recipe_image;
    }

    public String getRecipe_title() {
        return recipe_title;
    }

    public String getRecipe_provider() {
        return recipe_provider;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }

    public void setRecipe_image(int recipe_image) {
        this.recipe_image = recipe_image;
    }

    public void setRecipe_title(String recipe_title) {
        this.recipe_title = recipe_title;
    }

    public void setRecipe_provider(String recipe_provider) {
        this.recipe_provider = recipe_provider;
    }
}
