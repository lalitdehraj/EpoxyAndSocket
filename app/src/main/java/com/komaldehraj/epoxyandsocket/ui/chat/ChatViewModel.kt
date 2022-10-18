package com.komaldehraj.epoxyandsocket.ui.chat

import androidx.lifecycle.ViewModel
import com.komaldehraj.epoxyandsocket.domain.models.Message
import com.komaldehraj.epoxyandsocket.domain.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    val mainRepository: MainRepository
) : ViewModel() {
    suspend fun getMessages(): Flow<List<Message>> = mainRepository.getMessages()
}
