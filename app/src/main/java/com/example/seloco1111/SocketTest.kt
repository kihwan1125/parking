package com.example.seloco1111

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.IOException
import java.lang.Exception
import java.net.Socket
import org.json.JSONObject

class SocketTest : AppCompatActivity() {
    var btn_cnct : Button?= null
    var recv : TextView ?= null
    private val html = ""
    private var mHandler: Handler? = null
    private var socket: Socket? = null
    private var dos: DataOutputStream? = null
    private var dis: DataInputStream? = null
    private val ip = "192.168.0.111"
    private val port = 9999

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.socket_test)

        recv = findViewById(R.id.recv)
        btn_cnct = findViewById(R.id.btn_cnct)

        fun connect() {
            mHandler = Handler()
            Log.w("connect", "연결 하는중")
            // 받아오는거
            val checkUpdate: Thread = object : Thread() {
                override fun run() {
                    // ip받기
                    val newip = ip!!.toString()

                    // 서버 접속
                    try {
                        socket = Socket(newip, port)
                        Log.w("서버 접속됨", "서버 접속됨")
                    } catch (e1: IOException) {
                        Log.w("서버접속못함", "서버접속못함")
                        e1.printStackTrace()
                    }
                    try {
                        dos = DataOutputStream(socket!!.getOutputStream()) // output에 보낼꺼 넣음
                        dis = DataInputStream(socket!!.getInputStream()) // input에 받을꺼 넣어짐
                        dos!!.writeUTF("안드로이드에서 서버로 연결요청")
                    } catch (e: IOException) {
                        e.printStackTrace()
                        Log.w("버퍼", "버퍼생성 잘못됨")
                    }
                    Log.w("버퍼", "버퍼생성 잘됨")
                    try {
                        var strData : String = ""

                        val data = dis!!.readBytes().decodeToString().trimIndent()
                        val jObject = JSONObject(data)
                        val idx = jObject.length()
                        for (i in 0 until idx) {
                            val uIndex = jObject.getJSONObject("$i")
                            val uAvailabe = uIndex.getString("available")
                            val uCarNumber = uIndex.getString("car_number")
                            val uEnteredTime = uIndex.getString("entered_time")
                            val uElapsedTime = uIndex.getString("elapsed_time")
                            val uFee = uIndex.getString("fee")
                            strData += "[$i]\n주차가능: $uAvailabe\n차번호: $uCarNumber\n입차시간: " +
                                    "$uEnteredTime\n출차시간: $uElapsedTime\n주차요금: $uFee\n\n"
                        }
                        runOnUiThread(Runnable {
                            recv!!.text = strData
                        })
                    } catch (e: Exception){e.printStackTrace()}
                }

            }
            // 소켓 접속 시도, 버퍼생성
            checkUpdate.start()
        }
        btn_cnct!!.setOnClickListener(View.OnClickListener {
            try{
                connect()
            }
            catch (e: Exception) {
                e.printStackTrace()
            }
        })

    }

}