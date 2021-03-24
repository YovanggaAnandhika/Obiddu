package dka.product.obiddu.src.models.adapter.recycleview.feed

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dka.product.obiddu.R
import dka.product.obiddu.databinding.UiRecycleviewBerandaFragmentFeedViewpagerTimelineBinding
import dka.product.obiddu.src.entity.FeedRecyclerViewGrid
import java.sql.Time

class TimeLineViewPagerAdapter(var context : Context) : RecyclerView.Adapter<TimeLineViewPagerAdapter.MyHolder>() {

    private lateinit var mBinding : UiRecycleviewBerandaFragmentFeedViewpagerTimelineBinding
    private var mData : MutableList<FeedRecyclerViewGrid> = mutableListOf()

    constructor(context: Context, mData : MutableList<FeedRecyclerViewGrid>) : this(context){
        this.mData = mData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.ui_recycleview_beranda_fragment_feed_viewpager_timeline, parent, false)

        return MyHolder(mBinding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        Glide.with(context)
            .load(mData[position].mProfileToko)
            .placeholder(R.drawable.img_placeholder)
            .skipMemoryCache(true)
            .centerCrop()
            .into(holder.mbind.mGambarToko)

        holder.mbind.mNamaToko.text = mData[position].mNamaToko
        holder.mbind.mNamaToko2.text = mData[position].mNamaToko

        holder.mbind.mCapts.text = mData[position].mCapts

        Glide.with(context)
            .load(mData[position].mGambarFeed)
            .placeholder(R.drawable.img_placeholder)
            .skipMemoryCache(true)
            .centerCrop()
            .into(holder.mbind.mGambarProduct)

    }

    override fun getItemCount(): Int = mData.size

    inner class MyHolder(var mBinding : UiRecycleviewBerandaFragmentFeedViewpagerTimelineBinding) : RecyclerView.ViewHolder(mBinding.root){
        val mbind = mBinding
    }
}