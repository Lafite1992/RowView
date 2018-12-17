package com.wzw.rowview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.wzw.rowview.OnRowViewClickListener;
import com.wzw.rowview.R;
import com.wzw.rowview.RowViewFactory;
import com.wzw.rowview.descriptor.BaseRowDescriptor;
import com.wzw.rowview.descriptor.GroupDescriptor;
import com.wzw.rowview.util.DensityUtil;

import java.util.ArrayList;

/**
 *
 * Created by wzw on 2018/12/17
 */

public class GroupView extends LinearLayout {
    private ArrayList<BaseRowDescriptor> descriptors;
    private OnRowViewClickListener       listener;
    private int                          padding;
    private float                        density;
    private boolean                      hasPaddingTop = false;
    private int                          bgColor;
    private int                          dividerColor;

    public GroupView(Context context) {
        this(context,null);
    }

    public GroupView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public GroupView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context);
    }

    private void initView(Context context) {
        setOrientation(VERTICAL);
        density = context.getResources().getDisplayMetrics().density;
        padding = (int) (20 * density);
    }

    public void initializeData(GroupDescriptor descriptor, OnRowViewClickListener listener) {
        this.descriptors = descriptor.descriptors;
        this.bgColor = descriptor.bgColor;
        this.dividerColor = descriptor.dividerColor;
        this.listener = listener;
    }

    public void notifyDataChanged() {
        removeAllViews();
        BaseRowView row;
        View line;
        setBackgroundResource(R.color.white);
        LayoutParams lineParams = new LayoutParams(LayoutParams.MATCH_PARENT, DensityUtil.dp2px(getContext(), 0.5f));
        lineParams.leftMargin = (int) (10 * density);
        lineParams.rightMargin = (int) (10 * density);
        BaseRowDescriptor descriptor;
//        LayoutParams rowParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//        rowParams.leftMargin = (int) (10 * density);
//        rowParams.rightMargin = (int) (10 * density);
        int lineColor = getResources().getColor(dividerColor);
        if (descriptors != null && descriptors.size() > 0) {
            for (int i = 0; i < descriptors.size(); i++) {
                descriptor = descriptors.get(i);
                row = RowViewFactory.getRowView(descriptor,getContext());
//                } else if (descriptor instanceof ToggleRowDescriptor) {
//                    row = new ToggleRowView(context);
//                } else if (descriptor instanceof OneRowDescriptor) {
//                    row = new OneRowView(context);
//                } else if (descriptor instanceof ProfileRowDescriptor) {
//                    row = new ProfileRowView(context);
//                } else if (descriptor instanceof SocialRowDescriptor) {
//                    row = new SocialRowView(context);
//                } else if (descriptor instanceof RadioGroupRowDescriptor) {
//                    row = new RadioGroupRowView(context);
//                } else if (descriptor instanceof MultiRowDescriptor) {
//                    row = new MultiRowView(context);
//                } else if (descriptor instanceof GridRowDescriptor) {
//                    row = new GridRowView(context);
//                } else if (descriptor instanceof VerticalRowDescriptor) {
//                    row = new VerticalRowView(context);
//                } else if (descriptor instanceof ImgUploadRowDescriptor) {
//                    row = new ImgUploadRowView(context);
//                } else if (descriptor instanceof VerifyRowDescriptor) {
//                    row = new VerifyRowView(context);
//                } else if (descriptor instanceof TableRowDescriptor) {
//                    row = new TableRowView(context);
//                } else if (descriptor instanceof InsuranceRowDescriptor) {
//                    row = new InsuranceRowView(context);
//                } else if (descriptor instanceof LinkRowDescriptor) {
//                    row = new LinkRowView(context);
//                } else if (descriptor instanceof ButtonRowDescriptor) {
//                    row = new ButtonRowView(context);
//                } else if (descriptor instanceof HtmlRowDescriptor) {
//                    row = new HtmlRowView(context);
//                } else if (descriptor instanceof LinceseUploadRowDescriptor) {
//                    row = new LinceseUploadRowView(context);
//                } else if (descriptor instanceof QuotationTipRowDescriptor) {
//                    row = new QuotationTipRowView(context);
//                row.setPadding(padding / 2, padding / 2, padding / 2, padding / 2);
                row.setOnRowChangedListener(listener);
                row.notifyDataChanged(descriptor);
                addView(row);
                if (i != descriptors.size() - 1) {
                    line = new View(getContext());
                    line.setBackgroundColor(lineColor);
                    addView(line, lineParams);
                }
            }


        } else {
//            setVisibility(View.GONE);
        }
    }




    public void hasPaddingTop(boolean hasPaddingTop) {
        this.hasPaddingTop = hasPaddingTop;
    }
}
