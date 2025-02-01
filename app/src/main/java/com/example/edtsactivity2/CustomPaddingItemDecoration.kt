// CustomPaddingItemDecoration.kt
package com.example.edtsactivity2.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CustomPaddingItemDecoration(
    private val startPadding: Int, // Padding for start (before the first item)
    private val endPadding: Int,   // Padding for end (after the last item)
    private val itemGap: Int       // Gap between each item
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        // Get the layout manager of the RecyclerView
        val layoutManager = parent.layoutManager

        // Check if layout manager is not null and is of type LinearLayoutManager
        if (layoutManager is LinearLayoutManager) {
            // Horizontal Orientation (Left/Right Padding and Gaps)
            if (layoutManager.orientation == RecyclerView.HORIZONTAL) {
                // Apply padding before the first item (start of RecyclerView)
                if (parent.getChildAdapterPosition(view) == 0) {
                    outRect.left = startPadding // Padding at the start of RecyclerView
                }
                // Apply padding after the last item (end of RecyclerView)
                if (parent.getChildAdapterPosition(view) == state.itemCount - 1) {
                    outRect.right = endPadding // Padding at the end of RecyclerView
                }
                // Add gap between items (except the last item)
                if (parent.getChildAdapterPosition(view) != state.itemCount - 1) {
                    outRect.right = itemGap // Gap between items (except last one)
                }
            }
            // Vertical Orientation (Top/Bottom Padding and Gaps)
            else if (layoutManager.orientation == RecyclerView.VERTICAL) {
                // Apply padding before the first item (start of RecyclerView)
                if (parent.getChildAdapterPosition(view) == 0) {
                    outRect.top = startPadding // Padding at the start of RecyclerView
                }
                // Apply padding after the last item (end of RecyclerView)
                if (parent.getChildAdapterPosition(view) == state.itemCount - 1) {
                    outRect.bottom = endPadding // Padding at the end of RecyclerView
                }
                // Add gap between items (except the last item)
                if (parent.getChildAdapterPosition(view) != state.itemCount - 1) {
                    outRect.bottom = itemGap // Gap between items (except last one)
                }
            }
        }
    }
}
