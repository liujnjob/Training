package com.cetc.training.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zang on 2016/2/16 0016.
 * <p>Usage:<br>
 * 继承该adapter，
 * <pre>
 * CouponListAdapter extent BaseAdapter
 * listView = (ListView) findViewById(R.id.list_view);
 * listAdapter = new CouponListAdapter(this);
 * listView.setAdapter(listAdapter);
 * //为adapter设置数据
 * listAdapter.setItems(data);
 * //为adapter增加数据
 * listAdapter.addItems(data);
 * </pre>
 */
public abstract class BaseAdapter<T> extends android.widget.BaseAdapter {

    protected Context context;
    protected LayoutInflater inflater;
    protected List<T> itemList = new ArrayList<T>();

    public BaseAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    /**
     * 判断数据是否为空
     *
     * @return 为空返回true，不为空返回false
     */
    public boolean isEmpty() {
        return itemList.isEmpty();
    }

    /**
     * 在原有的数据上添加新数据
     *
     * @param itemList
     */
    public void addItems(List<T> itemList) {
        this.itemList.addAll(itemList);
        notifyDataSetChanged();
    }

    public void addItem(T item){
        this.itemList.add(item);
        notifyDataSetChanged();
    }

    /**
     * 设置为新的数据，旧数据会被清空
     *
     * @param itemList
     */
    public void setItems(List<T> itemList) {
        this.itemList.clear();
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    public List<T> getItems(){
        return itemList;
    }

    /**
     * 清空数据
     */
    public void clearItems() {
        itemList.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public T getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    abstract public View getView(int i, View view, ViewGroup viewGroup);
}
