package com.example.gasstationmobileapp.ui.make_offer
import android.app.Activity
import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.gasstationmobileapp.R
import com.example.gasstationmobileapp.databinding.ActivityMainBinding
import com.example.gasstationmobileapp.databinding.FragmentHomeBinding
import com.example.gasstationmobileapp.databinding.MakeOfferBinding
import com.example.gasstationmobileapp.ui.home.HomeFragment
import com.example.gasstationmobileapp.ui.home.HomeViewModel
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Circle
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.CircleMapObject
import com.yandex.mapkit.map.MapObject
import com.yandex.mapkit.map.MapObjectTapListener
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider
import java.util.*

public class MakeOfferFragment : Activity() {
    private lateinit var binding: MakeOfferBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MakeOfferBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textAddress.text = "Адрес: г. Владивосток, Светланская 55"
        val textViewCount: TextView = binding.editCountFuel
        textViewCount.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (binding.editCountFuel.text.isNotEmpty()){
                    val s = toInt(binding.editCountFuel.text.toString())
                    binding.textPrice.text = "К оплате: " + (50*s).toString()
                }
                else{
                    binding.textPrice.text = "К оплате: "
                }

            }
        })
        val button: Button = binding.button
        button.setOnClickListener{
            Log.i("lol", "lol")
        }
    }
    fun toInt(s: String): Int {
        return s.toInt()
    }
}