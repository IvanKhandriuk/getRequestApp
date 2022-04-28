package com.examples.getrequestapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.examples.getrequestapp.Data.Repository.AuthorizationRepository
import com.examples.getrequestapp.Model.Authorization.AuthorizationItem

class MainViewModelFactory(
    private val authorizationRepository: AuthorizationRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(authorizationRepository) as T
    }
}