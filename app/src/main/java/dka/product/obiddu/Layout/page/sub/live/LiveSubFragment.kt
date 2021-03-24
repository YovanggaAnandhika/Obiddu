package dka.product.obiddu.Layout.page.sub.live

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dka.product.obiddu.R
import dka.product.obiddu.databinding.UiActivityBerandaFragmentLiveFragmentBinding
import dka.product.obiddu.src.entity.LiveRecyclerViewGridEntity
import dka.product.obiddu.src.models.adapter.recycleview.live.LiveFragmentRecyclerViewAdapter

class LiveSubFragment : Fragment() {

    private lateinit var mBinding : UiActivityBerandaFragmentLiveFragmentBinding
    private lateinit var mAdapter : LiveFragmentRecyclerViewAdapter
    private var mData : MutableList<LiveRecyclerViewGridEntity> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mData.clear()
        mData.add(LiveRecyclerViewGridEntity(1,2000,"Diskon","BELI 1 GRATIS 1", "https://th.bing.com/th/id/Raf19e49ffe421573ccf45a8a905212a8?rik=BpQYB4LsZ5gPwg&pid=ImgRaw","https://www.androidcentral.com/sites/androidcentral.com/files/topic_images/2014/Samsung-Logo.jpg","Samsung"))
        mData.add(LiveRecyclerViewGridEntity(1,2000,"Diskon","BELI 1 GRATIS 1", "https://th.bing.com/th/id/Raf19e49ffe421573ccf45a8a905212a8?rik=BpQYB4LsZ5gPwg&pid=ImgRaw","https://www.androidcentral.com/sites/androidcentral.com/files/topic_images/2014/Samsung-Logo.jpg","Samsung"))
        mData.add(LiveRecyclerViewGridEntity(1,2000,"Diskon","BELI 1 GRATIS 1", "https://th.bing.com/th/id/Raf19e49ffe421573ccf45a8a905212a8?rik=BpQYB4LsZ5gPwg&pid=ImgRaw","https://www.androidcentral.com/sites/androidcentral.com/files/topic_images/2014/Samsung-Logo.jpg","Samsung"))
        mData.add(LiveRecyclerViewGridEntity(1,2000,"Diskon","BELI 1 GRATIS 1", "https://th.bing.com/th/id/Raf19e49ffe421573ccf45a8a905212a8?rik=BpQYB4LsZ5gPwg&pid=ImgRaw","https://www.androidcentral.com/sites/androidcentral.com/files/topic_images/2014/Samsung-Logo.jpg","Samsung"))
        mAdapter = LiveFragmentRecyclerViewAdapter(requireActivity(), mData)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mBinding = DataBindingUtil.inflate(inflater, R.layout.ui_activity_beranda_fragment_live_fragment, container, false)

        mBinding.mRecyclerView.apply {
            layoutManager = GridLayoutManager(requireActivity(), 2, GridLayoutManager.VERTICAL, false)
            adapter = mAdapter
        }

        return mBinding.root
    }
}