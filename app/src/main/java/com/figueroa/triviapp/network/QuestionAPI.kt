package com.figueroa.triviapp.network

import com.figueroa.triviapp.model.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionAPI {

    @GET("world.json")
    suspend fun getAllQuestions(): Question
}
