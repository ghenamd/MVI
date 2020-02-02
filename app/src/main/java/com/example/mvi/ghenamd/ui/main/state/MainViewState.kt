package com.example.mvi.ghenamd.ui.main.state

import com.example.mvi.ghenamd.model.BlogPost
import com.example.mvi.ghenamd.model.User

data class MainViewState(
    var blogPost: List<BlogPost>? = null,
    var user: User? = null

) {
}