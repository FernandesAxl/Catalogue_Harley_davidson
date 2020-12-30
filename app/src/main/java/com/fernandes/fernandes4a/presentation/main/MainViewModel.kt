package com.fernandes.fernandes4a.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fernandes.fernandes4a.domain.entity.User
import com.fernandes.fernandes4a.domain.usecase.CreateUserUseCase
import com.fernandes.fernandes4a.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class  MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {
    val loginLiveData: MutableLiveData<LoginStatus> = MutableLiveData()

    fun onClickedLogin(emailUser: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(emailUser)
            val loginStatus = if (user != null){
                LoginSuccess(user.email)
        } else {
            LoginError
            createUserUseCase.invoke(User("test"))
            val  user = getUserUseCase.invoke("test")
        }
            withContext(Dispatchers.Main) {
                //loginLiveData.value = loginStatus
            }
        }

    }
}
