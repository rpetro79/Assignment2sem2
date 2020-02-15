package RecipeReaderAndProxy;

import BlockingQueueAdapter.ArrayList;
import Utilities.Recipe;



public class ProxyRecipeProvider implements RecipeProvider{
    private RecipeReader reader;
    private ArrayList<Recipe> recipes;

    public ProxyRecipeProvider() {
        reader = new RecipeReader("src/RecipeReaderAndProxy/recipes.txt");
        recipes = new ArrayList<Recipe>();
    }

    @Override
    public Recipe getRecipeById(String id) throws Exception {
        for(int i = 0; i < recipes.size(); ++i)
        {
            if(recipes.get(i).getId().equals(id))
                return recipes.get(i);
        }
        recipes.add(reader.getRecipeById(id));
        return recipes.get(recipes.size()-1);
    }

    @Override
    public Recipe getRecipeByName(String name) throws Exception {
        for(int i = 0; i < recipes.size(); ++i)
        {
            if(recipes.get(i).getName().equals(name))
                return recipes.get(i);
        }
        recipes.add(reader.getRecipeByName(name));
        return recipes.get(recipes.size()-1);
    }

    @Override
    public void updateRecipe(Recipe recipe) throws Exception {
        for (int i = 0; i < recipes.size(); ++i)
            if(recipes.get(i).getId().equals(recipe.getId()))
                recipes.remove(recipes.get(i));
        recipes.add(recipe);
        reader.updateRecipe(recipe);
    }
}
