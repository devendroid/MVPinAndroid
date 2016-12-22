package com.devs.mvpinandroid.presenter;

import com.devs.mvpinandroid.model.dto.RespObj;

/**
 * Created by ${Deven} on 17/12/16.
 */

public interface PresenterListener {

    void onSuccess(RespObj respObj);
    void onFail(String msg);
    void showLoadingIndicator();
    void hideLoadingIndicator();
}
