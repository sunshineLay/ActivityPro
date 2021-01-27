package com.example.activitypro.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


/**
 * 基本改造
 * @param <T>
 */
public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseRecyclerViewAdapter.ViewHolder> {
    protected List<T> tList;
    protected Context mContext;
    protected LayoutInflater mLayoutInflater;
    protected int mLayoutId;

    private MultiTypeSupport<T> multiTypeSupport;

    public BaseRecyclerViewAdapter(List<T> tList, Context mContext, int layId) {
        this.tList = tList;
        this.mContext = mContext;
        this.mLayoutId=layId;
        mLayoutInflater= LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 多布局支持
        if (multiTypeSupport != null) {
            mLayoutId = viewType;//这个就是getItemViewType方法的返回值，我们直接使用布局Id来做返回值，可以省略设置静态int值。
        }
        View view = mLayoutInflater.inflate(mLayoutId, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    //之后在具体实现子类中重写这个方法
    public void onBindViewHolder(BaseRecyclerViewAdapter.ViewHolder holder, final int position) {
        convert(holder, tList.get(position));
    }

    public T getItem(int position) {
        return tList.get(position);
    }

    public void setMultiTypeSupport(MultiTypeSupport<T> multiTypeSupport){
        this.multiTypeSupport=multiTypeSupport;
    }

    @Override
    public int getItemCount() {
        return tList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (multiTypeSupport!=null){
            return multiTypeSupport.getLayoutId(tList.get(position));
        }
        return super.getItemViewType(position);
    }

  public abstract void convert(ViewHolder holder, T itemData);

    /**
     * 重置数据,下拉刷新时使用
     */
    public void resetData(List<T> mList){
        this.tList.clear();
        this.tList=mList;
        notifyDataSetChanged();
    }

    /**
     * 重置数据,下拉刷新时使用
     */
    public void clearData(){
        this.tList.clear();
        notifyDataSetChanged();
    }

    /**
     * 上拉加载
     */
    public void loadMoreData(List<T> mList){
        if(mList!=null){
            tList.addAll(mList);
            notifyDataSetChanged();
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private SparseArray<View> mViewArray;

        public ViewHolder(View itemView) {
            super(itemView);
            mViewArray=new SparseArray<>();
        }

        /**
         * 通过id得到view
         * @param viewId
         * @param <V>
         * @return
         */
        public <V extends View>V getViewAtId(int viewId){
            View view = mViewArray.get(viewId);
            if(view==null){
                view=itemView.findViewById(viewId);
                mViewArray.put(viewId,view);
            }
            return (V)view;
        }

        /**
         * 设置文字
         * @param viewId
         * @param text
         * @return
         */
        public ViewHolder setText(int viewId, CharSequence text){
           TextView textView= getViewAtId(viewId);
           textView.setText(text);
           return  this;
        }
        /**
         * CheckBox设置文字
         * @param viewId
         * @param text
         * @return
         */
        public ViewHolder setCheckBoxText(int viewId, CharSequence text){
            CheckBox checkBox= getViewAtId(viewId);
            checkBox.setText(text);
            return  this;
        }

        /**
         * 通过网址设置图片
         * @param viewId
         * @param imgUrl
         * @return
         */
//        public ViewHolder setImageFromUrl(int viewId, String imgUrl){
//           ImageView imageView= getViewAtId(viewId);
//
//            RequestOptions requestOptions = new RequestOptions();
//            requestOptions.error(R.mipmap.zanwutoux);
//
//            Glide.with(imageView.getContext())
//                    .load(imgUrl)
//                    .apply(requestOptions)
//                    .transition(withCrossFade())
//                    .into(imageView);
//            //头像错误怎么设置默认的头像。
//            return this;
//        }

        /**
         * 通过资源来设置图片资源
         * @param viewId
         * @param resId
         * @return
         */
        public ViewHolder setImageFromRes(int viewId,int resId){
            ImageView imageView = getViewAtId(viewId);
            imageView.setImageResource(resId);
            return this;
        }

        /**
         * 设置控件透明度
         * @param viewId
         * @param visibility
         * @return
         */
        public ViewHolder setViewVisibility(int viewId,int visibility){
            View view = getViewAtId(viewId);
            view.setVisibility(visibility);
            return this;
        }


    }

    /**
     * 多布局接口
     * @param <T>
     */
    public interface  MultiTypeSupport<T>{
        int getLayoutId(T item);
    }

}
