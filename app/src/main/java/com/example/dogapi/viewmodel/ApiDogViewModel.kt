package com.example.dogapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dogapi.model.ApiClient
import com.example.dogapi.model.DogResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class ApiDogViewModel : ViewModel () {



    val apiDogModel = MutableLiveData<DogResponse>()




    fun obtenerImagenes (inputTexto: String)  {

        val busqueda = inputTexto.plus("/images")

        val client = ApiClient.apiService.lanzarCall(busqueda)  // LANZA LA LLAMADA CON EL INPUT DEL SEARCHVIEW

        CoroutineScope(Dispatchers.IO).launch {

            client.enqueue(object : retrofit2.Callback<DogResponse> {

                override fun onResponse(
                    call: Call<DogResponse>,
                    response: Response<DogResponse>
                )

                {
                    if (response.isSuccessful) {

                        val resultados = response.body()?.message

                        resultados?.let {



                            apiDogModel.postValue(DogResponse(resultados))   // ACTUALIZA LA LISTA CON LOS NUEVOS RESULTADOS

                        }

                    }

                }

                override fun onFailure(call: Call<DogResponse>, t: Throwable) {




                }

            })

        }

    }



}
