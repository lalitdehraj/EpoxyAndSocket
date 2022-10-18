package com.komaldehraj.epoxyandsocket.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.komaldehraj.epoxyandsocket.R
import com.komaldehraj.epoxyandsocket.ui.userinfo.UserInfoActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Intent(this,UserInfoActivity::class.java).apply {
            startActivity(this)
            finish()
        }
    }
}