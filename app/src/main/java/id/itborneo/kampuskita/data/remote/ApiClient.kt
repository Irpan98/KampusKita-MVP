package id.itborneo.kampuskita.data.remote


import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

//    const val API_BASE = "http://192.168.43.46/mentoringkotlin/"
    const val API_BASE = "http://192.168.43.46/mentoringkotlin/"

    fun create(): ApiServices {
        val retrofit = Retrofit.Builder()
            .baseUrl(API_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
        return retrofit.create(ApiServices::class.java)
    }

    private fun okHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .build()
    }


}