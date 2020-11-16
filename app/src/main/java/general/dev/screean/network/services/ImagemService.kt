package general.dev.screean.network.services

import general.dev.screean.model.Imagem
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*


interface ImagemService {

    @GET("GetImagens")
    fun buscaImagens() : Call<List<Imagem>>

    @GET("GetImagem/{id}")
    fun buscaImagem(@Path("id") id: Int) : Call<Imagem>

    @POST("Imagens/PostImagem")
    fun cadastraImagem(@Body imagem: Imagem) : Call<Imagem>

    @DELETE("DeleteImagem/{id}")
    fun deletarImagem(@Path("id") id: Int): Call<ResponseBody>
}