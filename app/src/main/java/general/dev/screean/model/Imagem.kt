package general.dev.screean.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Imagem {

    @SerializedName("idImagem")
    @Expose
    var id: Int? = null

    @SerializedName("nomeImagem")
    @Expose
    var nome: String? = null

    @SerializedName("arquivoImagem")
    @Expose
    var imagem: String? = null

    @SerializedName("exclusaoImagem")
    @Expose
    var excluida: Boolean? = null

    constructor(nome : String, imagem: String) {
        this.nome = nome
        this.imagem = imagem
    }
}