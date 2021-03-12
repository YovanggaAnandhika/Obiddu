package dka.product.obiddu.src.models.adapter.recycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import dka.product.obiddu.R
import dka.product.obiddu.databinding.UiRecyclerviewBerandaFragmentBerandaModelFlashsaleBinding
import dka.product.obiddu.databinding.UiRecycleviewBerandaFragmentBerandaRekomendasiBinding
import dka.product.obiddu.databinding.UiRecycleviewBerandaFragmentBerandaTerlarisBinding

class FlashSale(var context : Context) : RecyclerView.Adapter<FlashSale.myholder>() {

    private lateinit var mbinding : UiRecyclerviewBerandaFragmentBerandaModelFlashsaleBinding
    private  var mData : MutableList<FlashSaleEntity> = mutableListOf()

    data class FlashSaleEntity(

            var id_product: Int? = null,
            var image: String? = null,
            var progressbar: Int? = null,
            var jumlahharga: String? = null,
            var sisaterjual: String? = null
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlashSale.myholder {
        mbinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.ui_recyclerview_beranda_fragment_beranda_model_flashsale, parent,false)
        return myholder(mbinding)
    }

    override fun onBindViewHolder(holder: FlashSale.myholder, position: Int) {
        /* Picasso.get().load(mData[position].image).into(holder.ui.mImage)*/
        Glide.with(context)
                .load(mData[position].image)
                .placeholder(R.drawable.img_placeholder)
                .skipMemoryCache(true)
                .centerCrop()
                .into(holder.mbind.mImage)
        holder.mbind.progressBar.progress = mData[position].progressbar!!
        holder.mbind.mJumlahHarga.text = mData[position].jumlahharga
        holder.mbind.mSisaTerjual.text = mData[position].sisaterjual

        /*holder.mbind.mLayoutFlashSale.setOnClickListener {
            i = Intent(context, FlashSaleActivity::class.java).apply {
                putExtra(PRODUCT_ID, mData[position].id_product)
            }
            context?.startActivity(i)
        }*/
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class myholder(bind : UiRecyclerviewBerandaFragmentBerandaModelFlashsaleBinding) : RecyclerView.ViewHolder(bind.root){
        val mbind = bind
    }

    fun dataBaru(mData : MutableList<FlashSaleEntity> = mutableListOf()){
        this.mData = mData
        notifyDataSetChanged()
    }

}