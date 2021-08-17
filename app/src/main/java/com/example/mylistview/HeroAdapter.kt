package com.example.mylistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.mylistview.databinding.ItemHeroBinding
import de.hdodenhof.circleimageview.CircleImageView

class HeroAdapter internal constructor(private val context: Context): BaseAdapter(){
    //constructor disini untuk mengirimkan context ke dalam adapter
    internal var heroes = arrayListOf<Hero>()
    // Variable heroes berfungsi untuk menampung data yang dikirim dari activity dan digunakan sebagai sumber data untuk dimasukkan ke dalam ViewHolder

    // override fun getCount(): Int = heroes.size -> cara singkat
    override fun getCount(): Int { // getCount() digunakan untuk mengetahui berapa banyak item yang akan ditampilkan.
        return heroes.size
    }

    override fun getItem(i: Int): Any {
        return heroes[i]
    }

    /* cara singkat getItem dan getItemId
    override fun getItem(i: Int): Any = heroes[i]
    override fun getItemId(i: Int): Long = i.toLong()
     */

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    //pemanggilan textView dan setText
    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        var itemView = view
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_hero, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val hero = getItem(position) as Hero
        viewHolder.bind(hero)
        return itemView

        // getView()  digunakan untuk memanggil layout item xml yang sudah dibuat dan melakukan proses manipulasi setiap komponennya seperti textview dan imageview melalui kelas ViewHolder
    }

    private inner class ViewHolder internal constructor(view: View) {
        //kode ini akan di refactor menggunakan view binding
//        private val txtName: TextView = view.findViewById(R.id.txt_name)
//        private val txtDescription: TextView = view.findViewById(R.id.txt_description)
//        private val imgPhoto: CircleImageView = view.findViewById(R.id.img_photo)
        
        private val binding = ItemHeroBinding.bind(view)
        
        internal fun bind(hero: Hero) {
//            txtName.text = hero.name
//            txtDescription.text = hero.description
//            imgPhoto.setImageResource(hero.photo)
            binding.txtName.text = hero.name
            binding.txtDescription.text = hero.description
            binding.imgPhoto.setImageResource(hero.photo)
        }
    }
}