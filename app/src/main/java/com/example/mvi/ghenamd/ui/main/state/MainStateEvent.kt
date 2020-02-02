package com.example.mvi.ghenamd.ui.main.state

sealed class MainStateEvent {
    class GetBlogPostsEvent : MainStateEvent()
    class GetUserEvent(val userId: String) : MainStateEvent()
    class EmptyState:MainStateEvent()
}