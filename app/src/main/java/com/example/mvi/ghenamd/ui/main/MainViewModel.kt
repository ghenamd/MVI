package com.example.mvi.ghenamd.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.mvi.ghenamd.ui.main.state.MainStateEvent
import com.example.mvi.ghenamd.ui.main.state.MainStateEvent.*
import com.example.mvi.ghenamd.ui.main.state.MainViewState
import com.example.mvi.ghenamd.util.AbsentLiveData

class MainViewModel : ViewModel() {

    private val _stateEvent: MutableLiveData<MainStateEvent> = MutableLiveData()
    private val _viewState: MutableLiveData<MainViewState> = MutableLiveData()

    val viewState: LiveData<MainViewState> get() = _viewState

    val dataState: LiveData<MainViewState> = Transformations
        .switchMap(_stateEvent) { stateEvent ->
            stateEvent?.let {
                handleStateEvent(stateEvent)
            }
        }

    fun handleStateEvent(stateEvent: MainStateEvent): LiveData<MainViewState> {
        when (stateEvent) {

            is GetBlogPostsEvent -> {
                return AbsentLiveData.create()
            }
            is GetUserEvent -> {
                return AbsentLiveData.create()
            }
            is EmptyState -> {
                return AbsentLiveData.create()
            }

        }
    }
}