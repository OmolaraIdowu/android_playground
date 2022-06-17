package com.swancodes.androidplayground.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.swancodes.androidplayground.databinding.FragmentTopicContentsBinding

class TopicContents : Fragment() {
    private var _binding: FragmentTopicContentsBinding? = null

    private val binding get() = _binding!!
    private val args by navArgs<TopicContentsArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentTopicContentsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val topic = args.topic
        binding.apply {
            topicTitle.text = topic.name
            topicImage.setImageResource(topic.imageResourceId)
            topicContents.text = getString(topic.details)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}