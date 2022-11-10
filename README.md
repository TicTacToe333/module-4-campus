# module-4-campus# Overview

The software I designed is a virtual cookbook, to which the user can add or delete recipes. There are
four buttons, Add Ingredient, View All, Add Recipe, and Find Recipe (WIP). Add Ingredient will connect 
back to the Ingredient database. View All will display all the current recipes using a database toString().
Add Recipe will create a RecipeModel database, and contains all the previously added ingredients. Find Recipe
does not currently work, but the goal is to display a recipe based on the name of the dish or ingredient listed, 
and display the result from the database. To delete a recipe, the user just has to click on any tab that appears 
in View All or Find Recipe.



[Software Demo Video](http://youtube.link.goes.here)

# Relational Database

This program uses an SQLite database. There is a main RecipeModel table that stores the recipe as a whole, 
and a Ingredients table that stores the measurement, measurement device, and type of ingredient. The Ingredient
and RecipeModel have a one to many relationship (many Ingredients for one RecipeModel).


# Development Environment

This program was created in Android Studio IDE, in the Java language.
I also used the SQLite package.


# Useful Websites

{Make a list of websites that you found helpful in this project}
* [Youtube Tutorial](https://www.youtube.com/watch?v=312RhjfetP8)
* [Web Site Name](http://url.link.goes.here)

# Future Work

{Make a list of things that you need to fix, improve, and add in the future.}
* I would like to be able to use querys to find a recipe from user input.
* Item 2
* Item 3
