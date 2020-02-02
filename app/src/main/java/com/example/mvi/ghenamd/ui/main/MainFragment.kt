package com.example.mvi.ghenamd.ui.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvi.ghenamd.R
import com.example.mvi.ghenamd.ui.main.state.MainStateEvent

class MainFragment : Fragment() {

    lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        viewModel = activity?.run {
            ViewModelProvider(this).get(MainViewModel::class.java)
        }?: throw Exception("Invalid lifecycle owner")
    }

    fun subscribeObservers() {
        viewModel.dataState.observe(viewLifecycleOwner, Observer { dataState ->
            dataState.blogPost?.let {listOfBlogs->
                // Set BlogPost data
                viewModel.setCurrentOrNewBlogListData(listOfBlogs)
            }
            dataState.user?.let {user->
                // Set User data
                viewModel.setCurrentOrNewUserData(user)
            }

        })

        viewModel.viewState.observe(viewLifecycleOwner, Observer { viewState ->
            viewState.blogPost?.let {
                // Set BlogPost to Recyclerview
            }
            viewState.user?.let {
                // Set user to Recyclerview
            }

        })
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
             R.id.action_get_blogs -> triggerBlogPostEvent()
             R.id.action_get_user -> triggerGetUserEvent()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun triggerBlogPostEvent(){
        viewModel.setStateEvent(MainStateEvent.GetBlogPostsEvent())
    }
    private fun triggerGetUserEvent(){
        viewModel.setStateEvent(MainStateEvent.GetUserEvent("1"))
    }

}