package com.wzw.rowview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.wzw.rowview.OnRowViewClickListener;
import com.wzw.rowview.descriptor.GroupDescriptor;

import java.util.ArrayList;


/**
 *
 * Created by wzw on 2018/12/17
 */

public class ContainerView extends LinearLayout {
    private ArrayList<GroupDescriptor> descriptors;
    private OnRowViewClickListener     listener;
    private boolean                    hasPaddingTop;

    public ContainerView(Context context) {
        this(context,null);
    }

    public ContainerView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ContainerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    private void initView() {
        setOrientation(VERTICAL);
    }

    public void initData(ArrayList<GroupDescriptor> descriptors, OnRowViewClickListener listener) {
        this.descriptors = descriptors;
        this.listener = listener;
    }

    public void notifyDataChanged() {
        removeAllViews();
        if (descriptors != null && descriptors.size() > 0) {
            GroupView group;
            float density = getContext().getResources().getDisplayMetrics().density;

            for (int i = 0; i < descriptors.size(); i++) {
                GroupDescriptor descriptor = descriptors.get(i);

                LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
                if(hasPaddingTop && i == 0){
                    params.topMargin = (int) (20 * density);
                }
                params.bottomMargin = (int) (20 * density);
                params.leftMargin = (int) (descriptor.getMargin() * density);
                params.rightMargin = (int) (descriptor.getMargin() * density);
                group = new GroupView(getContext());
//                if(descriptor.isCircleBg()){
//                    group.isCircleBg = true;
//                }
                group.initializeData(descriptors.get(i), listener);
//                if (i == 0 && hasPaddingTop) {
//                    group.hasPaddingTop(hasPaddingTop);
//                } else {
//                    if (i != 0) {
//                        group.hasPaddingTop(true);
//                    }
//                }
                group.notifyDataChanged();
                addView(group, params);
            }
            setVisibility(View.VISIBLE);
        } else {
            setVisibility(View.GONE);
        }
    }

    public void hasPaddingTop(boolean hasPaddingTop) {
        this.hasPaddingTop = hasPaddingTop;
    }
}
