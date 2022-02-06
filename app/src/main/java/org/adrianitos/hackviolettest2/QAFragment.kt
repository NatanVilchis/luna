package org.adrianitos.hackviolettest2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class QAFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_q_a, container, false)!!



        val recyclerview = view.findViewById<RecyclerView>(R.id.recycler_view)

         recyclerview.layoutManager = LinearLayoutManager(context)

         val data = ArrayList<ItemsQAViewModel>()


        data.add(ItemsQAViewModel(
            "¿Cuantas etapas tiene el ciclo menstrual?",
            ))
        data.add(ItemsQAViewModel(
            "¿Cuándo voy a tener la menstruación?",
            ))
        data.add(ItemsQAViewModel(
            "¿Por qué me duele la cabeza cuando voy iniciar el periodo?",
        ))

        data.add(ItemsQAViewModel(
            "¿Qué es la pubertad?",
        ))

        data.add(ItemsQAViewModel(
            "Ayuda, empecé a sangrar mucho, debo ir a un doctor?",
        ))
        data.add(ItemsQAViewModel(
            "¿Cuales son los primeros sintomas de los cambios hormonales que puede tener una niña que pasa a la pubertad?",
        ))

        data.add(ItemsQAViewModel(
            "¿Que es la menopausia?",
        ))









        val adapter =  QAAdapter(data)


        recyclerview.adapter = adapter


        return view
    }

}