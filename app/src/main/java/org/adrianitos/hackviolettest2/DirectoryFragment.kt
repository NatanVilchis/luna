package org.adrianitos.hackviolettest2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import java.nio.channels.AsynchronousFileChannel.open
import java.nio.channels.AsynchronousServerSocketChannel.open

class DirectoryFragment : Fragment() {
    val imagesONG = listOf(
        R.drawable.fondo_1,
        R.drawable.onu_2,
        R.drawable.psydeh_3,
        R.drawable.comunal_4,
        R.drawable.sintrata_5,
        R.drawable.cana_6,
        R.drawable.daya_7,
        R.drawable.musgo_8,
        R.drawable.cima_9,
        R.drawable.reinserta_10,
        R.drawable.vifac_11
    )
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View{

        val view: View = inflater.inflate(R.layout.fragment_directory, container, false)!!


        val recyclerview = view.findViewById<RecyclerView>(R.id.recycler_view)


        recyclerview.layoutManager = LinearLayoutManager(context)


        val data = ArrayList<ItemsDirectoryViewModel>()

        val jsonData = getJsonDataFromAsset("directorio.json")

        jsonData?.let {
            for (i in 0 until it.length()) {
                val entry = it.getJSONObject(i)
                val nameONG = entry.getString("nombre")
                val categoryONG = entry.getJSONArray("categoria")

                val directionONG = entry.getString("direccion")
                val directionURLONG = entry.getString("direccionURL")
                val phoneONG = entry.getJSONArray("telefono")
                val urlViewONG = entry.getString("url")
                val imageViewONG = imagesONG[i]

                data.add(ItemsDirectoryViewModel(
                    imageViewONG,
                    nameONG,
                    getMeStrFromArray(categoryONG),
                    directionONG,
                    directionURLONG,
                    getMeStrFromArray(phoneONG),
                    urlViewONG


                    ))


            }
        }

        val adapter = DirectoryAdapter(data)

        recyclerview.adapter = adapter





        return view
    }
    private fun getMeStrFromArray(array: JSONArray) :  String{
        var txt = ""
        for(i in 0 until array.length()){
            txt += array[i]
            txt += ", "

        }
        if (txt.length >= 2)
            txt = txt.substring(0,txt.length-2)
        if(txt == "")
            txt = "Sin datos"
        return txt
    }

    private fun getJsonDataFromAsset(fileName: String): JSONArray? {
        return try {
            val jsonString = context?.assets?.open(fileName)?.bufferedReader().use { it?.readText() }
            JSONArray(jsonString)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}