package general.dev.screean

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import general.dev.screean.model.Imagem
import general.dev.screean.network.ScreeanRetrofit
import general.dev.screean.utils.bitmapToBase64
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdicionaActivity: AppCompatActivity(){

    lateinit var imagemGalery: ImageView
    lateinit var imagemName: EditText
    var uri_image: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adiciona)

        val adicionaAoBanco: Button = findViewById(R.id.appCompatButton)
        val imagemAddGalery: ImageView = findViewById(R.id.addImagemIcon)
        val back: ImageView = findViewById(R.id.backToListAdd)
        imagemGalery = findViewById(R.id.appCompatImageView)
        imagemName = findViewById(R.id.imageName)

        back.setOnClickListener(){
            val backIntent = Intent(this, MainActivity::class.java)
            startActivity(backIntent)
            finish()
        }

        imagemAddGalery.setOnClickListener(){
            obterImagemGaleria()
        }

        adicionaAoBanco.setOnClickListener(){
            var nome = imagemName.text.toString()
            var imageBase = imagemGalery.drawable
            val imagem = Imagem(nome, bitmapToBase64(imageBase.toBitmap()))

            val call = ScreeanRetrofit().imagemService().cadastraImagem(imagem)
            call.enqueue(object : Callback<Imagem>{
                override fun onResponse(call: Call<Imagem>, response: Response<Imagem>) { }
                override fun onFailure(call: Call<Imagem>, t: Throwable) { }
            })

            val backIntent = Intent(this, MainActivity::class.java)
            startActivity(backIntent)
            finish()
        }
    }

    fun obterImagemGaleria(){

        val obterItent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)

        startActivityForResult(Intent.createChooser(obterItent, "Escolha uma imagem"), 11)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK){

            if(requestCode == 11 && data != null){
                    uri_image = data.data
                    imagemGalery.setImageURI(uri_image)
            }
        }
    }

}