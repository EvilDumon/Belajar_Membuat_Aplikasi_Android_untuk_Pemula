package com.example.champions

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvName: TextView = findViewById(R.id.tv_detail_name)
        val tvAlias: TextView = findViewById(R.id.tv_detail_alias)
        val tvWiseWord: TextView = findViewById(R.id.tv_detail_wise_word)
        val tvStory: TextView = findViewById(R.id.tv_detail_story)
        val ivPhoto: ImageView = findViewById(R.id.img_detail)

        val champion = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_DETAIL, Champion::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_DETAIL)
        }

        if (champion != null) {
            tvName.text = champion.name
            tvAlias.text = champion.alias
            tvWiseWord.text = champion.wiseWord
            tvStory.text = champion.story
            Glide.with(this)
                .load(champion.photo)
                .into(ivPhoto)
        }
    }
}