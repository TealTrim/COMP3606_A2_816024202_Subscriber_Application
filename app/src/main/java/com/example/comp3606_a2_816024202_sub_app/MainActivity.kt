/*
-------------------------------------------
Student Information:
-------------------------------------------
Student Name: Teal Trim
Student ID: 816024202
Course: Wireless and Mobile Computing (COMP3606)
Assignment: COMP3606 Assignment 2
Date: 20/11/2024
-------------------------------------------
*/

package com.example.comp3606_a2_816024202_sub_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.hivemq.client.mqtt.mqtt5.Mqtt5BlockingClient

class MainActivity : AppCompatActivity(), OnMapReadyCallback
{
    //Subscriber Application: (Map Stuff)
    //Attributes:
    private var client: Mqtt5BlockingClient? = null
    private lateinit var mMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
    }
}