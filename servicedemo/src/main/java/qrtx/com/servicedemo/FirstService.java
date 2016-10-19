package qrtx.com.servicedemo;

import android.app.Service;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by Administrator on 2016/9/26.
 */
public class FirstService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("-FirstService", "onBind");
//        bindService()

        return new MyBinder();
    }

    @Override
    public void onCreate() {
        Log.i("-FirstService", "onCreate");
        new Thread(new Runnable() {
            @Override
            public void run() {
                int[] ids = {R.mipmap.a, R.mipmap.b, R.mipmap.c, R.mipmap.d, R.mipmap.e, R.mipmap.f};
                int i = 20;

                while (i-- > 0) {
                    try {

                        setWallpaper(BitmapFactory.decodeResource(getResources(), ids[i % ids.length]));
                        SystemClock.sleep(1000);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                stopService(new Intent(getApplicationContext(), FirstService.class));
            }
        }).start();
        super.onCreate();
    }

    void showString() {
        Toast.makeText(this, "中间人", Toast.LENGTH_SHORT).show();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("-FirstService", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i("-FirstService", "onDestroy");
        super.onDestroy();
    }

    public class MyBinder extends Binder {
        void test() {
            showString();
        }
    }
}
