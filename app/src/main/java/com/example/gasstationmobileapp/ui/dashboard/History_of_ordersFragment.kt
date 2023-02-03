package com.example.gasstationmobileapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gasstationmobileapp.databinding.FragmentHistoryOfOrdersBinding
//import com.example.gasstationmobileapp.ui.dashboard.CustomRecyclerHistoryOfOrdersAdapter

class History_of_ordersFragment : Fragment() {

    private var _binding: FragmentHistoryOfOrdersBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val historyofordersViewModel =
            ViewModelProvider(this).get(History_of_ordersViewModel::class.java)

        _binding = FragmentHistoryOfOrdersBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        historyofordersViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        val recyclerViewOffers: RecyclerView = binding.recyclerviewOffers
        recyclerViewOffers.layoutManager = LinearLayoutManager(this.context)
        recyclerViewOffers.adapter = CustomRecyclerHistoryOfOrdersAdapter(listOf("г. Владивосток, Юмашева 25",
            "г. Владивосток, Юмашева 25", "г. Владивосток, Светланская 55", "г. Владивосток, Школьная 32"),
            listOf("500р", "1500р", "350р", "1000p"),
            listOf("10л", "30л", "7л", "20л"),
            listOf("03.02.2023", "01.02.2023", "30.01.2023", "27.01.2023"))

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}