package com.study.openlibs.databinding

import androidx.databinding.BindingAdapter

class UserBean(val errorUrl: String, val placeHolder: String, val picUrl: String) {



}

class ImageViewBindingAdapter {
    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun setImage() {

        }
    }
}