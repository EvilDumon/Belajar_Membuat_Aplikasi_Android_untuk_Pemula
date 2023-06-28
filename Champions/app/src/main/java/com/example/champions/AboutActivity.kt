package com.example.champions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val imgProfile: ImageView = findViewById(R.id.img_profile_photo)
        Glide.with(this)
            .load("https://dicoding-web-img.sgp1.cdn.digitaloceanspaces.com/small/avatar/dos:220fc8b6d9b116e7f72dbbb391eaf5f320230307165606.png")
            .into(imgProfile)
    }
}