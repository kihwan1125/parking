package com.example.seloco1111

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class TestpsActivity : AppCompatActivity() {

    var layout_B1 : LinearLayout ?= null
    var layout_B2 : LinearLayout ?= null
    var layout_B3 : LinearLayout ?= null

    var iv_flr_B1 : ImageView ?= null
    var iv_flr_B2 : ImageView ?= null
    var iv_flr_B3 : ImageView ?= null

    var btn_flr_B1 : Button ?= null
    var btn_flr_B2 : Button ?= null
    var btn_flr_B3 : Button ?= null

    var txtvw_choose : TextView ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testps)

        iv_flr_B1 = findViewById(R.id.iv_flr_B1)
        iv_flr_B2 = findViewById(R.id.iv_flr_B2)
        iv_flr_B3 = findViewById(R.id.iv_flr_B3)

        btn_flr_B1 = findViewById(R.id.btn_flr_B1)
        btn_flr_B2 = findViewById(R.id.btn_flr_B2)
        btn_flr_B3 = findViewById(R.id.btn_flr_B3)

        layout_B1 = findViewById(R.id.layout_B1)
        layout_B2 = findViewById(R.id.layout_B2)
        layout_B3 = findViewById(R.id.layout_B3)

        txtvw_choose = findViewById(R.id.txtvw_choose)

        btn_flr_B1!!.setOnClickListener(View.OnClickListener {
            layout_B1!!.visibility = View.VISIBLE
            layout_B2!!.visibility = View.GONE
            layout_B3!!.visibility = View.GONE
            txtvw_choose!!.visibility = View.GONE
        })

        btn_flr_B2!!.setOnClickListener(View.OnClickListener {
            layout_B1!!.visibility = View.GONE
            layout_B2!!.visibility = View.VISIBLE
            layout_B3!!.visibility = View.GONE
            txtvw_choose!!.visibility = View.GONE
        })

        btn_flr_B3!!.setOnClickListener(View.OnClickListener {
            layout_B1!!.visibility = View.GONE
            layout_B2!!.visibility = View.GONE
            layout_B3!!.visibility = View.VISIBLE
            txtvw_choose!!.visibility = View.GONE
        })

        }

    }
