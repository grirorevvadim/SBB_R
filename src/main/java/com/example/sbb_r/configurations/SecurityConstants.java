package com.example.sbb_r.configurations;

import com.example.sbb_r.SpringApplicationContext;

public class SecurityConstants {
    public static final long EXPIRATION_TIME=864000000;
    public static final String TOKEN_PREFIX="Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGH_UP_URL = "/users";

    public static String getTokenSecret(){
        var appProp = (AppProperties) SpringApplicationContext.getBean("AppProperties");
        return appProp.getTokenSecret();
    }
}
