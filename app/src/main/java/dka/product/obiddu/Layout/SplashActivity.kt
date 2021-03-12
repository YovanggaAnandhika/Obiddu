package dka.product.obiddu.Layout

import android.R.attr.logo
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dka.product.obiddu.R
import dka.product.obiddu.databinding.UiActivitySplashScreenBinding


class SplashActivity : AppCompatActivity() {

    private lateinit var i : Intent
    private lateinit var mBinding : UiActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.ui_activity_splash_screen)


        Handler().postDelayed({
            i = Intent(this, BerandaActivity::class.java)
            startActivity(i)
            finish()
        }, 5000)

        val myanim: Animation = AnimationUtils.loadAnimation(this, R.anim.splashscreen_transition)
        mBinding.mContainer.startAnimation(myanim)
    }
}