package com.example.loginview.Interfaces;

import com.example.loginview.Listeners.OnLoginFinishedListener;

public interface LoginModel {
    void validateCredentials(OnLoginFinishedListener listener, String email, String password);
}
