package dka.product.obiddu.Layout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import dka.product.obiddu.R
import dka.product.obiddu.databinding.UiActivityBlankFragmentBinding

class BlankFragmentExample : Fragment() {


    private lateinit var mBinding : UiActivityBlankFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        mBinding = DataBindingUtil.inflate(inflater, R.layout.ui_activity_blank_fragment, container, false)

        return mBinding.root

    }
}