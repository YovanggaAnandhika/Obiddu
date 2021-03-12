package dka.product.obiddu.src.models.adapter.recycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import dka.product.obiddu.R
import dka.product.obiddu.databinding.UiRecycleviewBerandaFragmentBerandaRekomendasiBinding

class recycleviewrekomendasi(var context : Context) : RecyclerView.Adapter<recycleviewrekomendasi.MyHolder>() {

    private lateinit var mbinding : UiRecycleviewBerandaFragmentBerandaRekomendasiBinding
    private var mData : MutableList<mModel> = mutableListOf()

    class mModel(
            var gambar : Int,
            var nama : String,
            var normal : String,
            var diskon : String
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): recycleviewrekomendasi.MyHolder {
        mbinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.ui_recycleview_beranda_fragment_beranda_rekomendasi, parent, false)
        return MyHolder(mbinding)
    }

    override fun onBindViewHolder(holder: recycleviewrekomendasi.MyHolder, position: Int) {
        Glide.with(context)
                .load( mData[position].gambar)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(holder.buat.mgambar)

        holder.buat.mNamaBarang.setText(mData[position].nama)
        holder.buat.mNormal.setText(mData[position].normal)
        holder.buat.mDiskon.setText(mData[position].diskon)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class MyHolder(bind : UiRecycleviewBerandaFragmentBerandaRekomendasiBinding) : RecyclerView.ViewHolder(bind.root){
        val buat = bind
    }

    fun dataBaru(mData : MutableList<recycleviewrekomendasi.mModel> = mutableListOf()){
        this.mData = mData
        notifyDataSetChanged()
    }

}