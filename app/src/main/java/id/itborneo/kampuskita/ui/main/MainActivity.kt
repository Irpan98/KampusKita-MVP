package id.itborneo.kampuskita.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.itborneo.kampuskita.R
import id.itborneo.kampuskita.data.model.Mahasiswa
import id.itborneo.kampuskita.data.response.PostResponse
import id.itborneo.kampuskita.ui.item_mahasiswa.ItemActivity
import id.itborneo.kampuskita.utils.SwipeToDeleteCallback
import id.itborneo.kampuskita.utils.isInternetAvailable
import id.itborneo.kampuskita.utils.setDialogComfirm
import id.itborneo.kampuskita.utils.setDialogNoInternet
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainContract.View {

    private val TAG = "MainActivity"

    private var listMahasiswa = mutableListOf<Mahasiswa>()

    private lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        setRecycler()


        addMahasiswa()

//        getMahasiswa()
        presenter = MainPresenter(this, this)


    }


    private fun addMahasiswa() {
        fab_add_mahasisw.setOnClickListener {
            moveActivty(null)
        }

    }

//    private fun setViewModel() {
//
//        viewModel = ViewModelProvider(
//            this,
//            ViewModelProvider.NewInstanceFactory()
//        )[MainViewModel::class.java]
//
//    }


    private lateinit var adapter: MainAdapter


    override fun onResume() {
        super.onResume()
        presenter.getMahasiswa()
    }

    private fun setRecycler() {
        adapter = MainAdapter({
            moveActivty(it)
        }, {
//            deleteMahasiswa(it.id!!.toInt())

        })

        rvMahasiswa.adapter = adapter
        rvMahasiswa.layoutManager = LinearLayoutManager(this)


        setupOnSwipe()


    }

    private fun setupOnSwipe() {
        val swipeHandler = object : SwipeToDeleteCallback(this) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                setDialogComfirm(this@MainActivity, {
                    Log.d(TAG, "setupOnSwipe + delete ${viewHolder.adapterPosition}")
                    //delete
                    val mahasiswa = listMahasiswa[viewHolder.adapterPosition]
                    mahasiswa.id?.toInt()?.let { presenter.deleteMahasiswa(it) }
//                    adapter.setMahasiswa(listMahasiswa)
//                    adapter.notifyDataSetChanged()

                }, {

                })
                //cancel delete
                adapter.notifyDataSetChanged()

            }
        }


        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(rvMahasiswa)
    }

    private fun moveActivty(mahasiswa: Mahasiswa?) {


        val intent = Intent(this, ItemActivity::class.java)

        intent.putExtra(ItemActivity.EXTRA_ITEM, mahasiswa)
        startActivity(intent)
    }

    override fun getMahasiswa(allMahasiswa: List<Mahasiswa>) {
        Log.d(TAG, "getMahasiswa is called")
        listMahasiswa = allMahasiswa.toMutableList()
        adapter.setMahasiswa(listMahasiswa)
        adapter.notifyDataSetChanged()

    }


    override fun getDeleted(deletedMahasiswa: PostResponse) {

        adapter.notifyDataSetChanged()

    }





}
//}