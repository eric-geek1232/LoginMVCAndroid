package com.example.loginview.Models;

import android.os.Handler;

import com.example.loginview.Listeners.OnLoginFinishedListener;

public class LoginModelImpl implements com.example.loginview.Interfaces.LoginModel {
    @Override
    public void validateCredentials(final OnLoginFinishedListener listener, final String email, final String password) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(email.isEmpty() || password.isEmpty()){
                    listener.onError();
                }else{
                    listener.onSuccess();
                }
            }
        }, 3000);
    }
}
