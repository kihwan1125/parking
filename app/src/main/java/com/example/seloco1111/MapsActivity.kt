package com.example.seloco1111

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView


class MapsActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val mapView = MapView(this)
        val mapViewContainer = findViewById<View>(R.id.mapView) as RelativeLayout
        //runOnUiThread(Runnable {
            mapViewContainer.addView(mapView)
        //})


        mapView.setMapViewEventListener(this)
        mapView.setPOIItemEventListener(this)


    }
}

private fun MapView.setPOIItemEventListener(mapsActivity: MapsActivity) {

}

private fun MapView.setMapViewEventListener(mapsActivity: MapsActivity) {

}
