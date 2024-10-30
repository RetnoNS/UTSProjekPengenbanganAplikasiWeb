package lat.pam.utsproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmationActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation)

        val foodName = intent.getStringExtra("foodName") ?: "N/A"
        val foodPrice = intent.getStringExtra("foodPrice") ?: "N/A"
        val servings = intent.getStringExtra("servings") ?: "N/A"
        val orderingName = intent.getStringExtra("orderingName") ?: "N/A"
        val additionalNotes = intent.getStringExtra("additionalNotes") ?: "N/A"

        findViewById<TextView>(R.id.tvTitle).text = "Order Food"
        findViewById<TextView>(R.id.foodNameTextView).text = "Food Name : $foodName"
        findViewById<TextView>(R.id.foodPriceTextView).text = "Price : $foodPrice"
        findViewById<TextView>(R.id.servingsTextView).text = "Number of Servings : $servings"
        findViewById<TextView>(R.id.orderingNameTextView).text = "Ordering Name : $orderingName"
        findViewById<TextView>(R.id.additionalNotesTextView).text = "Additional Notes : $additionalNotes"

        findViewById<Button>(R.id.backtoMenu).setOnClickListener {
            val intent = Intent(this, ListFoodActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}