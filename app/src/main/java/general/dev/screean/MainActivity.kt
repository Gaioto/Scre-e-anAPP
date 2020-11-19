package general.dev.screean

import android.Manifest
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import general.dev.screean.adapter.ScreeanAdapter
import general.dev.screean.model.Imagem
import general.dev.screean.network.ScreeanRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val call = ScreeanRetrofit().imagemService().buscaImagens()

        val add: ImageView = findViewById(R.id.add_image)
        val sobre: ImageView = findViewById(R.id.sobreNos)

        sobre.setOnClickListener(){

        }

        add.setOnClickListener(){
            val adicionaIntent = Intent(this, AdicionaActivity::class.java)
            startActivity(adicionaIntent)
        }

        call.enqueue(object : Callback<List<Imagem>> {
            override fun onResponse(call: Call<List<Imagem>>, response: Response<List<Imagem>>) {
                    var items = response.body()!!
                    inicializarRecyclerView(items)
            }
            override fun onFailure(call: Call<List<Imagem>>, t: Throwable) { }
        })
    }

    fun inicializarRecyclerView(list: List<Imagem>){
        recyclerView = findViewById(R.id.recyclerView)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        val adapter = ScreeanAdapter(this)
        adapter.items = list

        recyclerView.adapter = adapter
    }

}