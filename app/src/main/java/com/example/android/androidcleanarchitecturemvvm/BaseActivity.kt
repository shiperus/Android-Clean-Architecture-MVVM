package com.example.android.androidcleanarchitecturemvvm

import android.app.ProgressDialog
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

open class BaseActivity<V : BaseViewModel> : AppCompatActivity(), KodeinAware {
    override lateinit var kodein: Kodein

    var progressDialog: ProgressDialog? = null
    lateinit var viewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        progressDialog = ProgressDialog(this)
        progressDialog?.setMessage("Loading.....")
        kodein = (applicationContext as BaseApp).kodein
    }

    fun observeViewState(){
        viewModel.viewState.observe(this, Observer {
            if (null != it) {
                if (it.isLoading)
                    showLoading()
                else if (!it.isLoading)
                    hideLoading()
            }
        })
    }

    private fun showLoading() {
        progressDialog?.show()
    }

    private fun hideLoading() {
        progressDialog?.hide()
    }

}