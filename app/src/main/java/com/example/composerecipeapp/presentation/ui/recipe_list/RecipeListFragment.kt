package com.example.composerecipeapp.presentation.ui.recipe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.composerecipeapp.presentation.components.RecipeCard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment : Fragment() {

    private val viewModel: RecipeListViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                val recipes = viewModel.recipes.value
                var query = viewModel.query.value
                Column {
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        color = MaterialTheme.colorScheme.primary,
                        tonalElevation = 8.dp,
                        shadowElevation = 8.dp
                    ) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            TextField(
                                modifier = Modifier
                                    .fillMaxWidth(0.9f)
                                    .padding(8.dp),
                                value = query,
                                onValueChange = {
                                    viewModel.onQueryChanged(it)
                                },
                                label = {
                                    Text(text = "Search")
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Text,
                                    imeAction = ImeAction.Search,
                                ),
                                leadingIcon = { Icon (Icons.Filled.Search,"")},
                                keyboardActions = KeyboardActions(

                                    onSearch = {
                                        viewModel.newSearch(query.text)

                                    }
                                ),
                                textStyle = TextStyle(color = MaterialTheme.colorScheme.onSurface),

                            )


                        }
                    }
                    LazyColumn(

                    ) {
                        itemsIndexed(
                            items = recipes
                        ) { index, recipe ->
                            RecipeCard(recipe = recipe, onClick = {})


                        }
                    }

                }
            }
        }
    }
}