package qrtx.com.servicedemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Intent intent;
    private MyServiceConnection conn;
    private FirstService.MyBinder myBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, FirstService.class);
    }

    //start开启服务
    public void click1(View view) {

        startService(intent);
        finish();
    }

    //bind开启服务
    public void click2(View view) {
        conn = new MyServiceConnection();
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    public void click3(View view) {
        myBinder.test();
        unbindService(conn);
        conn=null;
    }


    @Override
    protected void onDestroy() {
        if (conn != null) {
            unbindService(conn);
        }
        super.onDestroy();
    }

    class MyServiceConnection implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (FirstService.MyBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}
