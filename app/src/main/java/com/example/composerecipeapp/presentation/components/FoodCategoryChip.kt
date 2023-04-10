package com.example.composerecipeapp.presentation.components

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import com.google.android.material.chip.Chip
import kotlin.coroutines.jvm.internal.CompletedContinuation.context

@Composable
fun FoodCategorychip(
    category : String,
    onExecuteSearch : (String) -> Unit,
    context: Context
){
    Chip(

    ) {

    }
}