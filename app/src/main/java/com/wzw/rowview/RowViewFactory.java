package com.wzw.rowview;

import android.content.Context;

import com.wzw.rowview.descriptor.BaseRowDescriptor;
import com.wzw.rowview.view.BaseRowView;
import com.wzw.rowview.view.NormalRowView;
import com.wzw.rowview.view.ProfileRowView;
import com.wzw.rowview.view.ToggleRowView;


/**
 * Created by wzw on 2018/12/17
 */
public class RowViewFactory {
    private RowViewFactory(){

    }
    public static BaseRowView getRowView(BaseRowDescriptor descriptor, Context context){
        switch (descriptor.getRowViewType()){
            case Normal:
                return new NormalRowView(context);
            case Toggle:
                return new ToggleRowView(context);
            case Profile:
                return new ProfileRowView(context);
            default:
                return null;
        }
    }
}
