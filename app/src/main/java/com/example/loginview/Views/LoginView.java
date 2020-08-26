package com.example.loginview.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.loginview.Interfaces.LoginPresenter;
import com.example.loginview.Presenters.LoginPresenterImpl;
import com.example.loginview.R;

public class LoginView extends AppCompatActivity implements com.example.loginview.Interfaces.LoginView {
    private ProgressBar bar;
    private EditText passwordEdt, emailEdt;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bar = findViewById(R.id.progress_circular);
        passwordEdt = findViewById(R.id.password_edt);
        emailEdt = findViewById(R.id.email_edt);
        presenter = new LoginPresenterImpl(this);
    }

    public void login(View view){
        presenter.sendCredentials(emailEdt.getText().toString(), passwordEdt.getText().toString());
    }

    @Override
    public void hideProgressBar() {
        bar.setVisibility(View.GONE);
    }

    @Override
    public void showProgressBar() {
        bar.setVisibility(View.VISIBLE);
    }

    @Override
    public void accessSuccessful() {
        Toast.makeText(this, "Access OK", Toast.LENGTH_LONG).show();
    }

    @Override
    public void accessDenied() {
        Toast.makeText(this, "Access Denied", Toast.LENGTH_LONG).show();
    }
}