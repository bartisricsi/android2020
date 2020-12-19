package com.example.android2020.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.android2020.ExampleItem
import com.example.android2020.R


class ProfileFragment : Fragment() {
    private val exampleList = profileInfo(2)
    private lateinit var editText: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_profile, container, false)
        editText = root.findViewById(R.id.text_view_2)
        button = root.findViewById(R.id.emailbutton)
        button.setOnClickListener{
            Log.d("adatok","${editText.text.toString()}")
        }
        return root
    }

    private fun profileInfo(size: Int): ArrayList<ExampleItem>{
        val list = ArrayList<ExampleItem>()
        val item1 = ExampleItem(R.drawable.ic_android,"E-mail: ","djrevo@gmail.com")
        val item2 = ExampleItem(R.drawable.ic_android,"Phone: ","074987456")
        val item3 = ExampleItem(R.drawable.ic_android,"Birth date: ","1965. Nov. 23.")
        list += item1
        list += item2
        list += item3
        return list
    }
}



