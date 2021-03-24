package dka.product.obiddu.Layout.page.sub.feed

import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import dka.product.obiddu.R
import dka.product.obiddu.databinding.UiActivityBerandaFragmentFeedTimelineBinding
import dka.product.obiddu.src.entity.FeedRecyclerViewGrid
import dka.product.obiddu.src.entity.FeedViewPagerModelEntity
import dka.product.obiddu.src.models.adapter.recycleview.feed.TimeLineViewPagerAdapter

class TimeLineFragment : Fragment() {

    private lateinit var mBinding : UiActivityBerandaFragmentFeedTimelineBinding
    private lateinit var mAdapter : TimeLineViewPagerAdapter
    private var mData : MutableList<FeedRecyclerViewGrid> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mData.clear()
        mData.add(FeedRecyclerViewGrid("1","https://th.bing.com/th/id/Rf235df31791143da096786fa4b03f832?rik=bFmJEwpPfTkozw&pid=ImgRaw","Samsung", "https://th.bing.com/th/id/OIP.92YxtKv3sNlwbTs31TqYCQHaE7?pid=ImgDet&rs=1", "Ayo Buruan Belanja Sekarang","11 Jam Lalu"))
        mData.add(FeedRecyclerViewGrid("1","https://th.bing.com/th/id/Rf235df31791143da096786fa4b03f832?rik=bFmJEwpPfTkozw&pid=ImgRaw","Toshiba", "https://i.ytimg.com/vi/ZHsO8XlKwtc/maxresdefault.jpg", "Ayo Buruan Belanja Sekarang","11 Jam Lalu"))
        mData.add(FeedRecyclerViewGrid("1","https://th.bing.com/th/id/Rf235df31791143da096786fa4b03f832?rik=bFmJEwpPfTkozw&pid=ImgRaw","Samsug", "https://data1.ibtimes.co.in/en/full/680478/samsung-products-display.jpg", "Ayo Buruan Belanja Sekarang","11 Jam Lalu"))
        mData.add(FeedRecyclerViewGrid("1","https://th.bing.com/th/id/Rf235df31791143da096786fa4b03f832?rik=bFmJEwpPfTkozw&pid=ImgRaw","Samsug", "https://www.designerappliances.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/s/a/samsung_ms14k6000ag_3.jpg", "Ayo Buruan Belanja Sekarang","11 Jam Lalu"))

        mAdapter = TimeLineViewPagerAdapter(requireActivity(), mData)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mBinding = DataBindingUtil.inflate(inflater, R.layout.ui_activity_beranda_fragment_feed_timeline, container, false)

        mBinding.mRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
            adapter = mAdapter
        }

        return mBinding.root
    }
}