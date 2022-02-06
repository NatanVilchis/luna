package org.adrianitos.hackviolettest2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Button


class CodeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = inflater.inflate(R.layout.fragment_prices, container, false)!!
        val btnToallas = view.findViewById<Button>(R.id.btnToallas)
        val btnTampones = view.findViewById<Button>(R.id.btnTampones)
        val btnCopa = view.findViewById<Button>(R.id.btnCopa)
        val urlToallas = "https://consumidoras.profeco.gob.mx/precios_productos.php?cve_prod=2803"
        val urlTampones = "https://consumidoras.profeco.gob.mx/precios_productos.php?cve_prod=2807"
        val urlCopa = "https://consumidoras.profeco.gob.mx/precios_productos.php?cve_prod=2806"


        btnToallas.setOnClickListener{ openUrl(urlToallas) }
        btnTampones.setOnClickListener{ openUrl(urlTampones) }
        btnCopa.setOnClickListener{ openUrl(urlCopa) }


        return view
    }

    fun openUrl(url: String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }



}