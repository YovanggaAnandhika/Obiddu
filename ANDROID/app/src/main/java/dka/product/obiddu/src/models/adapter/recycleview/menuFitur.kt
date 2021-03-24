package dka.product.obiddu.src.models.adapter.recycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import dka.product.obiddu.R
import dka.product.obiddu.databinding.UiRecycleviewBerandaFragmentBerandaFiturBinding

class menuFitur(var context : Context) : RecyclerView.Adapter<menuFitur.myholder>() {

    private lateinit var mbinding : UiRecycleviewBerandaFragmentBerandaFiturBinding
    private  var mData : MutableList<mIcon> = mutableListOf()

    data class mIcon(
        var ikon : Int,
        var label : String
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): menuFitur.myholder {
        mbinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.ui_recycleview_beranda_fragment_beranda_fitur, parent,false)
        return myholder(mbinding)
    }

    override fun onBindViewHolder(holder: menuFitur.myholder, position: Int) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            holder.mbind.ikon1.setImageDrawable(context.resources.getDrawable(mData[position].ikon, context.theme))
        }
        holder.mbind.kategori1.setText(mData[position].label)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class myholder(bind : UiRecycleviewBerandaFragmentBerandaFiturBinding) : RecyclerView.ViewHolder(bind.root){
        val mbind = bind
    }

    fun dataBaru(mData : MutableList<mIcon> = mutableListOf()){
        this.mData = mData
        notifyDataSetChanged()
    }

}