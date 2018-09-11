package com.example.tainguyen.mvvm.utils

import android.app.Activity
import android.content.DialogInterface
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.layout_progress_bar.*

fun Activity.hideLoading() {
    progressBar?.visibility = View.GONE
}

fun Activity.showLoading() {
    progressBar?.visibility = View.VISIBLE
}

fun Activity.showDialog(message: String, onClickListener: DialogInterface.OnClickListener? = null) {
    AlertDialog.Builder(this).setMessage(message).setPositiveButton(android.R.string.ok, onClickListener).create().show()
}

fun Activity.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, message, duration).show()

fun Activity.showSnackBar(text: String) {
    val container = findViewById<View>(android.R.id.content)
    container?.run {
        Snackbar.make(this, text, Snackbar.LENGTH_SHORT).show()
    }
}

fun AppCompatActivity.addFragment(containerViewId: Int, fragment: Fragment, addToBackStack: Boolean) {
    val fragmentManager = supportFragmentManager
    val transaction = fragmentManager.beginTransaction()
    //        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
    if (addToBackStack)
        transaction.addToBackStack(fragment.javaClass.name)
    transaction.replace(containerViewId, fragment, fragment.javaClass.name)
    transaction.commitAllowingStateLoss()
}