package qrtx.com.volleydemo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.util.LruCache;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2016/9/25.
 */
public class ImageRequestActivity extends AppCompatActivity {


    String url = "http://pic74.nipic.com/file/20150811/6614631_110122869000_2.jpg";
    ImageView image;
    RequestQueue mRequestQueue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView) findViewById(R.id.image);
        mRequestQueue = Volley.newRequestQueue(this);
    }

    public void click1(View view) {
        volley_ImageRequest();
    }

    private void volley_ImageRequest() {
        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                if (response != null) {
                    image.setImageBitmap(response);
                }
            }
        }, 100, 100, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        mRequestQueue.add(imageRequest);
    }

    public void click2(View view) {
        volley_ImageLoading();
    }

    private void volley_ImageLoading() {
        ImageLoader imageLoader = new ImageLoader(mRequestQueue, new BitmapCache());

        imageLoader.get(url, new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                image.setImageBitmap(response.getBitmap());
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }, 0, 0);
    }


    class BitmapCache implements ImageLoader.ImageCache {
        int maxSize = 1024 * 1024 * 4;
        LruCache<String, Bitmap> cache;

        public BitmapCache() {
            cache = new LruCache<String, Bitmap>(maxSize) {
                @Override
                protected int sizeOf(String key, Bitmap value) {
                    int byteCount1 = value.getByteCount();
                    int byteCount2 = value.getRowBytes() * value.getHeight();
                    Log.i("BitmapCache", "byteCount1=" + byteCount1 + "---------byteCount2=" + byteCount1);
                    return byteCount2;
                }

            };
        }

        @Override
        public Bitmap getBitmap(String url) {
            Log.i("BitmapCache", "getBitmap  " + url);
            return cache.get(url);
        }

        @Override
        public void putBitmap(String url, Bitmap bitmap) {
            Log.i("BitmapCache", "putBitmap  " + url);
            cache.put(url, bitmap);
        }
    }
}
