package renhong.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mBtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtn1 = (Button) findViewById(R.id.bttton1);
        mBtn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==mBtn1){
            startActivity(new Intent(this,FlackerActivity.class));
        }
    }
}
