package com.example.android2020.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.android2020.DataBaseHandler
import com.example.android2020.ExampleItem
import com.example.android2020.R


class ProfileFragment : Fragment() {
    private val exampleList = profileInfo(3)
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_profile, container, false)
        //editText = root.findViewById(R.id.text_view_2)
        button = root.findViewById(R.id.btn_update)

        val db = context?.let { DataBaseHandler(context = it) }

        val data = db?.readData()

        val tv11 = root.findViewById<TextView>(R.id.text_view_2)
        val tv13 = root.findViewById<TextView>(R.id.text_view_22)
        val tv15 = root.findViewById<TextView>(R.id.text_view_222)

            if (data != null)
            {
                for (i in 0..(data.size -1)) {
                    tv11.text = " "+ data.get(i).name + " "
                    tv13.text = " 0"+ data.get(i).age + " "
                    tv15.text = " "+ data.get(i).email + " "


                }

            }

        button.setOnClickListener{
            //Toast.makeText(requireContext(),"Restart app to see changes", Toast.LENGTH_SHORT).show()
            reload()
        }

        return root
    }

    fun reload(){
        //reload fragment
        val ft: FragmentTransaction = fragmentManager!!.beginTransaction()
        if (Build.VERSION.SDK_INT >= 26) {
            ft.setReorderingAllowed(false)
        }
        ft.detach(this).attach(this).commit()
    }

    private fun profileInfo(size: Int): ArrayList<ExampleItem>{
        val list = ArrayList<ExampleItem>()
        val item1 = ExampleItem(R.drawable.ic_android, "E-mail: ", "djrevo@gmail.com")
        val item2 = ExampleItem(R.drawable.ic_android, "Phone: ", "074987456")
        val item3 = ExampleItem(R.drawable.ic_android, "Birth date: ", "1965. Nov. 23.")
        list += item1
        list += item2
        list += item3
        return list
    }
}

/*

val btnUpdate = v.findViewById<Button>(R.id.btn_update_frag)
val btnChange = v.findViewById<Button>(R.id.btn_change)

val imageV = v.findViewById<ImageView>(R.id.img_view_profile)

val tv11 = v.findViewById<TextView>(R.id.tv1)
val tv12 = v.findViewById<TextView>(R.id.tv2)
val tv13 = v.findViewById<TextView>(R.id.tv3)
val tv14 = v.findViewById<TextView>(R.id.tv4)
val tv15 = v.findViewById<TextView>(R.id.tv5)


val db = context?.let { DataBaseHandler(context = it) }

val data = db?.readData()


if (data != null)
{
    for (i in 0..(data.size -1)) {
        tv11.text = "Name: "+ data.get(i).name
        tv12.text = "Age: "+ data.get(i).age
        tv13.text = "Number: "+ data.get(i).email
        tv14.text = "Address: "+ data.get(i).telephone
        tv15.text = "E-mail: "+ data.get(i).location

        val img = Uri.parse(data.get(i).image)
        imageV!!.setImageURI(img)
    }

}*/

