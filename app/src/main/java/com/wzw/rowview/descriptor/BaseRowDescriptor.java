package com.wzw.rowview.descriptor;

import com.wzw.rowview.RowViewType;

/**
 *
 * Created by wzw on 2018/12/17
 */

public class BaseRowDescriptor {
    private RowViewType mRowViewType = RowViewType.Normal;


    public RowViewType getRowViewType() {
        return mRowViewType;
    }

    public BaseRowDescriptor setRowViewType(RowViewType rowViewType) {
        mRowViewType = rowViewType;
        return this;
    }
}
