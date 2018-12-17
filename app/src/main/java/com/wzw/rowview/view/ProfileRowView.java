package com.wzw.rowview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.wzw.rowview.descriptor.NormalRowDescriptor;

/**
 * Created by wzw on 2018/12/17
 */
public class ProfileRowView extends BaseRowView<NormalRowDescriptor> implements View.OnClickListener {
    public ProfileRowView(Context context) {
        this(context,null);
    }

    public ProfileRowView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ProfileRowView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void notifyDataChanged(NormalRowDescriptor descriptor) {

    }
}
