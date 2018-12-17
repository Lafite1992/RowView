package com.wzw.rowview.descriptor;

import android.graphics.Color;


import com.wzw.rowview.R;

import java.util.ArrayList;

/**
 *
 * Created by wzw on 2018/12/17
 */

public class GroupDescriptor {
    public  ArrayList<BaseRowDescriptor> descriptors;
    public  int                          bgColor = Color.WHITE;
    public  int                          dividerColor = R.color.under_line;
    private boolean                      isCircleBg;
    private int                          margin;

    public GroupDescriptor addDescriptor(BaseRowDescriptor descriptor) {
        if (descriptors == null) {
            descriptors = new ArrayList<>();
        }
        descriptors.add(descriptor);
        return this;
    }

    public GroupDescriptor bgColor(int color) {
        this.bgColor = color;
        return this;
    }

    public int getMargin() {
        return margin;
    }

    public GroupDescriptor setMargin(int margin) {
        this.margin = margin;
        return this;
    }

    public boolean isCircleBg() {
        return isCircleBg;
    }

    public GroupDescriptor setCircleBg(boolean circleBg) {
        isCircleBg = circleBg;
        return this;
    }
}
