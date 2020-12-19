package com.example.android2020.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.android2020.DataBaseHandler
import com.example.android2020.R
import com.example.android2020.User
import kotlinx.android.synthetic.main.fragment_edit_profile.*


class EditProfile : Fragment() {
    private lateinit var editText: EditText
    private lateinit var button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_edit_profile, container, false)
        editText = root.findViewById(R.id.etvName)
        editText = root.findViewById(R.id.etvAge)
        button = root.findViewById(R.id.btn_insert)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val context = requireContext()
        var db = DataBaseHandler(context)
        btn_insert.setOnClickListener {
            if (etvName.text.toString().isNotEmpty() &&
                etvAge.text.toString().isNotEmpty() &&
                etvEmail.text.toString().isNotEmpty()
            ) {
                var user = User(etvName.text.toString(), etvAge.text.toString().toInt(), etvEmail.text.toString())
                db.insertData(user)
            } else {
                Toast.makeText(context, "Please Fill All Data's", Toast.LENGTH_SHORT).show()
            }
        }
    }

}



