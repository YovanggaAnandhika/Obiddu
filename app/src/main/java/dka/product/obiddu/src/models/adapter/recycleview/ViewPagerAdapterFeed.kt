package dka.product.obiddu.src.models.adapter.recycleview

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import dka.product.obiddu.src.entity.FeedViewPagerModelEntity

class ViewPagerAdapterFeed(fm : FragmentManager) : FragmentStatePagerAdapter(fm) {

    private var mDataModel : MutableList<FeedViewPagerModelEntity> = mutableListOf()

    constructor(fm: FragmentManager, mDataModel : MutableList<FeedViewPagerModelEntity>) : this(fm){
        this.mDataModel = mDataModel
    }
    override fun getCount(): Int {
        return mDataModel.size
    }

    override fun getItem(position: Int): Fragment {
        return mDataModel[position].mFragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mDataModel[position].mTitle
    }

}