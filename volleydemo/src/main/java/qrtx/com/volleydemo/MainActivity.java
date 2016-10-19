package qrtx.com.volleydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    //  http://118.244.212.82:9092/newsClient/user_login?ver=2&device=0&uid=98765432&pwd=98765432
    RequestQueue mQueue;
    String url = "http://118.244.212.82:9092/newsClient/user_login?ver=2&device=0";
    String baseUrl = "http://118.244.212.82:9092/newsClient";
    String txtUrl = "/user_login?ver=2&device=0";

    //202.100.9.79
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initView() {
    }

    private void initData() {
        mQueue = Volley.newRequestQueue(getApplicationContext());
    }


    public void click1(View view) {
        volley_Post();
    }

    public void click2(View view) {
        volley_Get();
    }


    public void volley_Get() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        mQueue.add(stringRequest);
        mQueue.start();
    }

    public void volley_Post() {
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, baseUrl + txtUrl, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getApplicationContext(), "请求失败", Toast.LENGTH_SHORT).show();
//            }
//        }) {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> params = new HashMap<>();
//                params.put("uid", "98765432");
//                params.put("pwd", "98765432");
//                return params;
//            }
//        };
//        mQueue.add(stringRequest);
//        mQueue.start();


//        HashMap<String, String> params = new HashMap<>();
//        params.put("uid", "98765432");
//        params.put("pwd", "98765432");
//        JSONObject jsonReqeuest = new JSONObject(params);
//        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonReqeuest, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getApplicationContext(), "请求失败", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        mQueue.add(objectRequest);
//        mQueue.start();
    }
}
