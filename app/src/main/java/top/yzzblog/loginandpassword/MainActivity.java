package top.yzzblog.loginandpassword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn = findViewById(R.id.btn_login);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        //动态注册广播接收器
        IntentFilter filter = new IntentFilter("top.yzzblog.LOGIN");
        registerReceiver(new MyBroadCastReceiver(), filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(new MyBroadCastReceiver());
    }

    class MyBroadCastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, intent.getStringExtra("msg"), Toast.LENGTH_SHORT).show();
        }
    }
}
