package dka.product.obiddu.Layout.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import dka.product.obiddu.databinding.UiActivityBerandaFragmentUserBinding


class SayaFragment : Fragment() {

    private lateinit var mBinding : UiActivityBerandaFragmentUserBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mBinding = UiActivityBerandaFragmentUserBinding.inflate(inflater)

        return mBinding.root
    }
}