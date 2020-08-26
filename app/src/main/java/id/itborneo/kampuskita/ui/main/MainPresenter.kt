package id.itborneo.kampuskita.ui.main

import android.util.Log
import androidx.lifecycle.Observer
import id.itborneo.kampuskita.data.repository.Repository
import id.itborneo.kampuskita.utils.checkInternet

class MainPresenter(
    private val view: MainContract.View,
    private val activity: MainActivity

) : MainContract.presenter {
    private var TAG = "MainViewModel"

    init {
        getMahasiswa()
    }

    override fun getMahasiswa() {

        val isInternetAvailable = checkInternet(activity) {
            getMahasiswa()
        }

        if (isInternetAvailable) {
            Repository.getMahasiswa()
                .observe(activity, Observer {
                    Log.d(TAG, it.toString())
                    view.getMahasiswa(it)

                }
                )
        }
    }

    override fun deleteMahasiswa(id: Int) {


        Repository.deleteMahasiwa(id)
            .observe(activity, Observer {
                view.getDeleted(it)
                getMahasiswa()
            })
    }
}