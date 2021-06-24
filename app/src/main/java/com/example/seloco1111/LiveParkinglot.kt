package com.example.seloco1111

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.gms.maps.GoogleMap

class LiveParkinglot: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.live_parkinglot)


        val btn = findViewById<Button>(R.id.btn7)as Button
        btn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, TestpsActivity::class.java)
            startActivity(intent)
        })
    }

}

//git add.//
//git commit -m ""//
//git push origin master