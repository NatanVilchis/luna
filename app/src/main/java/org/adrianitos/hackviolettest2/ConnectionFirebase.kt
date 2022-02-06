package org.adrianitos.hackviolettest2

class ConnectionFirebase {

}

/*
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase

class ConnectionFirebase {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    val usuarios : List<String> = listOf("user1","user2","user3")
    val expertos : List<String> = listOf("user4", "user5", "user6")
    val respuestas : List<String> = listOf("answer1","answer2","answer3")
    val preguntasM: List<String> = listOf("1","2","3")
    val usuarioPr: List<String> = listOf("i", "j","k")

    fun generarComentario(usuario: String, question: String, answer: String): String{
        val database = FirebaseDatabase.getInstance()
        var myRef = database.getReference(question)
        val keyExpert : String = "expertAnswer"
        val keyanswers: String = "answers"
        val keyasw: String = "answer"
        if (usuario in expertos){
            myRef.child("/"+keyExpert)
            myRef.setValue(answer)
        }else {
            myRef = myRef.child("/"+keyanswers+"/"+usuario)
            val segundoB: Map <String, String> = mapOf(keyasw to answer)
            myRef.setValue(segundoB)
        }
        var uri=Uri.decode(myRef.toString())
        return uri.toString()
    }


    fun obtenerValor(url: String){
        val database = FirebaseDatabase.getInstance()
        val reflatitude = database.getReferenceFromUrl(url)
        val addValueEventListener = reflatitude.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                dataSnapshot.children.mapNotNull {
                    Log.d("lika", it.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("like", "Failed to read value.", error.toException())
            }
        })
        reflatitude.child("answers").addListenerForSingleValueEvent(addValueEventListener)


    }

    fun likeBot(url:String){
        val database = FirebaseDatabase.getInstance()
        val ref = database.getReferenceFromUrl(url)
        lateinit var respuestas: MutableMap<String,Any>
        lateinit var valores: MutableMap<String,String>
        val keyanswers: String = "answers"
        val keyasw: String = "answer"
        val own: String = "ownerQuestion"
        for(p in preguntasM){
            var owner = obtenerValor(url+"/"+p)
        }
    }

    fun isExpert(username: String, url:String = "experto"): Boolean{
        val database = FirebaseDatabase.getInstance()
        val reflatitude = database.getReferenceFromUrl(url)
        val addValueEventListener = reflatitude.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                dataSnapshot.children.mapNotNull {listOf(it.value)}
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("like", "Failed to read value.", error.toException())
            }
        })

        return false
    }

    fun newExpertAnswer(pathQuestion: String, username: String, answer: String){
        val database = FirebaseDatabase.getInstance()
        var commentExp = database.getReferenceFromUrl(pathQuestion+"/"+username+"/answer")
        commentExp.setValue(answer)
    }

    fun newPublicAnswer(pathQuestion: String, username: String, answer: String){
        val database = FirebaseDatabase.getInstance()
        var commentPub = database.getReferenceFromUrl(pathQuestion+"/"+username+"/answer")
        commentPub.setValue(answer)
    }

    fun deleteAnswer(pathQuestion:String,username:String){
        val database = FirebaseDatabase.getInstance()
        var commentDel = database.getReferenceFromUrl(pathQuestion)
        commentDel.child("answers").child(username).removeValue()

    }

    fun likeAnswer(pathQuestion: String,user: String){
        val database = FirebaseDatabase.getInstance()
        var like = database.getReferenceFromUrl(pathQuestion+"/answers/"+user)
        val addValueEventListener = like.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                dataSnapshot.children.mapNotNull {listOf(it.value)}
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("like", "Failed to read value.", error.toException())
            }
        })

        var likeNow = like.child("like").addListenerForSingleValueEvent(addValueEventListener)
        like = database.getReferenceFromUrl(pathQuestion+"/answers/"+user+"/like")
        //like.setValue(likeNow+1)
    }


    fun dislikeAnswer(pathQuestion: String,user: String){
        val database = FirebaseDatabase.getInstance()
        var dislike = database.getReferenceFromUrl(pathQuestion+"/answers/"+user)
        val addValueEventListener = dislike.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                dataSnapshot.children.mapNotNull {listOf(it.value)}

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("like", "Failed to read value.", error.toException())
            }
        })

        var dislikeNow = dislike.child("dislike").addListenerForSingleValueEvent(addValueEventListener)
        dislike = database.getReferenceFromUrl(pathQuestion+"/answers/"+user+"/dislike")

    }

    fun newAnswer(pathQuestion: String, username: String, answer: String){
        if (isExpert(pathQuestion,username)){
            newExpertAnswer(pathQuestion,username,answer)
        }else{
            newPublicAnswer(pathQuestion,username,answer)
        }
    }


    fun dislikeBot(url:String, comment: String){
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReferenceFromUrl(url+"/dislikes")
        myRef.setValue(-1)
    }

    fun onClickLike(view: View){
        val pathQuestion = "URLFIREBASE/"

    }

    fun onClickDislike(view: View){
        val database = FirebaseDatabase.getInstance()
        var url = "URLFIREBASE/"
        val myRef = database.getReferenceFromUrl(url+"/dislikes")

    }


    fun onClickObtener(view: View){
        for (usuario in usuarios ) {
            for(pregunta in preguntasM) {
                for (respuesta in respuestas) {
                    Log.d("obtener", generarComentario(usuario, pregunta, respuesta))
                }
            }
        }
    }


    fun onClickGenerar(view: View){
        val database = FirebaseDatabase.getInstance()
        val keyUsr : String = "ownerQuestion"
        var myRef = database.getReference()
        for((usuario, pregunta) in usuarioPr zip preguntasM){
            myRef = myRef.database.getReference(pregunta+"/"+keyUsr)
            myRef.setValue(usuario)
        }
    }


}*/