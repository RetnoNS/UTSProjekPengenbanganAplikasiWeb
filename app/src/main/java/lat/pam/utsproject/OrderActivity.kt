package lat.pam.utsproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    //baru ditambah
    private lateinit var servingsEditText: EditText
    private lateinit var nameEditText: EditText
    private lateinit var notesEditText: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        val buttonPlaceOrder = findViewById<Button>(R.id.btnOrder)
        val foodNameTextView = findViewById<TextView>(R.id.foodNameTextView)
        val foodPriceTextView = findViewById<TextView>(R.id.foodPriceTextView)
        val foodName = intent.getStringExtra("foodName")
        val foodPrice = intent.getStringExtra("foodPrice")


        foodNameTextView.text = foodName
        foodPriceTextView.text = foodPrice

        servingsEditText = findViewById(R.id.etServings)
        nameEditText = findViewById(R.id.etName)
        notesEditText = findViewById(R.id.etNotes)

        buttonPlaceOrder.setOnClickListener(View.OnClickListener{
            val servings = servingsEditText.text.toString()
            val orderingName = nameEditText.text.toString()
            val additionalNotes = notesEditText.text.toString()

            // Mengirim data ke ConfirmationActivity
            val intent = Intent(this, ConfirmationActivity::class.java).apply {
                putExtra("foodName", foodName)
                putExtra("foodPrice", foodPrice)
                putExtra("servings", servings)
                putExtra("orderingName", orderingName)
                putExtra("additionalNotes", additionalNotes)
            }
            startActivity(intent)
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}