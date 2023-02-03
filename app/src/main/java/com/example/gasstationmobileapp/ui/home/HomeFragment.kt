package com.example.gasstationmobileapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.gasstationmobileapp.R
import com.example.gasstationmobileapp.databinding.FragmentHomeBinding
import com.example.gasstationmobileapp.databinding.MakeOfferBinding
import com.example.gasstationmobileapp.ui.make_offer.MakeOfferFragment
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.MapObject
import com.yandex.mapkit.map.MapObjectTapListener
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider
import java.util.*


class HomeFragment : Fragment() {
    private val PERMISSIONS_REQUEST_FINE_LOCATION = 1

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var MapView: MapView? = null
    private lateinit var mapView:  MapView
    private lateinit var intent: Intent

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        MapKitFactory.initialize(this.context)
        mapView = binding.mapview as MapView
        mapView.getMap().move(
            CameraPosition(Point(43.116408, 131.903974), 11.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 1F),
            null
        )


        val petrol1 = mapView.map.mapObjects.addPlacemark(
            Point(43.106408, 131.943974),
            ImageProvider.fromResource(this.context, R.drawable.ic_petrol)
        )


        val petrol2 = mapView.map.mapObjects.addPlacemark(
            Point(43.116408, 131.903974),
            ImageProvider.fromResource(this.context, R.drawable.ic_petrol)
        )
        val petrol3 = mapView.map.mapObjects.addPlacemark(
            Point(43.146408, 131.953974),
            ImageProvider.fromResource(this.context, R.drawable.ic_petrol)
        )

        petrol1.userData = "1"
        petrol2.userData = "2"
        petrol3.userData = "3"
        val petrol_listner1 = petrol2.addTapListener(YandexMapObjectTapListener())
        petrol3.addTapListener(YandexMapObjectTapListener())
        petrol1.addTapListener(YandexMapObjectTapListener())
        create_make_offer_activity()
        return root
    }

    public class YandexMapObjectTapListener : MapObjectTapListener {
        override fun onMapObjectTap(mapObject: MapObject, point: Point): Boolean {
            Log.i("petrol", mapObject.userData.toString())

            return true
        }

    }

    public fun create_make_offer_activity(){
        intent = Intent(this.context, MakeOfferFragment::class.java)
        startActivity(intent)
    }

    override fun onStop() {
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        mapView.onStart()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}