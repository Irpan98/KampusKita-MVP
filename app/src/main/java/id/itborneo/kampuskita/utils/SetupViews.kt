package id.itborneo.kampuskita.utils

import android.content.Context
import android.content.DialogInterface
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


//fun setPoster(context: Context, poster: String?, image: ImageView) {
//    if (poster == null) return
//
//    val posterSize = "w185/"
//    val urlImage = "https://image.tmdb.org/t/p/$posterSize${poster}"
//
//    Glide.with(context)
//        .load(urlImage)
//        .apply(RequestOptions().override(100, 150))
//        .apply(RequestOptions().placeholder(R.drawable.ic_loading_image))
//
//        .into(image)
//
//}

fun setDialogNoInternet(context: Context, retry: () -> Unit) {
    val builder: AlertDialog.Builder = AlertDialog.Builder(context)
    builder.setCancelable(false)
    builder.setTitle("Tidak Ada Internet")
    builder.setMessage("Movie Catalogue Jetpack membutuhkan internet. Silahkan Aktifkan Koneksi Internet dan tekan Retry.")

    builder.setPositiveButton(
        "Retry"
    ) { dialog, _ ->
        dialog.dismiss()
        retry()
    }
    val dialog: AlertDialog = builder.create() // calling builder.create after adding buttons

    dialog.show()
    Toast.makeText(context, "Network Unavailable!", Toast.LENGTH_LONG).show()
}

fun setDialogComfirm(context: Context, delete: (() -> Unit), cancelDelete: (() -> Unit)) {
    val builder: AlertDialog.Builder = AlertDialog.Builder(context)
    builder.setCancelable(false)
    builder.setTitle("Apakah Anda Yakin")
    builder.setMessage("Item berikut akan dihapus.")



    builder.setNegativeButton(
        "DELETE"
    ) { dialog: DialogInterface, _: Int ->
        dialog.dismiss()
        delete()

    }
    builder.setPositiveButton(
        "Cancel"
    ) { dialog, _ ->
        dialog.dismiss()
        cancelDelete()
    }
    val dialog: AlertDialog = builder.create() // calling builder.create after adding buttons

    dialog.show()
}


fun checkInternet(context: Context, thisFuntion: () -> Unit): Boolean {
    return if (isInternetAvailable(context)) {

        true
    } else {
        noInternet(context) {

            thisFuntion()
        }
        false
    }
}

fun noInternet(context: Context, callback: () -> Unit) {
    setDialogNoInternet(context) { callback() }

}
