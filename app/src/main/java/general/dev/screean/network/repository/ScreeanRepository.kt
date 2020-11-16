package general.dev.screean.network.repository

import android.widget.Toast
import general.dev.screean.MainActivity
import general.dev.screean.R
import general.dev.screean.model.Imagem
import general.dev.screean.network.ScreeanRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface ScreeanRepository {

    //TRAZ UMA LISTA DE IMAGENS
    fun buscarImagens() {
        val call = ScreeanRetrofit().imagemService().buscaImagens()

        call.enqueue(object : Callback<List<Imagem>> {
            override fun onResponse(call: Call<List<Imagem>>, response: Response<List<Imagem>>) {
                if(response.code() == 500){
                    Toast.makeText(MainActivity , R.string.msgErro500, Toast.LENGTH_SHORT).show()
                }
                if(response.code() == 404){
                    Toast.makeText(context , R.string.msgErro404, Toast.LENGTH_SHORT).show()
                }
                if(response.code() == 200){
                    Toast.makeText(context , R.string.msgRet200, Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<List<Imagem>>, t: Throwable) {
                Toast.makeText(context , R.string.msgErro404, Toast.LENGTH_SHORT).show()
            }
        })
    }

    //CADASTRA UMA IMAGEM
    fun cadastraImagem(imagem: Imagem) {
        val call = ScreeanRetrofit().imagemService().cadastraImagem(imagem)

        call.enqueue(object : Callback<Imagem> {
            override fun onResponse(call: Call<Imagem>, response: Response<Imagem>) {
                if(response.code() == 500){
                    Toast.makeText(MainActivity , R.string.msgErro500, Toast.LENGTH_SHORT).show()
                }
                if(response.code() == 404){
                    Toast.makeText(context , R.string.msgErro404, Toast.LENGTH_SHORT).show()
                }
                if(response.code() == 200){
                    Toast.makeText(context , R.string.msgCadas200, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Imagem>, t: Throwable) {
                Toast.makeText(context , R.string.msgErro404, Toast.LENGTH_SHORT).show()
            }

        })
    }

}