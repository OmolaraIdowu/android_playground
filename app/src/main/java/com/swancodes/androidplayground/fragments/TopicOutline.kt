package com.swancodes.androidplayground.fragments

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.swancodes.androidplayground.R
import com.swancodes.androidplayground.adapters.TopicOutlineAdapter
import com.swancodes.androidplayground.data.DataSource
import com.swancodes.androidplayground.databinding.FragmentTopicOutlineBinding

class TopicOutline : Fragment() {
    private var _binding: FragmentTopicOutlineBinding? = null
    private val binding get() = _binding!!

    private val myDataset = DataSource().viewTopics()

    private lateinit var recyclerView: RecyclerView

    private var isLinearLayoutManager = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentTopicOutlineBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView

        selectLayout()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.layout_menu, menu)

        val layoutButton = menu.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)
    }

    private fun selectLayout() {
        if (isLinearLayoutManager) {
            recyclerView.layoutManager = LinearLayoutManager(context)
        } else {
            recyclerView.layoutManager =
                GridLayoutManager( context, 2)
        }
        recyclerView.adapter = TopicOutlineAdapter(dataset = myDataset, onTopicItemClicked = {
            val directions = TopicOutlineDirections.toTopicContents(it)
            findNavController().navigate(directions)
        })
    }

    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return

        menuItem.icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_linear_layout)
            else ContextCompat.getDrawable(this.requireContext(),
                R.drawable.ic_grid_layout)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about -> {
                showAbout()
                true
            }
            R.id.action_switch_layout -> {
                isLinearLayoutManager = !isLinearLayoutManager
                selectLayout()
                setIcon(item)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun showAbout() {
        val directions = TopicOutlineDirections.toAbout()
        findNavController().navigate(directions)
    }
}