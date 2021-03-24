package dka.product.obiddu.Layout.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import dka.product.obiddu.Layout.BlankFragmentExample
import dka.product.obiddu.Layout.page.sub.feed.TimeLineFragment
import dka.product.obiddu.R
import dka.product.obiddu.databinding.UiActivityBerandaFragmentFeedBinding
import dka.product.obiddu.src.entity.FeedViewPagerModelEntity
import dka.product.obiddu.src.models.adapter.recycleview.ViewPagerAdapterFeed

class FeedFragment : Fragment() {

    private lateinit var mBinding : UiActivityBerandaFragmentFeedBinding
    private lateinit var mAdapterviewPager : ViewPagerAdapterFeed
    private var mModelDataList : MutableList<FeedViewPagerModelEntity> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mModelDataList.clear()
        mModelDataList.add(FeedViewPagerModelEntity(1,"TimeLine", TimeLineFragment()))
        mModelDataList.add(FeedViewPagerModelEntity(1,"TimeLine", BlankFragmentExample()))
        mModelDataList.add(FeedViewPagerModelEntity(1,"TimeLine", BlankFragmentExample()))
        mModelDataList.add(FeedViewPagerModelEntity(1,"TimeLine", BlankFragmentExample()))
        mModelDataList.add(FeedViewPagerModelEntity(1,"TimeLine", BlankFragmentExample()))
        mModelDataList.add(FeedViewPagerModelEntity(1,"TimeLine", BlankFragmentExample()))
        mModelDataList.add(FeedViewPagerModelEntity(1,"TimeLine", BlankFragmentExample()))


        mAdapterviewPager = ViewPagerAdapterFeed(childFragmentManager, mModelDataList)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mBinding = DataBindingUtil.inflate(inflater, R.layout.ui_activity_beranda_fragment_feed, container, false)

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.apply {
            mViewPager.apply {
                adapter = mAdapterviewPager
            }
            mTabLayout.setupWithViewPager(mViewPager)

        }
    }


}