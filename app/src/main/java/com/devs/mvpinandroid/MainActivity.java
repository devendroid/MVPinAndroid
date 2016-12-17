package com.devs.mvpinandroid;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.devs.mvpinandroid.model.dto.RespObj;
import com.devs.mvpinandroid.model.dto.User;
import com.devs.mvpinandroid.presenter.IPresenter;
import com.devs.mvpinandroid.presenter.MainPresenter;

import static com.devs.mvpinandroid.R.id.et_uname;
import static com.devs.mvpinandroid.R.id.tv_status;


/**
 * Created by ${Deven} on 17/12/16.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener, IPresenter {

    private MainPresenter mainPresenter;

    private TextView tvStatus;
    private EditText etUname;
    private EditText etPassword;
    private AppCompatButton btnLogin;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter(this);
        pd = new ProgressDialog(this);

        tvStatus = (TextView) findViewById(tv_status);
        etUname = (EditText) findViewById(et_uname);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (AppCompatButton) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            //Just create new presenter if not exist
            if (mainPresenter == null) mainPresenter = new MainPresenter(this);

            //Call
            String userName = etUname.getText().toString();
            String password = etPassword.getText().toString();
            User user = new User(userName, password);
            mainPresenter.getLogin(user);

        } else {
            Toast.makeText(this, "Internet not found", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSuccess(RespObj respObj) {
        tvStatus.setText(respObj.getRespMessage());
        etUname.setText("");
        etPassword.setText("");
    }

    @Override
    public void onFail(String msg) {
        tvStatus.setText(msg);
    }

    @Override
    public void showLoadingIndicator() {
        if(pd == null) pd = new ProgressDialog(this);
        pd.setMessage("Logging..");
        pd.show();
    }

    @Override
    public void hideLoadingIndicator() {
        pd.cancel();
    }

}
