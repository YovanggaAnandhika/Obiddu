package dka.product.obiddu.Layout.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.models.SlideModel
import dka.product.obiddu.Layout.BlankFragmentExample
import dka.product.obiddu.Layout.page.sub.beranda.ChildAllProduct
import dka.product.obiddu.R
import dka.product.obiddu.databinding.UiActivityBerandaFragmentBerandaBinding
import dka.product.obiddu.Layout.page.sub.beranda.ChildPilihan
import dka.product.obiddu.Layout.page.sub.beranda.ChildPromoBanner
import dka.product.obiddu.src.entity.AllProductGridEntity
import dka.product.obiddu.src.models.adapter.recycleview.*

class BerandaFragment : Fragment() {


    private var mAdapterPilihan : MutableList<mModelFragmentPilihan> = mutableListOf()
    private var mAdapterPromo : MutableList<mModelBannerPromo> = mutableListOf()
    private var mAdapterAllProduct : MutableList<mModelFragmentAllProduct> = mutableListOf()

    private var imageSlider : MutableList<SlideModel> = mutableListOf()

    private var mData : MutableList<menuFitur.mIcon> = mutableListOf()
    private var mData1 : MutableList<recycleterlaris.mIcon> = mutableListOf()
    private var mData2 : MutableList<recycleviewrekomendasi.mModel> = mutableListOf()
    private var mDataFlashSale : MutableList<FlashSale.FlashSaleEntity> = mutableListOf()

    private lateinit var adapter: menuFitur
    private lateinit var adapter1 : recycleterlaris
    private lateinit var adapter2 : recycleviewrekomendasi
    private lateinit var mFlashSaleAdapter : FlashSale
    private lateinit var mAllProductAdapter : AllProductGrid

    private lateinit var mBinding : UiActivityBerandaFragmentBerandaBinding


    data class mModelBannerPromo(
        var mFragment : Fragment
    )

    data class mModelFragmentPilihan(
        var mFragment : Fragment
    )

    data class mModelFragmentAllProduct(
        var mTitle : String,
        var mFragment : Fragment
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter1 = recycleterlaris(requireActivity())
        adapter2 = recycleviewrekomendasi(requireActivity())
        adapter = menuFitur(requireActivity())
        mFlashSaleAdapter = FlashSale(requireActivity())
        mAllProductAdapter = AllProductGrid(requireActivity())

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        mBinding = DataBindingUtil.inflate(inflater, R.layout.ui_activity_beranda_fragment_beranda, container, false)

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
        INI UNTUK FRAGMEN REKOMENDASI (SLIDE)
        imageSlider.clear()
        imageSlider.add(SlideModel( imageUrl = "https://asset.kompas.com/crops/j6rqgg3kxqfvG3AdGNVv1fTKR80=/0x0:0x0/750x500/data/photo/2013/07/17/1039478whatsapp-logo780x390.jpg", ScaleTypes.FIT))
        imageSlider.add(SlideModel( imageUrl = "https://dailyspin.id/wp-content/uploads/2020/09/Logo-Mobile-Legends-1.jpg", ScaleTypes.FIT))
        imageSlider.add(SlideModel( imageUrl = "https://ichapucino.files.wordpress.com/2017/06/151015_webtoon_11.jpg?w=620", ScaleTypes.FIT))
        imageSlider.add(SlideModel( imageUrl = "https://www.smartfren.com/Article/July%202019/Aplikasi%20Belajar%20Online%20Untuk%20Pelajar/image-thumb__625__auto_1f891bd5eb142807016c2634ecc9a380/aplikasi-belajar-online-opt-2.webp", ScaleTypes.FIT))

        mBinding.imageSlide.setImageList(imageSlider)*/

        //######################################################################################

        mBinding.apply {

            mAdapterAllProduct.apply {
                add(mModelFragmentAllProduct("Semua", ChildAllProduct()))
                add(mModelFragmentAllProduct("Rumah Tangga", ChildAllProduct()))
                add(mModelFragmentAllProduct("Elektronik", ChildAllProduct()))
                add(mModelFragmentAllProduct("Fashion", ChildAllProduct()))
                add(mModelFragmentAllProduct("Peralatan Dapur", ChildAllProduct()))
                add(mModelFragmentAllProduct("Hobbi", ChildAllProduct()))
                add(mModelFragmentAllProduct("Aksesoris Smartphone", ChildAllProduct()))
                add(mModelFragmentAllProduct("Pulsa", ChildAllProduct()))
                add(mModelFragmentAllProduct("Tiket", ChildAllProduct()))
                add(mModelFragmentAllProduct("Promo", ChildAllProduct()))


            }
            mAllProductViewPager.apply {
                adapter = mAllProduct(childFragmentManager)
            }
            mAllProductTabLayout.apply {

                setupWithViewPager(mBinding.mAllProductViewPager)
            }
        }

        //######################################################################################

        mBinding.mRecyclerViewFlashSale.apply {
            layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            adapter = mFlashSaleAdapter
            //
            mDataFlashSale.apply {
                clear()
                add(FlashSale.FlashSaleEntity(4, "https://ecs7.tokopedia.net/img/cache/700/product-1/2019/3/20/52616645/52616645_5b8f0f1f-5290-4587-a318-57b615ad7c04_700_700.png", 80, "120.000", "220 Terjual"))
                add(FlashSale.FlashSaleEntity(2, "https://promoproduk.id/wp-content/uploads/2020/08/7596-00001.jpg", 80, "120.000", "220 Terjual"))
                add(FlashSale.FlashSaleEntity(1, "https://cdn.shopify.com/s/files/1/0070/7032/files/camera_56f176e3-ad83-4ff8-82d8-d53d71b6e0fe.jpg?v=1527089512", 50, "50.000", "5 Terjual"))
            }

            mFlashSaleAdapter.dataBaru(mDataFlashSale)


        }



        //######################################################################################

        mBinding.mCountDownTimer.start(3600000)

        //######################################################################################
        mAdapterPilihan.clear()
        mAdapterPilihan.add(mModelFragmentPilihan(ChildPilihan("Hanya Untukmu")))
        mAdapterPilihan.add(mModelFragmentPilihan(ChildPilihan("Berdasarkan Lokasi")))
        mAdapterPilihan.add(mModelFragmentPilihan(ChildPilihan("Hobbi Anda")))

        mBinding.mPilihanGroup.apply {
            adapter = mPilihanGroup(childFragmentManager)
        }
        //######################################################################################

        //######################################################################################
        mAdapterPromo.apply {
            clear()
            add(mModelBannerPromo(ChildPromoBanner(requireActivity(), "https://image.freepik.com/free-vector/new-year-red-discount-banner-with-large-numbers-2019-gifts-antique-street-lamp_7993-1057.jpg")))
            add(mModelBannerPromo(ChildPromoBanner(requireActivity(), "https://image.freepik.com/free-vector/new-year-red-discount-banner-with-large-numbers-2019-gifts-antique-street-lamp_7993-1057.jpg")))
        }

        mBinding.mPromoBanner.apply {
            adapter = mPromoBannerAdapter(childFragmentManager)
        }
        //######################################################################################

        //######################################################################################
        mBinding.mRecycleViewBerandaKategori.let {
            it.layoutManager = GridLayoutManager(requireActivity(), 5)
            it.adapter = adapter

            mData.apply {
                clear()
                add(menuFitur.mIcon(R.drawable.gift, "Hadiah Cash"))
                add(menuFitur.mIcon(R.drawable.loss, "Murah Lebay"))
                add(menuFitur.mIcon(R.drawable.handphones, "Pulsa, Tagihan & Hiburan"))
                add(menuFitur.mIcon(R.drawable.location_pin, "Mall"))
                add(menuFitur.mIcon(R.drawable.delivery, "Gratis Ongkir Extra"))
                add(menuFitur.mIcon(R.drawable.cashback, "Cashback & Voucher"))
                add(menuFitur.mIcon(R.drawable.hot_sale, "Hot Sale"))
                add(menuFitur.mIcon(R.drawable.order_food, "Transaksi Makanan"))
                add(menuFitur.mIcon(R.drawable.electronics, "Elektronik"))
                add(menuFitur.mIcon(R.drawable.deal, "deals"))
            }
            adapter.dataBaru(mData)
        }


        mBinding.mrecycleviewterlaris.let {
            it.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            it.adapter = adapter1

            mData1.apply {
                clear()
                add(recycleterlaris.mIcon(R.drawable.holderplace, "Nama Item1", "Nama Toko 1"))
                add(recycleterlaris.mIcon(R.drawable.holderplace, "Nama Item2", "Nama Toko 2"))
                add(recycleterlaris.mIcon(R.drawable.holderplace, "Nama Item3", "Nama Toko 3"))
                add(recycleterlaris.mIcon(R.drawable.holderplace, "Nama Item4", "Nama Toko 4"))
                add(recycleterlaris.mIcon(R.drawable.holderplace, "Nama Item5", "Nama Toko 5"))
            }

            adapter1.dataBaru(mData1)
        }

    }


    @Suppress("DEPRECATION")
    private inner class mPromoBannerAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm) {
        override fun getCount(): Int = mAdapterPromo.size

        override fun getItem(position: Int): Fragment {
            return mAdapterPromo[position].mFragment
        }

    }

    @Suppress("DEPRECATION")
    private inner class mPilihanGroup(fm : FragmentManager) : FragmentStatePagerAdapter(fm) {
        override fun getCount(): Int = mAdapterPilihan.size

        override fun getItem(position: Int): Fragment {
            return mAdapterPilihan[position].mFragment
        }

    }

    private inner class mAllProduct(fm : FragmentManager) : FragmentStatePagerAdapter(fm) {
        override fun getCount(): Int = mAdapterAllProduct.size

        override fun getItem(position: Int): Fragment {
            return mAdapterAllProduct[position].mFragment
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mAdapterAllProduct[position].mTitle
        }
    }
}