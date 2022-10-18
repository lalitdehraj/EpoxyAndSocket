package com.komaldehraj.epoxyandsocket.domain.repositories

import android.content.SharedPreferences
import com.komaldehraj.epoxyandsocket.domain.models.Message
import com.komaldehraj.epoxyandsocket.utils.Constants
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    fun setUserNameAndURI(userName: String, server: String) {
        sharedPreferences.edit().apply {
            putString(Constants.USER_NAME, userName)
            putString(Constants.SERVER_ADDRESS_URI, server)
            apply()
        }
    }

    fun getUserName(): String? = sharedPreferences.getString(Constants.USER_NAME, null)

    fun getServer(): String? = sharedPreferences.getString(Constants.USER_NAME, null)

    suspend fun getMessages():Flow<List<Message>>{
        delay(1000)
        val messages= mutableListOf<Message>()
        for ( i in 1..20){
            messages.add(
                Message(
                "$i","lalit $i","lalit dehraj $i"
            ))
        }
        return flow { emit(messages.toList())
        }

    }

}