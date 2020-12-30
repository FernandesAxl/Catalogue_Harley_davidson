package com.example.catalogueharleydavidson.Model.Retrofit

import com.example.catalogueharleydavidson.Model.Interface.RetrofitService

object Common {

    private val BASE_URL = " https://raw.githubusercontent.com/Raffael93/Projetcatalogueharleydavidson/master/app/src/main/java/com/example/catalogueharleydavidson/"

    val retrofitService : RetrofitService
    get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)

}