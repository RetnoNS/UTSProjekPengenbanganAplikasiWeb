package lat.pam.utsproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFoodActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: List<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_food)


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Menyiapkan data makanan
        foodList = listOf(
            Food("Batagor", "Batagor asli enak dari Bandung", R.drawable.batagor),
            Food("Black Salad", "Salad segar yang dibuat secara langsung", R.drawable.black_salad),
            Food("Cappucino", "Kopi cappucino asli yang dibuat dari Kopi Arabica", R.drawable.cappuchino),
            Food("Cheesecake", "Lumer di Lidah, Bahagia di Hati!", R.drawable.cheesecake),
            Food("Cireng", "Cireng Gurih, Nikmatnya Nggak Kalah Nendang!", R.drawable.cireng),
            Food("Donut", "Donut Lembut, Manisnya Bikin Nagih!", R.drawable.donut),
            Food("Kopi Hitam", "Kopi Hitam, Pahitnya Bikin Melek!", R.drawable.kopi_hitam),
            Food("Mie Goreng", "Paduan Rasa yang Menggoda Selera!", R.drawable.mie_goreng),
            Food("Nasi Goreng", "Nasi Goreng, Cita Rasa Autentik yang Menghangatkan Jiwa!", R.drawable.nasigoreng),
            Food("Sparkling Tea", "Sparkling Tea, Kesegaran Berkilau dalam Setiap Tegukan!", R.drawable.sparkling_tea)
        )

        adapter = FoodAdapter(foodList)
        recyclerView.adapter = adapter


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}