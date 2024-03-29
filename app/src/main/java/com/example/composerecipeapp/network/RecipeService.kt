package com.example.composerecipeapp.network

import com.example.composerecipeapp.network.model.RecipeDto
import com.example.composerecipeapp.network.responses.RecipeSearchResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface  RecipeService {
    @GET("search")
    suspend fun search(
        @Header("Authorization")token : String,
        @Query("page") page : Int,
        @Query("query") query :String) :RecipeSearchResponse

    @GET("get")
    suspend fun getRecipes(
        @Header("Authorization")token : String,
        @Query("id") id : Int) :RecipeDto
}
