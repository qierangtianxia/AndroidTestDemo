package qrtx.com.picassodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    String url = "http://pic74.nipic.com/file/20150811/6614631_110122869000_2.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageview);
    }

    public void click(View view) {
        Picasso.with(this).setIndicatorsEnabled(true);
//        Picasso.with(this)
////                .load(R.mipmap.b)
//                .load(url)
//                .into(imageView);

        Picasso.with(this)
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.a)
                .into(imageView);
    }
}
