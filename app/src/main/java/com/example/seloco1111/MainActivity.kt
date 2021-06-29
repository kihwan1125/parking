package com.example.seloco1111

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btn = findViewById<Button>(R.id.btn1) as Button
        btn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, LiveParkinglot::class.java)
            startActivity(intent)
        })

        val btnsocket = findViewById<Button>(R.id.btn_socket) as Button
        btnsocket.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, SocketTest::class.java)
            startActivity(intent)
        })

        val btn2 = findViewById<Button>(R.id.btn2) as Button
        btn2.setOnClickListener {
            var intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:***********")
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }

        }
    }
}



