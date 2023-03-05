package com.example.composerecipeapp.presentation.ui.recipe_list

import androidx.lifecycle.ViewModel
import com.example.composerecipeapp.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Named

@HiltViewModel
class RecipeListViewModel(
    private val repository: RecipeRepository,
    @Named("auth_token") private val token : String
) : ViewModel() {
}