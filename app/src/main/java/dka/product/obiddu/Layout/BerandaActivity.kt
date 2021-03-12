package dka.product.obiddu.Layout

import android.os.Bundle
import android.view.MenuItem
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import dka.product.obiddu.R
import dka.product.obiddu.databinding.UiActivityBerandaScreenBinding
import dka.product.obiddu.Layout.page.BerandaFragment
import dka.product.obiddu.Layout.page.KeranjangFragment
import dka.product.obiddu.Layout.page.SayaFragment

class BerandaActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var mBinding : UiActivityBerandaScreenBinding
    private lateinit var fm : FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.ui_activity_beranda_screen)

        val myanim: Animation = AnimationUtils.loadAnimation(this, R.anim.splashscreen_transition)
        mBinding.mContainer.startAnimation(myanim)

        mBinding.mBottomNavigation.setOnNavigationItemSelectedListener(this)

        // Ini Adalah inisiator Fragment Default
        fm = supportFragmentManager
        fm.apply {
            beginTransaction()
                .replace(mBinding.mContainerLayoutFunction.id, BerandaFragment())
                .commit()
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.mBeranda -> {
                fm.beginTransaction()
                    .replace(mBinding.mContainerLayoutFunction.id, BerandaFragment())
                    .commit()
                true
            }
            R.id.mkeranjang -> {
                fm.beginTransaction()
                    .replace(mBinding.mContainerLayoutFunction.id, KeranjangFragment())
                    .commit()
                true
            }
            R.id.mTokoResmi -> {
                fm.beginTransaction()
                    .replace(mBinding.mContainerLayoutFunction.id, BlankFragmentExample())
                    .commit()
                true
            }
            R.id.mSaya -> {
                fm.beginTransaction()
                    .replace(mBinding.mContainerLayoutFunction.id, SayaFragment())
                    .commit()
                true
            }
            else -> {
                false
            }
        }
    }

}
