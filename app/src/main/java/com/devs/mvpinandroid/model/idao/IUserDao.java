package com.devs.mvpinandroid.model.idao;

import com.devs.mvpinandroid.model.dto.RespObj;
import com.devs.mvpinandroid.model.dto.User;

/**
 * Created by ${Deven} on 17/12/16.
 */

public interface IUserDao {

    RespObj requestLogin(User user);
}
