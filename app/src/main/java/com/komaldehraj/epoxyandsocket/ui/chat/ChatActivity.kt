package com.komaldehraj.epoxyandsocket.ui.chat

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.komaldehraj.epoxyandsocket.databinding.ActivityChatBinding
import com.komaldehraj.epoxyandsocket.domain.models.Message
import com.komaldehraj.epoxyandsocket.messageItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChatBinding
    private var messagesList = emptyList<Message>()
    private val chatViewModel: ChatViewModel by viewModels()

    //    private val username by lazy { chatViewModel.mainRepository.getUserName() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        attachObservers()
    }


    private fun initViews() {
        setUpRecyclerView()
    }

    private fun attachObservers() {
        lifecycleScope.launchWhenStarted {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                chatViewModel.getMessages().collect {
                    messagesList = it
                    binding.messageRecycler.requestModelBuild()
                }
            }
        }
    }

    private fun setUpRecyclerView() {

        binding.messageRecycler.apply {
            layoutManager = LinearLayoutManager(this@ChatActivity).apply { stackFromEnd = true }
            withModels {
                messagesList.forEachIndexed { pos, msg ->
                    messageItem {
                        id(msg.uid)
                        message(msg)
                        isOutGoing(pos%3==0)
                    }
                }
            }
        }
    }
}