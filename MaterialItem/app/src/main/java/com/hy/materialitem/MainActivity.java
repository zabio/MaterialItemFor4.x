package com.hy.materialitem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.hy.materialitem.widget.CommonItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((CommonItem)findViewById(R.id.ci_active)).setOnItemClickListener(R.id.ci_active, mOnItemClickListener);
        ((CommonItem)findViewById(R.id.ci_inactive)).setOnItemClickListener(R.id.ci_inactive, mOnItemClickListener);
        ((CommonItem)findViewById(R.id.ci_update)).setOnItemClickListener(R.id.ci_update, mOnItemClickListener);
    }


    private CommonItem.OnItemClickListener mOnItemClickListener = new CommonItem.OnItemClickListener() {
        @Override
        public void onClick(int id) {

            switch (id) {
                case R.id.ci_active:
                    Toast.makeText(MainActivity.this,"Active Device",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.ci_inactive:
                    Toast.makeText(MainActivity.this,"Inactive Device",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.ci_update:
                    Toast.makeText(MainActivity.this,"Update Device",Toast.LENGTH_SHORT).show();
                    break;
            }

        }
    };
}
