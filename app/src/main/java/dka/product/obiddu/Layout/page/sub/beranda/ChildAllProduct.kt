package dka.product.obiddu.Layout.page.sub.beranda

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import dka.product.obiddu.databinding.UiActivityBerandaFragmentBerandaViewpagerAllproductBinding
import dka.product.obiddu.src.entity.AllProductGridEntity
import dka.product.obiddu.src.models.adapter.recycleview.AllProductGrid

class ChildAllProduct : Fragment() {

    private lateinit var mBinding : UiActivityBerandaFragmentBerandaViewpagerAllproductBinding
    private lateinit var mAdapter : AllProductGrid
    private var mDataList : MutableList<AllProductGridEntity> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAdapter = AllProductGrid(requireActivity())
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        mBinding = UiActivityBerandaFragmentBerandaViewpagerAllproductBinding.inflate(LayoutInflater.from(requireActivity()))

        mDataList.clear()
        mDataList.add(AllProductGridEntity(1, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ0GvaV5drqsLVIc3UEr-M1ymBJ0J8yUY47YXAdLJ-zgmFRYGCWALxQ2SRzqVwsarAAIOQ&usqp=CAU","Paket Lengkap Bumbu Dapur","Nikmati Masakan Nikmat Tanpa Ribet","800.000"))
        mDataList.add(AllProductGridEntity(2, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ0GvaV5drqsLVIc3UEr-M1ymBJ0J8yUY47YXAdLJ-zgmFRYGCWALxQ2SRzqVwsarAAIOQ&usqp=CAU","Paket Lengkap Bumbu Dapur","Nikmati Masakan Nikmat Tanpa Ribet","800.000"))
        mDataList.add(AllProductGridEntity(3, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ0GvaV5drqsLVIc3UEr-M1ymBJ0J8yUY47YXAdLJ-zgmFRYGCWALxQ2SRzqVwsarAAIOQ&usqp=CAU","Paket Lengkap Bumbu Dapur","Nikmati Masakan Nikmat Tanpa Ribet","800.000"))
        mDataList.add(AllProductGridEntity(4, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ0GvaV5drqsLVIc3UEr-M1ymBJ0J8yUY47YXAdLJ-zgmFRYGCWALxQ2SRzqVwsarAAIOQ&usqp=CAU","Paket Lengkap Bumbu Dapur","Nikmati Masakan Nikmat Tanpa Ribet","800.000"))


        mBinding.mAllProductGrid.apply {
            layoutManager = GridLayoutManager(requireActivity(), 2, GridLayoutManager.HORIZONTAL,false)
            adapter = mAdapter
        }

        mAdapter.setData(mDataList)


        return mBinding.root

    }
}