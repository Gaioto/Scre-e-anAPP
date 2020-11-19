package general.dev.screean

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import general.dev.screean.model.Imagem
import general.dev.screean.network.ScreeanRetrofit
import general.dev.screean.utils.base64ToBitmap
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_imagem)

        val intent = intent
        val iId = intent.getIntExtra("iId", 0)

        val imagem: ImageView = findViewById(R.id.image_exib)
        val text: TextView = findViewById(R.id.imageText)
        val back: ImageView = findViewById(R.id.backToList)
        val cast: ImageView = findViewById(R.id.cast)

        cast.setOnClickListener(){
            Toast.makeText(this, "Funcionalidade ainda não implementada", Toast.LENGTH_LONG).show()
        }

        back.setOnClickListener(){
            val listIntent = Intent(this, MainActivity::class.java)
            startActivity(listIntent)
        }

        val call = ScreeanRetrofit().imagemService().buscaImagem(iId)

        call.enqueue(object : Callback<Imagem>{
            override fun onResponse(call: Call<Imagem>, response: Response<Imagem>) {
                var image = response.body()?.imagem

                var nome = response.body()?.nome

                imagem.setImageBitmap(base64ToBitmap(image))

                text.setText(nome)

            }

            override fun onFailure(call: Call<Imagem>, t: Throwable) {

            }

        })

    }

}