package com.swancodes.androidplayground.data

import com.swancodes.androidplayground.R
import com.swancodes.androidplayground.model.Topic

class DataSource {
    fun viewTopics(): List<Topic> {
        return listOf(
            Topic(R.drawable.kotlin, "Introduction", R.string.introduction),
            Topic(R.drawable.android_studio, "Android Studio", R.string.android_studio),
            Topic(R.drawable.lifecycle, "Activity LifeCycle", R.string.activity_lifecycle),
            Topic(R.drawable.class_image, "Classes And Objects", R.string.classes_and_objects),
            Topic(R.drawable.databinding, "Data Binding", R.string.data_binding),
            Topic(R.drawable.functions, "Functions", R.string.kotlin_functions),
            Topic(R.drawable.fragment, "Fragments", R.string.fragment),
            Topic(R.drawable.intent, "Intents", R.string.intent),
            Topic(R.drawable.material2, "Material Design", R.string.material_design),
            Topic(R.drawable.navigation, "Navigation", R.string.navigation),
            Topic(R.drawable.kotlin_operators, "Operators", R.string.kotlin_operators),
            Topic(R.drawable.recycler_view2, "Recycler View", R.string.recycler_view),
            Topic(R.drawable.variable, "Variable", R.string.variable),
            Topic(R.drawable.view_binding, "View Binding", R.string.view_binding),
            Topic(R.drawable.viewmodel, "ViewModel", R.string.view_model),
            Topic(R.drawable.widget, "Widget", R.string.widget))
    }
}