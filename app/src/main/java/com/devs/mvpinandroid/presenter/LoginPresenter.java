package com.devs.mvpinandroid.presenter;

import android.os.AsyncTask;

import com.devs.mvpinandroid.model.dao.UserDao;
import com.devs.mvpinandroid.model.dto.RespObj;
import com.devs.mvpinandroid.model.dto.User;
import com.devs.mvpinandroid.model.idao.IUserDao;

/**
 * Created by ${Deven} on 17/12/16.
 */

public class LoginPresenter {

    private PresenterListener iPresenter;
    private IUserDao iUserDao;

    public LoginPresenter(PresenterListener iPresenter) {
        this.iPresenter = iPresenter;
        iUserDao = new UserDao();
    }

    public void getLogin(User user ){
        if(isValid(user)) {
            iPresenter.showLoadingIndicator();
            new LoginTask().execute(user);
        }
    }

    // For static validation
    private boolean isValid(User user) {
        if(user.getUserName().equals("")) {
            iPresenter.onFail("User name can't Empty");
            return false;
        }
        else if(user.getPassword().equals("")) {
            iPresenter.onFail("Password can't Empty");
            return false;
        }

        return true;
    }

    private  class LoginTask extends AsyncTask<User,RespObj,RespObj> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected RespObj doInBackground(User... users) {

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return iUserDao.requestLogin(users[0]);
        }

        @Override
        protected void onPostExecute(RespObj mRespObj) {
            super.onPostExecute(mRespObj);
            iPresenter.hideLoadingIndicator();
            if(mRespObj.isSuccess()) {
                iPresenter.onSuccess(mRespObj);
            }
            else {
                iPresenter.onFail(mRespObj.getRespMessage());
            }
        }
    }



}
