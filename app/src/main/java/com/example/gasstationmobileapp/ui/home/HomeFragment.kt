package com.example.gasstationmobileapp.ui.home

import com.example.gasstationmobileapp.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.gasstationmobileapp.databinding.FragmentHomeBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider
import android.graphics.drawable.Drawable


class HomeFragment : Fragment() {
    private val PERMISSIONS_REQUEST_FINE_LOCATION = 1

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var MapView: MapView? = null
    private lateinit var mapView:  MapView

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

        return root
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