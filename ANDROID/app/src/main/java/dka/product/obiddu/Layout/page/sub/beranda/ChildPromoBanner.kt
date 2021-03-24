package dka.product.obiddu.Layout.page.sub.beranda

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import dka.product.obiddu.R
import dka.product.obiddu.databinding.UiActivityBerandaFragmentBerandaRecyclerviewPromobannerBinding

class ChildPromoBanner(context: Context) : Fragment() {

    private var urlImage : String? = null

    constructor(context: Context, urlImage : String) : this(context){
        this.urlImage = urlImage
    }

    private lateinit var mBinding : UiActivityBerandaFragmentBerandaRecyclerviewPromobannerBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.ui_activity_beranda_fragment_beranda_recyclerview_promobanner, container, false)

        /*if (this.urlImage !== null){
            *//*Glide.with(requireActivity())
                .load(this.urlImage)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .centerCrop()
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(mBinding.imageView17)*//*
        }*/

        return mBinding.root
    }
}