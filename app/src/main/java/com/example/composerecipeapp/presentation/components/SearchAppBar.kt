package com.example.composerecipeapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.composerecipeapp.presentation.ui.recipe_list.FoodCategory
import com.example.composerecipeapp.presentation.ui.recipe_list.getAllFoodCategories
import com.example.composerecipeapp.ui.theme.Purple80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchAppBar(
    query:String,
    onQueryChanged :(String) -> Unit,
    newSearch :() -> Unit,
    onSelectedCategoryChanged :(String) -> Unit,
    selectedCategory : FoodCategory?

){
    Surface(

        color = Color.White,
        tonalElevation = 8.dp,
        shadowElevation = 8.dp
    ) {
        Column {
            Row(modifier = Modifier.fillMaxWidth()) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(8.dp),
                    value = query,
                    onValueChange = {
                        onQueryChanged(it)
                    },
                    label = {
                        Text(text = "Search")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Search,
                    ),
                    leadingIcon = { Icon(Icons.Filled.Search, "") },
                    keyboardActions = KeyboardActions(

                        onSearch = {
                            newSearch

                        }
                    ),
                    textStyle = TextStyle(color = MaterialTheme.colorScheme.onSurface),

                    )


            }


            ScrollableTabRow(

                selectedTabIndex = 0,
                modifier = Modifier.padding(bottom = 8.dp),
                divider = {},
                edgePadding = 0.dp,


                ) {
                for (category in getAllFoodCategories()) {
                    SuggestionChip(

                        onClick = {
                            onSelectedCategoryChanged(category.value)
                            newSearch()

                        },
                        label = {
                            Text(
                                category.value,
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.White,
                                modifier = Modifier.padding(8.dp)
                            )
                        },
                        modifier = Modifier.padding(end = 8.dp),
                        colors =
                        SuggestionChipDefaults.suggestionChipColors(

                            containerColor = if (selectedCategory == category) Purple80 else Color.Blue
                        )

                    )

                }
            }
        }


    }
}