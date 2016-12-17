package com.devs.mvpinandroid.model.dao;

import com.devs.mvpinandroid.model.dto.RespObj;
import com.devs.mvpinandroid.model.dto.User;
import com.devs.mvpinandroid.model.idao.IUserDao;

/**
 * Created by ${Deven} on 17/12/16.
 */

public class UserDao implements IUserDao {


    /**
     * Make server request to get login for now we are using hardcoded detail to provide login
     * @param user
     * @return
     */
    @Override
    public RespObj requestLogin(User user) {

        RespObj respObj = new RespObj();

        if(user.getUserName().equals("mvp")
                &&user.getPassword().equals("qwerty")) {
           user.setId("101");
            respObj.setDataObj(user);
            respObj.setSuccess(true);
            respObj.setRespCode("200");
            respObj.setRespMessage("Login Success");
        }
        else {
            respObj.setSuccess(false);
            respObj.setRespCode("200");
            respObj.setRespMessage("Invalid Credential !");
        }

        return respObj;
    }

}
