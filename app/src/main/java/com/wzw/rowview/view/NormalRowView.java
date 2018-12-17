package com.wzw.rowview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wzw.rowview.R;
import com.wzw.rowview.descriptor.NormalRowDescriptor;


/**
 *
 * Created by wzw on 2018/12/17
 */

public class NormalRowView extends BaseRowView<NormalRowDescriptor> implements View.OnClickListener{
    private ImageView mIvIcon;
    private TextView  mTvLabel;
    private TextView  mTvDescription;
    private ImageView mIvArrowsIcon;

    public NormalRowView(Context context) {
        this(context,null);
    }

    public NormalRowView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public NormalRowView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.widget_normal_row_view, this);
        mIvIcon = (ImageView) findViewById(R.id.iv_row_view_icon_left);
        mTvLabel = (TextView) findViewById(R.id.tv_row_view_label_left);
        mTvDescription = (TextView) findViewById(R.id.tv_row_view_label_right);
        mIvArrowsIcon = (ImageView) findViewById(R.id.iv_row_view_arrows);
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);
    }

    @Override
    public void onClick(View v) {
        if (mOnRowViewClickListener != null) {
            mOnRowViewClickListener.onRowViewClick(mDescriptor.getLabelText());
        }
    }

    public void setRightText(){
        mTvLabel.setText(mDescriptor.getLabelText());
    }
    @Override
    public void notifyDataChanged(NormalRowDescriptor descriptor) {
        this.mDescriptor =  descriptor;
        if (descriptor != null) {
            if (descriptor.getImageResId() > 0) {
                mIvIcon.setBackgroundResource(descriptor.getImageResId());
                mIvIcon.setVisibility(VISIBLE);
            } else {
                mIvIcon.setVisibility(GONE);
            }
            mTvLabel.setText(descriptor.getLabelText());
            if (descriptor.isHasAction()) {
                setOnClickListener(this);
                mIvArrowsIcon.setVisibility(VISIBLE);
            } else {
                mIvArrowsIcon.setVisibility(GONE);
            }
            if(descriptor.getDescription() != null){
                mTvDescription.setVisibility(View.VISIBLE);
                mTvDescription.setText(descriptor.getDescription());
            }else {
                mTvDescription.setVisibility(View.GONE);
            }
        } else {
            setVisibility(GONE);
        }
    }
}
