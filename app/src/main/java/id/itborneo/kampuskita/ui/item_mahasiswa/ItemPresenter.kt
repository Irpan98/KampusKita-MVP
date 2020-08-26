package id.itborneo.kampuskita.ui.item_mahasiswa

import androidx.lifecycle.Observer
import id.itborneo.kampuskita.data.model.Mahasiswa
import id.itborneo.kampuskita.data.repository.Repository

class ItemPresenter(private val view: ItemContract.View, private val activity: ItemActivity) :
    ItemContract.presenter {


    override fun addMahasiswa(mahasiswa: Mahasiswa) {


        Repository.getMahasiswa()

        Repository.addMahasiswa(mahasiswa).observe(activity, Observer {

            view.addedMahasiswa(it)

        })


    }

    override fun updateMahasiswa(mahasiswa: Mahasiswa) {
        Repository.updateMahasiswa(mahasiswa).observe(activity, Observer {
            view.addedMahasiswa(it)

        })

    }
}