package id.itborneo.kampuskita.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.itborneo.kampuskita.data.model.Mahasiswa
import id.itborneo.kampuskita.data.remote.ApiClient
import id.itborneo.kampuskita.data.response.PostResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers


object Repository : DataSource {

    private val TAG = "Repository"
    override fun getMahasiswa(): LiveData<List<Mahasiswa>> {
        Log.e(TAG, "getMahasiswa called")

        val mahasiswa = MutableLiveData<List<Mahasiswa>>()


        ApiClient.create().getMahasiswa().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->

                val getMahasiswa = mutableListOf<Mahasiswa>()
                if (response.message == "Data ditemukan") {

                    val mahasiswaReponse = response.data

                    mahasiswaReponse?.forEach {
                        it?.let {
                            getMahasiswa.add(it)
                        }
                    }
                    Log.d(TAG, getMahasiswa.toString())
                    mahasiswa.postValue(getMahasiswa)

                }
            }, { e ->

            })

        return mahasiswa

    }

    override fun addMahasiswa(mahasiswa: Mahasiswa): LiveData<PostResponse> {
        Log.e(TAG, "addMahasiswa called")


        val postResponse = MutableLiveData<PostResponse>()
        if (
            mahasiswa.name == null ||
            mahasiswa.contact == null ||
            mahasiswa.address == null
        ) return postResponse


        ApiClient.create()
            .addMahasiswa(mahasiswa.name, mahasiswa.contact.toLong(), mahasiswa.address)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                if (response != null) {
                    if (response.isSuccess == true) {
//

                        var getResponse: PostResponse = response

                        Log.d(TAG, getResponse.toString())
//
                        postResponse.postValue(getResponse)
                    } else {
                        Log.d(TAG, "response.body adalah null")
                    }
                }

            }, {
            })


        return postResponse
    }

    override fun updateMahasiswa(mahasiswa: Mahasiswa): LiveData<PostResponse> {
        Log.e(TAG, "updateMahasiswa called")


        val postResponse = MutableLiveData<PostResponse>()
        if (
            mahasiswa.id == null ||
            mahasiswa.name == null ||
            mahasiswa.contact == null ||
            mahasiswa.address == null
        ) return postResponse



        ApiClient.create().updateMahasiswsa(
            mahasiswa.id.toInt(),
            mahasiswa.name,
            mahasiswa.contact.toLong(),
            mahasiswa.address
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->

                val getResponse: PostResponse
                if (response.isSuccess == true) {

                    getResponse = response


                    Log.d(TAG, getResponse.toString())
                    postResponse.postValue(getResponse)


                } else {
                    Log.d(TAG, "response.body adalah null")
                }
            }, {

            })


        return postResponse
    }

    override fun deleteMahasiwa(id: Int): LiveData<PostResponse> {
        Log.e(TAG, "deleteMahasiwa called")


        val postResponse = MutableLiveData<PostResponse>()


        ApiClient.create().deleteMahasiswa(id).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                var getResponse = PostResponse()
                if (response.isSuccess == true) {

                    getResponse = response as PostResponse


                    Log.d(TAG, getResponse.toString())


                } else {
                    Log.d(TAG, "response.body adalah null")
                }
                postResponse.postValue(getResponse)
            }, {

            })

        return postResponse
    }


}