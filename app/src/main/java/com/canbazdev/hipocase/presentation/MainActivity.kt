package com.canbazdev.hipocase.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.canbazdev.hipocase.R
import com.canbazdev.hipocase.adapter.DevelopersAdapter
import com.canbazdev.hipocase.adapter.DevelopersAdapterItemDecoration
import com.canbazdev.hipocase.data.model.hipo.Hipo
import com.canbazdev.hipocase.data.model.hipo.Member
import com.canbazdev.hipocase.presentation.home.HomeViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}