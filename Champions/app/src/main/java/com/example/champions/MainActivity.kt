package com.example.champions

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity(){
    private lateinit var rvChampions: RecyclerView
    private val list = ArrayList<Champion>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvChampions = findViewById(R.id.rv_champions)
        rvChampions.setHasFixedSize(true)

        list.addAll(getListChampions())
        showRecycleList(list)
    }

    private fun getListChampions(): ArrayList<Champion>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataAlias = resources.getStringArray(R.array.data_alias)
        val dataRegion = resources.getStringArray(R.array.data_region)
        val dataWiseWord = resources.getStringArray(R.array.data_wise_word)
        val dataStory = resources.getStringArray(R.array.data_story)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataMiniPhoto = resources.getStringArray(R.array.data_mini_photo)
        val dataIcRegion = resources.getStringArray(R.array.data_icon_region)
        val listChampion = ArrayList<Champion>()

        for(i in dataName.indices){
            val champion = Champion(dataName[i], dataAlias[i], dataRegion[i], dataWiseWord[i], dataStory[i], dataPhoto[i], dataMiniPhoto[i], dataIcRegion[i])
            listChampion.add(champion)
        }
        return listChampion
    }

    private fun showRecycleList(listChampion: ArrayList<Champion>){
        val listChampionAdapter = ListChampionAdapter(listChampion)
        rvChampions.layoutManager = LinearLayoutManager(this)
        rvChampions.adapter = listChampionAdapter

        listChampionAdapter.setOnItemClickCallback(object : ListChampionAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Champion) {
                val detailIntent = Intent(this@MainActivity, DetailActivity::class.java)
                detailIntent.putExtra(DetailActivity.EXTRA_DETAIL, data)
                startActivity(detailIntent)
            }
        })
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.about_page -> {
                val aboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(aboutIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
