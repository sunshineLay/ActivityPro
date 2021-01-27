package com.example.activitypro.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 定制RecyclerView的分割线
 * 目标：使用Drawable资源来定制分割线
 * 注意：分割线占据的是item的宽度。
 */
public class MainClidItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable mDrawable;

    public MainClidItemDecoration(Context mContext, int drawableResId) {
        this.mDrawable = ContextCompat.getDrawable(mContext,drawableResId);
    }

    /**
     * 绘制分割线
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        //利用Canvas想绘制什么就绘制什么
        int childCount = parent.getChildCount();
        Rect rect = new Rect();
        rect.left=parent.getPaddingLeft();
        rect.right=parent.getWidth()-parent.getPaddingRight();
        for (int i = 1; i <childCount ; i++) {
            View view = parent.getChildAt(i);
            rect.bottom=view.getTop();
            rect.top=rect.bottom-mDrawable.getIntrinsicHeight();

            mDrawable.setBounds(rect);
            mDrawable.draw(c);


        }

    }

    /**
     * 留出分割线位置
     * @param outRect
     * @param view
     * @param parent
     * @param state
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        super.getItemOffsets(outRect, view, parent, state);
        //每个item下面流出10px(像素，单位可以单独找一篇博客来看看)来绘制分割线。 验证一号
        //思路一：最后一个item下面不需要分割线；失败
        //思路二：第一个上面不需要item的分割线；成功
        int position=parent.getChildAdapterPosition(view);
        //parent.getChildCount()是不断变化的，不能直接得到parent.getChildCount()的确定数字。所以思路一作废。
//        if (position!=parent.getChildCount()-1){//如果不是最后一个item
//            outRect.bottom=10;
//        }
        if (position!=0){
            outRect.top=mDrawable.getIntrinsicHeight();
        }

    }
}
