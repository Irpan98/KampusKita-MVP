package id.itborneo.kampuskita.ui.item_mahasiswa

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.itborneo.kampuskita.R
import id.itborneo.kampuskita.data.model.Mahasiswa
import id.itborneo.kampuskita.data.response.PostResponse
import kotlinx.android.synthetic.main.activity_item_mahasiwa.*

class ItemActivity : AppCompatActivity(), ItemContract.View {


    private lateinit var presenter: ItemPresenter

    companion object {
        const val EXTRA_ITEM = "mahasiswa"
    }

    private val TAG = "ItemActivity"
    private lateinit var mahasiswa: Mahasiswa
    private var getDataIntent: Mahasiswa? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_mahasiwa)


        presenter = ItemPresenter(this, this)


        val getData = intent.getParcelableExtra<Mahasiswa>(EXTRA_ITEM)

        if (getData != null) {
            getDataIntent = getData
            etAddress.setText(getData.address)
            etName.setText(getData.name)
            etContact.setText(getData.contact)
        } else {
            btn_add.text = "Tambahkan Mahasiswa"
        }


        execute(getDataIntent == null)


    }


    private fun execute(isNew: Boolean) {


        btn_add.setOnClickListener {
            mahasiswa = Mahasiswa(
                etAddress.text.toString(),
                etContact.text.toString(),
                etName.text.toString(),
                getDataIntent?.id
            )

            if (isNew) {
                presenter.addMahasiswa(mahasiswa)
            } else {
                presenter.updateMahasiswa(mahasiswa)
            }
            Log.d(TAG, mahasiswa.toString())
        }


    }

    override fun addedMahasiswa(postResponse: PostResponse) {
        onBackPressed()
        Toast.makeText(this, "Berhasil Menambahkan  ${mahasiswa.name}", Toast.LENGTH_LONG)
            .show()

    }

    override fun updatedMahasiswa(postResponse: PostResponse) {
        onBackPressed()
        Toast.makeText(this, "Berhasil Update  ${mahasiswa.name}", Toast.LENGTH_LONG).show()

    }


}
