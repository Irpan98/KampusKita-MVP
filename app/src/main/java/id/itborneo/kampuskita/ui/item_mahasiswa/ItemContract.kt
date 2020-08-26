package id.itborneo.kampuskita.ui.item_mahasiswa

import androidx.lifecycle.LiveData
import id.itborneo.kampuskita.data.model.Mahasiswa
import id.itborneo.kampuskita.data.response.MahasiswaReponse
import id.itborneo.kampuskita.data.response.PostResponse

interface ItemContract {

    interface View {
        fun addedMahasiswa(postResponse: PostResponse)
        fun updatedMahasiswa(postResponse: PostResponse)

    }


    interface presenter {
        fun addMahasiswa(mahasiswa: Mahasiswa)
        fun updateMahasiswa(mahasiswa: Mahasiswa)

    }


}