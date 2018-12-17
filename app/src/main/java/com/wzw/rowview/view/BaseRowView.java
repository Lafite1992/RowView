package com.wzw.rowview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.wzw.rowview.OnRowViewClickListener;
import com.wzw.rowview.descriptor.BaseRowDescriptor;


/**
 *
 * Created by wzw on 2018/12/17
 */

public abstract class BaseRowView<T extends BaseRowDescriptor> extends LinearLayout {
    protected OnRowViewClickListener mOnRowViewClickListener;
    protected T                      mDescriptor;

    public BaseRowView(Context context) {
        this(context,null);
    }

    public BaseRowView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BaseRowView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setOnRowChangedListener(OnRowViewClickListener listener) {
        this.mOnRowViewClickListener = listener;
    }

    public abstract void notifyDataChanged(T descriptor);

}
