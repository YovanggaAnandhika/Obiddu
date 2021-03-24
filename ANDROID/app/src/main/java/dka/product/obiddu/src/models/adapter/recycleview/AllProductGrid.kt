package dka.product.obiddu.src.models.adapter.recycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dka.product.obiddu.R
import dka.product.obiddu.databinding.UiRecycleviewBerandaFragmentBerandaAllproductBinding
import dka.product.obiddu.src.entity.AllProductGridEntity

class AllProductGrid(var context: Context) : RecyclerView.Adapter<AllProductGrid.MyHolder>() {

    private lateinit var mBinding : UiRecycleviewBerandaFragmentBerandaAllproductBinding
    private var mModelData : MutableList<AllProductGridEntity> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        mBinding = UiRecycleviewBerandaFragmentBerandaAllproductBinding.inflate(LayoutInflater.from(context))
        return MyHolder(mBinding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind.mTitle.text = mModelData[position].mTitle
        holder.bind.mDesc.text = mModelData[position].mDesc
        holder.bind.mPrice.text = mModelData[position].mPrice

        Glide.with(context)
            .load(mModelData[position].mGambar)
            .placeholder(R.drawable.img_placeholder)
            .skipMemoryCache(true)
            .centerCrop()
            .into(holder.bind.mGambar)
    }

    override fun getItemCount(): Int = mModelData.size

    inner class MyHolder(ui : UiRecycleviewBerandaFragmentBerandaAllproductBinding) : RecyclerView.ViewHolder(ui.root) {
        val bind = ui
    }

    fun setData (mModelEntity : MutableList<AllProductGridEntity>){
        this.mModelData = mModelEntity
        notifyDataSetChanged()
    }
}