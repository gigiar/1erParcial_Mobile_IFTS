package ar.edu.candlelight

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var costo: EditText
    private lateinit var km: EditText
    private lateinit var calcular: Button
    private lateinit var total: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        costo = findViewById(R.id.etCosto)
        km = findViewById(R.id.etKm)
        calcular = findViewById(R.id.btnCalcular)
        total = findViewById(R.id.tvTotal)

        calcular.setOnClickListener {

            var costoStr = costo.text.toString()
            var kmStr = km.text.toString()

            if (costoStr.isEmpty() || kmStr.isEmpty()) {

                total.text = "Por favor, rellene todos los campos solicitados"

            } else {

                var costoNum = costoStr.toInt()
                var kmNum = kmStr.toInt()

                if (costoNum >= 60000 && kmNum <= 200) {
                    total.text = "El envío es gratis!"
                } else if (kmNum > 200) {
                    total.text = "Lo sentimos, no hacemos envíos a más de 200km."
                } else if (costoNum < 60000 && kmNum <= 100) {
                    total.text = "Costo del envio: $3000\n¿Confirma su pedido?"
                } else if (costoNum < 60000 && kmNum > 100) {
                    total.text = "Costo del envio: $6000\n¿Confirma su pedido?"
                }

            }
        }

    }
}