package com.canbazdev.hipocase.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.canbazdev.hipocase.R

/*
*   Created by hamzacanbaz on 4/12/2023
*/

class DevelopersAdapterItemDecoration : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val verticalMarginValue = view.resources.getDimensionPixelSize(R.dimen.margin_24dp)
        val horizontalMarginValue = view.resources.getDimensionPixelSize(R.dimen.margin_16dp)
        val isFirstItem = parent.getChildAdapterPosition(view) == 0

        with(outRect) {
            if (isFirstItem) top = verticalMarginValue
            bottom = verticalMarginValue
            right = horizontalMarginValue
            left = horizontalMarginValue
        }
    }

}