package com.yeqiu.hydra.utils.image;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

/**
 * @project：Xbzd
 * @author：小卷子
 * @date 2018/4/14
 * @describe：图片加载框架
 * @fix：
 */
public class ImageUtils {


    private static RequestOptions getRequestOptions() {

        return new RequestOptions()
                //  .placeholder(UiConfig.getInstance().getImgPlaceholder())
                //  .error(UiConfig.getInstance().getImgError())
                .diskCacheStrategy(DiskCacheStrategy.ALL);
    }


    /**
     * 以填满整个ImageView，将原图的中心对准ImageView的中心，等比例放大原图，直到填满ImageView为止（ImageView
     * 的宽和高都要填满），原图超过ImageView的部分作裁剪处理。
     *
     * @param url
     * @param imageView
     */
    public static void setImageWithCenerCrop(Context context, String url, ImageView imageView) {

        if (TextUtils.isEmpty(url) || !checkContext(context)) {
            return;
        }

        RequestOptions options = getRequestOptions().centerCrop();

        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }

    /**
     * 以填满整个ImageView，将原图的中心对准ImageView的中心，等比例放大原图，直到填满ImageView为止（ImageView
     * 的宽和高都要填满），原图超过ImageView的部分作裁剪处理。
     *
     * @param ImgId
     * @param imageView
     */
    public static void setImageWithCenerCrop(Context context, int ImgId, ImageView imageView) {

        if (!checkContext(context)) {
            return;
        }

        RequestOptions options = getRequestOptions().centerCrop();

        Glide.with(context)
                .load(ImgId)
                .apply(options)
                .into(imageView);
    }


    /**
     * 保持原图比例放大图片去填充View
     *
     * @param url
     * @param imageView
     */
    public static void setImageWithfitCenter(Context context, String url, ImageView imageView) {

        if (TextUtils.isEmpty(url) || !checkContext(context)) {
            return;
        }


        RequestOptions options = getRequestOptions().fitCenter();

        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }


    /**
     * 保持原图比例放大图片去填充View
     *
     * @param urlId
     * @param imageView
     */
    public static void setImageWithfitCenter(Context context, int urlId, ImageView imageView) {


        if (!checkContext(context)) {
            return;
        }

        RequestOptions options = getRequestOptions().fitCenter();

        Glide.with(context)
                .load(urlId)
                .apply(options)
                .into(imageView);
    }


    /**
     * 裁剪成圆图
     *
     * @param url
     * @param imageView
     */
    public static void setCircleImage(Context context, String url, final ImageView
            imageView) {

        if (TextUtils.isEmpty(url) || !checkContext(context)) {
            return;
        }

        RequestOptions options = getRequestOptions().circleCrop();

        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);

    }


    /**
     * 裁剪成圆图
     *
     * @param context
     * @param imgId
     * @param imageView
     */
    public static void setCircleImage(Context context, int imgId, final ImageView
            imageView) {

        if (!checkContext(context)) {
            return;
        }

        RequestOptions options = getRequestOptions().circleCrop();

        Glide.with(context)
                .load(imgId)
                .apply(options)
                .into(imageView);

    }


    /**
     * 设置背景
     *
     * @param url
     * @param view
     */
    public static void setBg(Context context, String url, final View view) {

        if (TextUtils.isEmpty(url) || !checkContext(context)) {
            return;
        }

        Glide.with(context)
                .load(url)
                .apply(getRequestOptions())
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition
                            <? super Drawable> transition) {

                        if (Build.VERSION.SDK_INT >= 16) {
                            view.setBackground(resource);
                        } else {
                            view.setBackgroundDrawable(resource);
                        }

                    }
                });
    }

    /**
     * 设置背景
     *
     * @param id
     * @param view
     */
    public static void setBg(Context context, int id, final View view) {

        if (view == null || !checkContext(context)) {

            return;
        }


        Glide.with(context)
                .load(id)
                .apply(getRequestOptions())
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable
                            Transition<? super Drawable> transition) {

                        if (Build.VERSION.SDK_INT >= 16) {
                            view.setBackground(resource);
                        } else {
                            view.setBackgroundDrawable(resource);
                        }

                    }
                });


    }


    /**
     * 根据图大小自动设置
     *
     * @param url
     * @param imageView
     */
    public static void setSimpleImage(Context context, String url, final ImageView imageView) {

        if (TextUtils.isEmpty(url) || !checkContext(context)) {
            return;
        }


        RequestOptions options = getRequestOptions();

        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);

    }

    /**
     * 根据图大小自动设置
     *
     * @param id
     * @param imageView
     */
    public static void setSimpleImage(Context context, int id, final ImageView imageView) {


        if (!checkContext(context)) {
            return;
        }

        RequestOptions options = getRequestOptions();

        Glide.with(context)
                .load(id)
                .apply(options)
                .into(imageView);

    }


    /**
     * 圆角图片
     *
     * @param context
     * @param id
     * @param imageView
     * @param round
     */
    public static void setImageWithRound(Context context, int id, final ImageView
            imageView, int round) {


        if (!checkContext(context)) {
            return;
        }

        RequestOptions requestOptions = getRequestOptions().transforms(new CenterCrop(), new
                RoundedCorners(round));

        Glide.with(context)
                .load(id)
                .apply(requestOptions)
                .into(imageView);

    }

    /**
     * 圆角图片
     *
     * @param context
     * @param url
     * @param imageView
     * @param round
     */
    public static void setImageWithRound(Context context, String url, final ImageView
            imageView, int round) {


        if (!checkContext(context) || TextUtils.isEmpty(url)) {
            return;
        }

        RequestOptions requestOptions = getRequestOptions().transforms(new CenterCrop(), new
                RoundedCorners(round));


        Glide.with(context)
                .load(url)
                .apply(requestOptions)
                .into(imageView);

    }


    private static boolean checkContext(Context context) {

        if (context instanceof Activity) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                return !((Activity) context).isDestroyed();
            }

            return !((Activity) context).isFinishing();
        } else {
            return context != null;
        }
    }

}