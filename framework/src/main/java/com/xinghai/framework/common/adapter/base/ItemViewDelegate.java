package com.xinghai.framework.common.adapter.base;


/**
 * Created by yuanbaoyu on 16/10/11.
 */
public interface ItemViewDelegate<T>
{

    int getItemViewLayoutId();

    boolean isForViewType(T item, int position);

    void convert(ViewHolder holder, T t, int position);

}
