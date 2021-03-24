package dka.product.obiddu.src.models.adapter.recycleview.live

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dka.product.obiddu.R
import dka.product.obiddu.databinding.UiRecycleviewBerandaFragmentFeedViewpagerTimelineBinding
import dka.product.obiddu.databinding.UiRecycleviewBerandaFragmentLiveSubGridBinding
import dka.product.obiddu.src.entity.FeedRecyclerViewGrid
import dka.product.obiddu.src.entity.LiveRecyclerViewGridEntity
import dka.product.obiddu.src.models.adapter.recycleview.feed.TimeLineViewPagerAdapter

class LiveFragmentRecyclerViewAdapter(var context : Context) : RecyclerView.Adapter<LiveFragmentRecyclerViewAdapter.MyHolder>() {

    private lateinit var mBinding : UiRecycleviewBerandaFragmentLiveSubGridBinding
    private var mData : MutableList<LiveRecyclerViewGridEntity> = mutableListOf()

    constructor(context: Context, mData : MutableList<LiveRecyclerViewGridEntity>) : this(context){
        this.mData = mData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.ui_recycleview_beranda_fragment_live_sub_grid, parent, false)

        return MyHolder(mBinding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        Glide.with(context)
            .load(mData[position].mGambarToko)
            .placeholder(R.drawable.img_placeholder)
            .skipMemoryCache(true)
            .centerCrop()
            .into(holder.mbind.mGambarToko)

        holder.mbind.mNamaToko.text = mData[position].NamaToko

        holder.mbind.mCapts.text = mData[position].mJudul

        if (mData[position].mLabel !== null){
            holder.mbind.mLabelText.text = mData[position].mLabel
        }else{
            holder.mbind.mLabelContainer.visibility = View.GONE
        }

        Glide.with(context)
            .load(mData[position].mThumbnail)
            .placeholder(R.drawable.img_placeholder)
            .skipMemoryCache(true)
            .centerCrop()
            .into(holder.mbind.mThumnails)

    }

    override fun getItemCount(): Int = mData.size

    inner class MyHolder(var mBinding : UiRecycleviewBerandaFragmentLiveSubGridBinding) : RecyclerView.ViewHolder(mBinding.root){
        val mbind = mBinding
    }
}