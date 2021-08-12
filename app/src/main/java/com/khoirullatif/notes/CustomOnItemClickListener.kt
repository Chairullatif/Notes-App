package com.khoirullatif.notes

import android.view.View

class CustomOnItemClickListener(private val position: Int, private val onItemClickCallback: OnItemClickCallback) : View.OnClickListener {

    override fun onClick(view: View?) {
        TODO("Not yet implemented")
    }

    interface OnItemClickCallback {
        fun onItemClicked(view: View, position: Int)
    }

}