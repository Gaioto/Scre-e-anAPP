package general.dev.screean

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SobreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sobre)

        val back: ImageView = findViewById(R.id.backToListAdd)

        back.setOnClickListener(){
            val backIntent = Intent(this, MainActivity::class.java)
            startActivity(backIntent)
            finish()
        }

    }
}