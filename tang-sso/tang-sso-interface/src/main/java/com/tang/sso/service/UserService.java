package com.tang.sso.service;

public interface UserService {

    String checkData(String data, int type);
    String regist();
    String login(String username,String password);
    String getUserByToken(String token);
}
