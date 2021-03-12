package dka.product.obiddu.src.models.adapter.recycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import dka.product.obiddu.R
import dka.product.obiddu.databinding.UiRecycleviewBerandaFragmentBerandaTerlarisBinding

class recycleterlaris(var context : Context) : RecyclerView.Adapter<recycleterlaris.myholder>() {

    private lateinit var mbinding : UiRecycleviewBerandaFragmentBerandaTerlarisBinding
    private  var mData : MutableList<mIcon> = mutableListOf()

    data class mIcon(
        var gambar : Int,
        var nama : String,
        var toko : String
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): recycleterlaris.myholder {
        mbinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.ui_recycleview_beranda_fragment_beranda_terlaris, parent,false)
        return myholder(mbinding)
    }

    override fun onBindViewHolder(holder: recycleterlaris.myholder, position: Int) {
        Glide.with(context)
            .load( mData[position].gambar)
            .centerCrop()
            .placeholder(R.drawable.placeholder)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(holder.mbind.gambaritem)

        holder.mbind.namaitem.setText(mData[position].nama)
        holder.mbind.namatoko.setText(mData[position].toko)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class myholder(bind : UiRecycleviewBerandaFragmentBerandaTerlarisBinding) : RecyclerView.ViewHolder(bind.root){
        val mbind = bind
    }

    fun dataBaru(mData : MutableList<mIcon> = mutableListOf()){
        this.mData = mData
        notifyDataSetChanged()
    }

}