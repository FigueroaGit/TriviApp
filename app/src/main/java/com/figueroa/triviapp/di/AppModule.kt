package com.figueroa.triviapp.di

import com.figueroa.triviapp.network.QuestionAPI
import com.figueroa.triviapp.repository.QuestionRepository
import com.figueroa.triviapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideQuestionRepository(API: QuestionAPI) = QuestionRepository(API)

    @Singleton
    @Provides
    fun provideQuestionAPI(): QuestionAPI {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(
            GsonConverterFactory.create(),
        ).build().create(QuestionAPI::class.java)
    }
}
