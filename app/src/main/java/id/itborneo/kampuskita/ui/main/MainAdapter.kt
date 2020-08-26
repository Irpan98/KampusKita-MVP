package id.itborneo.kampuskita.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.itborneo.kampuskita.R
import id.itborneo.kampuskita.data.model.Mahasiswa

import kotlinx.android.synthetic.main.item_mahasiswa.view.*


class MainAdapter(val clickListener: (Mahasiswa) -> Unit, val deleteListener: (Mahasiswa) -> Unit) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var allMahasiswa = listOf<Mahasiswa>()
    fun setMahasiswa(allNews: List<Mahasiswa>) {
        this.allMahasiswa = allNews
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_mahasiswa, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = allMahasiswa.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(allMahasiswa[position])
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(mahasiswa: Mahasiswa) {

            itemView.apply {
                tvAddress.text = mahasiswa.address
                tvContact.text = "+62 "+mahasiswa.contact
                tvName.text = mahasiswa.name
//                Glide.with(context)
//                    .load(mahasiswa.urlImage)
//                    .apply(RequestOptions().dontTransform().placeholder(R.drawable.loading_image))
//                    .into(ivNews)

                setOnClickListener {
                    clickListener(mahasiswa)
                }
//                btnDelete.setOnClickListener {
//                    deleteListener(mahasiswa)
//                }
            }


        }


    }




}