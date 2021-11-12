package com.sun.demo.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sun.demo.R;
import com.sun.demo.model.ImgBean;

import me.drakeet.multitype.ItemViewBinder;

/**
 * @author Harper
 * @date 2021/11/11
 * note:
 */
public class ImgViewBinder extends ItemViewBinder<ImgBean, ImgViewBinder.ViewHolder> {


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_img, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull ImgBean imgBean) {
        holder.mImageView.setImageResource(imgBean.getDrawableId());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.item_img);
        }
    }
}
