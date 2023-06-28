package com.example.champions

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Champion(
    val name: String,
    val alias: String,
    val region: String,
    val wiseWord: String,
    val story: String,
    val photo: String,
    val miniPhoto: String,
    val icRegion: String
): Parcelable
