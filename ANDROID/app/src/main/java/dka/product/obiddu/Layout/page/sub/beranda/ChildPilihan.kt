package dka.product.obiddu.Layout.page.sub.beranda

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dka.product.obiddu.databinding.UiActivityBerandaFragmentBerandaViewpagerPilihanBinding

class ChildPilihan() : Fragment() {

    private lateinit var mBinding : UiActivityBerandaFragmentBerandaViewpagerPilihanBinding
    private var mHeading : String? = null

    constructor(mHeading : String) : this(){
        this.mHeading = mHeading
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        mBinding = UiActivityBerandaFragmentBerandaViewpagerPilihanBinding.inflate(inflater)

        if (mHeading !== null){
            mBinding.mHead.text = mHeading
        }


        return mBinding.root

    }
}