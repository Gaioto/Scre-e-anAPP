package general.dev.screean

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        call.enqueue(object : Callback<List<Imagem>> {
            override fun onResponse(call: Call<List<Imagem>>, response: Response<List<Imagem>>) {
                if(response.code() == 500){

                }
                if(response.code() == 404){

                }
                if(response.code() == 200){

                    var items = response.body()!!

                    inicializarRecyclerView(items)
                }
            }
            override fun onFailure(call: Call<List<Imagem>>, t: Throwable) {
                var faill = t
            }
        })
    }

    fun inicializarRecyclerView(list: List<Imagem>){
        recyclerView = findViewById(R.id.recyclerView)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        val adapter = ScreeanAdapter()
        adapter.items = list

        recyclerView.adapter = adapter
    }
}