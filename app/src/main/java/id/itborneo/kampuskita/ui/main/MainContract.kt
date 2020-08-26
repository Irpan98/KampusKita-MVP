package id.itborneo.kampuskita.ui.main

import id.itborneo.kampuskita.data.model.Mahasiswa
import id.itborneo.kampuskita.data.response.PostResponse

interface MainContract {

    interface View {
        fun getMahasiswa(allMahasiswa: List<Mahasiswa>)
        fun getDeleted(deletedMahasiswa: PostResponse)

    }


    interface presenter {
        fun getMahasiswa()
        fun deleteMahasiswa(id: Int)
    }


}