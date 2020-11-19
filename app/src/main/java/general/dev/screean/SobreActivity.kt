package general.dev.screean

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SobreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val back: ImageView = findViewById(R.id.toolbarImageSobre)

        back.setOnClickListener(){
            val backIntent = Intent(this, MainActivity::class.java)
            startActivity(backIntent)
        }

    }
}