package com.example.k2ohashi.testapp;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by k2ohashi on 17/05/25.
 */
public class ImageLruCache implements ImageLoader.ImageCache {

    private final LruCache<String, Bitmap> mMemoryCache;

    public ImageLruCache() {
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        int cacheSize = maxMemory / 8;

        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getByteCount() / 1024;
            }

            @Override
            protected void entryRemoved(boolean evicted, String key, Bitmap oldVal, Bitmap newVal) {
                super.entryRemoved(evicted, key, oldVal, newVal);
            }

            @Override
            protected Bitmap create(String key) {
                return super.create(key);
            }
        };
    }

    @Override
    public Bitmap getBitmap(String url) {
        return mMemoryCache.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        mMemoryCache.put(url, bitmap);
    }
}