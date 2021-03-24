package dka.product.obiddu.Layout.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import dka.product.obiddu.R

import dka.product.obiddu.databinding.UiActivityBerandaFragmentUserBinding


class SayaFragment : Fragment() {

    private lateinit var mBinding : UiActivityBerandaFragmentUserBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mBinding = DataBindingUtil.inflate(inflater, R.layout.ui_activity_beranda_fragment_user, container, false)

        return mBinding.root
    }
}