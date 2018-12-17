package com.wzw.rowview.descriptor;

/**
 *
 * Created by wzw on 2018/12/17
 */

public class NormalRowDescriptor extends BaseRowDescriptor {
    protected String  label;
    protected int     imageResId;
    private   boolean hasAction = true;
    private   String  description;
    private   String  rightImageUrl;

    public String getLabelText() {
        return label;
    }

    public NormalRowDescriptor setLabelText(String labelText) {
        label = labelText;
        return this;
    }

    public int getImageResId() {
        return imageResId;
    }

    public NormalRowDescriptor setImageResId(int resId) {
        imageResId = resId;
        return this;
    }


    public String getDescription() {
        return description;
    }

    public NormalRowDescriptor setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getRightImageUrl() {
        return rightImageUrl;
    }

    public NormalRowDescriptor setRightImageUrl(String url) {
        this.rightImageUrl = url;
        return this;
    }

    public boolean isHasAction() {
        return hasAction;
    }

    public NormalRowDescriptor setHasAction(boolean hasAction) {
        this.hasAction = hasAction;
        return this;
    }
}
