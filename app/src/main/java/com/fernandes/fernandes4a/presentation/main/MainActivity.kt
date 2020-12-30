package com.fernandes.fernandes4a.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.fernandes.fernandes4a.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity() {

    //private lateinit var adapter : ViewAdapter

    val mainViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //adapter = ViewAdapter()
        //recycler_view.adapter = adapter

        mainViewModel.loginLiveData.observe(this, Observer{
            when (it) {
                is LoginSuccess -> {// TODO navigate
                }

                LoginError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Erreur")
                        .setMessage("Compte inconnu")
                        .setPositiveButton("Ok") { dialog, wich ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })
        login_input_layout.setOnClickListener {
          mainViewModel.onClickedLogin(login_input_layout./*text.*/toString().trim(), password_input_layout./*text.*/toString())
        }
    }

   /* class ViewAdapter : RecyclerView.Adapter<ViewAdapter.TextViewHolder>() {

            private val textviews = arrayListOf<String>()

        override fun onCreatViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
            return TextViewHolder((LayoutInflater.from(parent.context),parent)
        }

        override fun onBindViewHolder(holder: ViewAdapter.TextViewHolder, position: Int) {
            holder.bind(textviews[position])
        }

        override fun getIntemCount(): Int = textviews.size
        }
        class TextViewHolder(inflater: LayoutInflater,viewGroup: ViewGroup) :
            RecyclerView.ViewHolder(inflater.inflate(R.layout.view,viewGroup, false)
                fun bind(textview: String) {
                    itemView.view.text = textview
                }
    }*/
}
