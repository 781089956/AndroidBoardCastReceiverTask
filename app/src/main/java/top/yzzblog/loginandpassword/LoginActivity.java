package top.yzzblog.loginandpassword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText mEtUser,mEtPwd;
    private Button mBtnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEtUser = findViewById(R.id.et_user);
        mEtPwd = findViewById(R.id.et_pwd);
        mBtnLogin = findViewById(R.id.btn_login);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mEtUser.getText().toString().equals("") &&
                    !mEtPwd.getText().toString().equals(""))
                    sendBroadcast(new Intent("top.yzzblog.LOGIN").putExtra("msg",
                            "user:" + mEtUser.getText().toString() + " pwd:" + mEtPwd.getText().toString()));
                else
                    sendBroadcast(new Intent("top.yzzblog.LOGIN").putExtra("msg", "无效信息!"));
                finish();
            }
        });
    }
}
