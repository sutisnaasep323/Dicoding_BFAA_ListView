package com.example.mylistview

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // testing - > private val dataName = arrayOf("Cut Nyak Dien", "Ki Hajar Dewantara", "Moh Yamin", "Pattimura", "R A Kartini", "Sukarno")
    private lateinit var adapter : HeroAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var heroes = arrayListOf<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //testing
//        val listView : ListView = findViewById(R.id.lv_list)
//        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, dataName)
//        listView.adapter = adapter

        val listView: ListView = findViewById(R.id.lv_list)
        adapter = HeroAdapter(this)
        listView.adapter = adapter

        prepare()   // siapkan data. ini digunakan untuk inisiasi setiap data
        addItem() // masukkan data tsb dg looping

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this@MainActivity, heroes[position].name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun addItem() {
        //digunakan untuk memasukan data data ke arraylist supaya bisa diproses oleh adapter
        for (position in dataName.indices) { // Membuat perulangan dan menggunakan model untuk setter setiap data
            val hero = Hero(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataDescription[position]
            )
            heroes.add(hero) // untuk memasukan ke arraylist, lalu memanggil setter yang berada di adapter dan memasukan arraylist heroes sebagai argumen
        }
        adapter.heroes = heroes // memasukkan data
    }

    private fun prepare() {
        //Di sini kita memanggil array yang tadi sudah dibuat pada berkas strings.xml
        dataName = resources.getStringArray(R.array.data_name)
        dataDescription = resources.getStringArray(R.array.data_description)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
    }
}