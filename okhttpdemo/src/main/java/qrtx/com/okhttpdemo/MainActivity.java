package qrtx.com.okhttpdemo;

import android.content.ComponentName;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    String getUrl = "http://118.244.212.82:9092/newsClient/user_login?ver=2&device=0&uid=98765432&pwd=98765432";
    String postUrl = "http://118.244.212.82:9092/newsClient/user_login?ver=2&device=0";
    TextView txtTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTV = (TextView) findViewById(R.id.text);

        startService(null);
    }

    public void click1(View vIew) {
        sendGetRequest();
    }

    public void click2(View vIew) {
        sendPostRequest();
    }

    //发送Get请求
    private void sendGetRequest() {
        //        OkHttpClient okHttpClient = new OkHttpClient();
//        Request.Builder builder = new Request.Builder();
//        Request request = builder.url(url).build();
//        Call call = okHttpClient.newCall(request);
        Callback callback = new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("MainActivity-GetRequest", response.body().string());
            }
        };
//        call.enqueue(callback);
//
        OkHttpUtil okHttpUtil = new OkHttpUtil();
        okHttpUtil.sendGetRequest(getUrl, callback);
    }

    //发送Post请求
    private void sendPostRequest() {
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        FormBody formBody = builder.add("pwd", "admin").add("uid", "admin").build();
        Request request = new Request.Builder().url(postUrl).post(formBody).build();

        Call call = okHttpClient.newCall(request);

        Callback callback = new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("MainActivity-Post", response.body().string());
            }
        };

        call.enqueue(callback);
    }
}
