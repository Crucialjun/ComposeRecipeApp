package com.example.composerecipeapp.presentation.ui.recipe_list

import com.example.composerecipeapp.presentation.ui.recipe_list.FoodCategory.BEEF
import com.example.composerecipeapp.presentation.ui.recipe_list.FoodCategory.CHICKEN
import com.example.composerecipeapp.presentation.ui.recipe_list.FoodCategory.DESSERT
import com.example.composerecipeapp.presentation.ui.recipe_list.FoodCategory.DONUT
import com.example.composerecipeapp.presentation.ui.recipe_list.FoodCategory.MILK
import com.example.composerecipeapp.presentation.ui.recipe_list.FoodCategory.PIZZA
import com.example.composerecipeapp.presentation.ui.recipe_list.FoodCategory.SOUP
import com.example.composerecipeapp.presentation.ui.recipe_list.FoodCategory.VEGAN
import com.example.composerecipeapp.presentation.ui.recipe_list.FoodCategory.VEGETARIAN

enum class FoodCategory(val value: String) {
    CHICKEN("Chicken"),
    BEEF("Beef"),
    SOUP("Soup"),
    DESSERT("Dessert"),
    VEGETARIAN("Vegatarian"),
    MILK("Milk"),
    VEGAN("Vegan"),
    PIZZA("Pizza"),
    DONUT("Donut")
}

fun getAllFoodCategories(): List<FoodCategory> {
    return listOf(
        CHICKEN,
        BEEF,
        SOUP,
        DESSERT,
        VEGETARIAN,
        MILK,
        VEGAN,
        PIZZA,
        DONUT
    )
}

fun getFoodCategory(value:String): FoodCategory? {
    val map = FoodCategory.values().associateBy(FoodCategory::value)
    return map[value]
}
