package com.example.josephsibiya.baclayspremierleague.decoration;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by josephsibiya on 2017/09/01.
 */

public class ViewDecoration extends RecyclerView.ItemDecoration {

    private int spanCount;
    private int spacing;
    private boolean includeEdge;


    public ViewDecoration(int spanCount, int spacing, boolean includeEdge) {
        this.spanCount = spanCount;
        this.spacing = spacing;
        this.includeEdge = includeEdge;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int position = parent.getChildAdapterPosition(view); // item position
        int column = position % spanCount;// item column

        if (includeEdge)
        {
            outRect.left = spacing - column * spacing / spanCount;
            outRect.right = (column + 1) * spacing / spanCount;

            if (position < spanCount)
            {
                outRect.top = spacing;
            }

            outRect.bottom = spacing;
        }
        else {
            outRect.left = column * spacing / spanCount;
            outRect.right = spacing - (column + 1) * spacing / spanCount;

            if (position >= spanCount)
            {
                outRect.top = spacing;
            }
        }
    }
}
