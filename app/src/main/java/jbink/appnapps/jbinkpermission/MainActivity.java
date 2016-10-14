package jbink.appnapps.jbinkpermission;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_nomessage, R.id.btn_only_deny_message, R.id.btn_only_rationale_message, R.id.btn_rationale_deny})
    public void OnClick(View v){
        Intent intent = null;

        switch (v.getId()){
            case R.id.btn_nomessage :
                break;
            case R.id.btn_only_deny_message :
                break;
            case R.id.btn_only_rationale_message :
                break;
            case R.id.btn_rationale_deny :
                break;
        }

        if(intent != null){
            startActivity(intent);
        }
    }
}
