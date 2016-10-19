package qrtx.com.okhttpdemo;

import android.app.Fragment;
import android.util.Log;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/9/25.
 */
public class OkHttpUtil {

    private OkHttpClient okHttpClient;
    private Request.Builder builder;

    public OkHttpUtil() {


//        try {
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        new ArrayList<>(20);
//        String str = (String) null;
        okHttpClient = new OkHttpClient();
        builder = new Request.Builder();
    }

    public void sendGetRequest(String url, Callback callback) {
        Request request = builder.url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);


//        new Request().url();
    }


    public void sendPostRequest(String baseUrl, RequestBody body) {
        Request request = builder.post(body).url(baseUrl).build();

    }
}
