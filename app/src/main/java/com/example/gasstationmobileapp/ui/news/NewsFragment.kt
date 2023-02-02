package com.example.gasstationmobileapp.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.gasstationmobileapp.databinding.FragmentNewsBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gasstationmobileapp.ui.news.CustomRecyclerNewsAdapter

class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val newsViewModel =
            ViewModelProvider(this).get(NewsViewModel::class.java)

        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNews
        newsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val recyclerViewNews: RecyclerView = binding.recyclerviewNews
        recyclerViewNews.layoutManager = LinearLayoutManager(this.context)
        recyclerViewNews.adapter = CustomRecyclerNewsAdapter(fillList())

        return root
    }

    private fun fillList(): List<String> {
        val data = mutableListOf<String>()
        (0..30).forEach { i -> data.add("$i element") }
        return data
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}