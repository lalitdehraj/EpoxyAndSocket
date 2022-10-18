package com.komaldehraj.epoxyandsocket.ui.userinfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.komaldehraj.epoxyandsocket.domain.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UserInfoViewModel @Inject constructor(
    val mainRepository: MainRepository
) : ViewModel() {

    fun saveUserData(userName: String, server: String) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            mainRepository.setUserNameAndURI(userName = userName, server = server)
        }
    }
}