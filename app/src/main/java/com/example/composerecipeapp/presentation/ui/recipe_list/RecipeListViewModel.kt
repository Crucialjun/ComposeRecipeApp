package com.example.composerecipeapp.presentation.ui.recipe_list

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composerecipeapp.domain.model.Recipe
import com.example.composerecipeapp.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel

class RecipeListViewModel @Inject constructor(
    private val repository: RecipeRepository,
    @Named("auth_token") private val token : String
) : ViewModel() {

    val recipes: MutableState<List<Recipe>> = mutableStateOf(ArrayList())

    var query = mutableStateOf("")

    val selectedCategory : MutableState<FoodCategory?> = mutableStateOf(null)

    var categoryScrollPosition : Float = 0f

    init {
       newSearch()
    }

    fun newSearch() {
        viewModelScope.launch {
            var result = repository.search(
                token= token,
                page = 1,
                query = query.value
            )
            recipes.value = result
        }
    }

    fun onQueryChanged(query :String){
        this.query.value = query
    }

    fun onSelectedCategoryChanged(category : String){
        val newCategory = getFoodCategory(category)
        Log.d("TAG", "onSelectedCategoryChanged:category is $category ")
        selectedCategory.value = newCategory
        onQueryChanged(category)
    }

    fun onChangedCategoryScrollPostion(postion :Float){
        categoryScrollPosition = postion;
    }
}