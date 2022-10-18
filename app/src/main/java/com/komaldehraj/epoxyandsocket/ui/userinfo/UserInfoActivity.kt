package com.komaldehraj.epoxyandsocket.ui.userinfo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.komaldehraj.epoxyandsocket.databinding.ActivityUserInfoBinding
import com.komaldehraj.epoxyandsocket.ui.chat.ChatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserInfoActivity : AppCompatActivity(), OnClickListener {
    private val userInfoViewModel:UserInfoViewModel by viewModels()
    private lateinit var binding: ActivityUserInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        binding.buttonLogin.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id){
            binding.buttonLogin.id->{
                val userName= binding.inputUsername.text.toString()
                val server= binding.inputServerAddress.text.toString()
                userInfoViewModel.saveUserData(userName,server)
                Intent(this@UserInfoActivity,ChatActivity::class.java).apply {
                    startActivity(this)
                    finishAfterTransition()
                }
            }
        }
    }
}