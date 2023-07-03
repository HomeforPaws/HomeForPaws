package com.example.homeforpaws

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        findViewById<Button>(R.id.sponBtn).setOnClickListener{
            val bottomSheet = dialogFragment()
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }
    }
}