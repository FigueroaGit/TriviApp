package com.figueroa.triviapp.repository

import android.util.Log
import com.figueroa.triviapp.data.DataOrException
import com.figueroa.triviapp.model.QuestionItem
import com.figueroa.triviapp.network.QuestionAPI
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val API: QuestionAPI) {
    private val dataOrException = DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()

    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>, Boolean, java.lang.Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = API.getAllQuestions()

            if (dataOrException.data.toString().isNotEmpty()){
                dataOrException.loading = false
            }

        }catch (exception: Exception) {
            dataOrException.e = exception
            Log.d("Exc", "getAllQuestions: ${dataOrException.e!!.localizedMessage}")
        }
        return dataOrException
    }
}
