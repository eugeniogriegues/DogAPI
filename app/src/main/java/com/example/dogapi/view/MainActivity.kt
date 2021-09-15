package com.example.dogapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.dogapi.R
import com.example.dogapi.databinding.ActivityMainBinding
import com.example.dogapi.viewmodel.ApiDogViewModel
import java.util.*

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    private val apiDogViewModel : ApiDogViewModel by viewModels ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)



        apiDogViewModel.apiDogModel.observe(this, androidx.lifecycle.Observer {


            iniciarRecycler(it.message)  // INICIA EL RECYCLERVIEW CON LOS RESULTADOS DE LA BUSQUEDA

        })




        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(inputTexto: String): Boolean {

                binding.searchView.clearFocus()

                apiDogViewModel.obtenerImagenes((inputTexto).lowercase(Locale.getDefault())) //  INICIA EL RECYCLER CON EL INPUT

                return false

            }

            override fun onQueryTextChange(inputTexto: String): Boolean {

                return false
            }

        })

    }

    private fun iniciarRecycler (lista : List<String>) {  //  METODO PARA INICIAR EL RECYCLERVIEW CON UNA LISTA DE ITEMS

        val adapter = MainAdapter(lista)

        val recyclerView = findViewById<RecyclerView>(R.id.rvListadoItems)

        recyclerView?.layoutManager =
            StaggeredGridLayoutManager(
                1,
                StaggeredGridLayoutManager.VERTICAL
            )

        recyclerView?.adapter = adapter

    }


}