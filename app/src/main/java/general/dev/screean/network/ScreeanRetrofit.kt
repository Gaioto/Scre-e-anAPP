package general.dev.screean.network

import general.dev.screean.network.services.ImagemService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ScreeanRetrofit {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://screeanapi.herokuapp.com/api/Imagens/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun imagemService(): ImagemService = retrofit.create(ImagemService::class.java)
}