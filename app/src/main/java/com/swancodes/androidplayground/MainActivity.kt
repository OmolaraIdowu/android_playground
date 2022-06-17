package com.swancodes.androidplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.swancodes.androidplayground.databinding.ActivityMainBinding
import com.swancodes.androidplayground.fragments.FirstScreen
import com.swancodes.androidplayground.fragments.SecondScreen
import com.swancodes.androidplayground.fragments.ThirdScreen
import com.swancodes.androidplayground.util.navigate

private const val NUM_PAGES = 3

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            val pagerAdapter = ScreenSlidePagerAdapter(this@MainActivity,
                listOf(FirstScreen(), SecondScreen(), ThirdScreen()))
            pager.adapter = pagerAdapter
            pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {

                    if (position == 0) {
                        dotOne.setBackgroundResource(R.drawable.circle1)
                        dotTwo.setBackgroundResource(R.drawable.circle)
                        dotThree.setBackgroundResource(R.drawable.circle)
                        nextTextView.text = resources.getString(R.string.nextTxt)
                        nextTextView.isVisible = true
                        backTextView.isVisible = false
                        getStartedButton.isVisible = false
                    }

                    if (position == 1) {
                        dotOne.setBackgroundResource(R.drawable.circle)
                        dotTwo.setBackgroundResource(R.drawable.circle1)
                        dotThree.setBackgroundResource(R.drawable.circle)
                        nextTextView.text = resources.getString(R.string.nextTxt)
                        nextTextView.isVisible = true
                        backTextView.isVisible = true
                        getStartedButton.isVisible = false
                    }

                    if (position == 2) {
                        dotOne.setBackgroundResource(R.drawable.circle)
                        dotTwo.setBackgroundResource(R.drawable.circle)
                        dotThree.setBackgroundResource(R.drawable.circle1)
                        nextTextView.text = resources.getString(R.string.getStarted)
                        nextTextView.isVisible = false
                        backTextView.isVisible = true
                        getStartedButton.isVisible = true
                    }
                }
            })
            binding.nextTextView.setOnClickListener {
                if (pager.currentItem == 0 || pager.currentItem == 1) {
                    pager.currentItem++
                }
            }
            binding.backTextView.setOnClickListener {
                if (pager.currentItem == 0 || pager.currentItem == 1 || pager.currentItem == 2) {
                    pager.currentItem--
                }
            }
            binding.getStartedButton.setOnClickListener {
                navigate(MainActivity2::class.java)
            }
        }
    }

    private inner class ScreenSlidePagerAdapter(
        fa: FragmentActivity,
        private val screens: List<Fragment>,
    ) :
        FragmentStateAdapter(fa) {

        override fun getItemCount(): Int = NUM_PAGES

        override fun createFragment(position: Int): Fragment = screens[position]
    }

    override fun onBackPressed() {
        if (binding.pager.currentItem == 0) {
            super.onBackPressed()
        } else {
            binding.pager.currentItem = binding.pager.currentItem - 1
        }
    }
}
