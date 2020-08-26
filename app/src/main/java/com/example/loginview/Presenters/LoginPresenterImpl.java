package com.example.loginview.Presenters;

import com.example.loginview.Interfaces.LoginModel;
import com.example.loginview.Interfaces.LoginView;
import com.example.loginview.Listeners.OnLoginFinishedListener;
import com.example.loginview.Models.LoginModelImpl;

public class LoginPresenterImpl implements com.example.loginview.Interfaces.LoginPresenter, OnLoginFinishedListener {
    private LoginView view;
    private LoginModel loginModel;

    public LoginPresenterImpl(LoginView view){
        this.view = view;
        this.loginModel = new LoginModelImpl();
    }
    @Override
    public void sendCredentials(String email, String password) {
        if(view != null) {
            view.showProgressBar();
            loginModel.validateCredentials(this, email, password);
        }
    }

    @Override
    public void onSuccess() {
        if(view != null){
            view.hideProgressBar();
            view.accessSuccessful();
        }
    }

    @Override
    public void onError() {
        if(view != null){
            view.hideProgressBar();
            view.accessDenied();
        }
    }
}
