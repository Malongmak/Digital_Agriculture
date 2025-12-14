package com.makertest.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val titleText = findViewById<TextView>(R.id.title_text)
        titleText.text = "MakerTest - Digital Agriculture for South Sudan"
    }
}
