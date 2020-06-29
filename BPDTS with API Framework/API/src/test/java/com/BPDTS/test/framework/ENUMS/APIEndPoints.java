package com.BPDTS.test.framework.ENUMS;

public enum APIEndPoints {

    CITY_NAME("/city/{city_name}/users"),
    INSTRUCTIONS("/instructions"),
    USER_ID("/user/{user_id}"),
    ALL_USERS("/users");

    private String url;

    private APIEndPoints(String url) {
        this.url = url;
    }
    public String getUrl(){
        return url;
    }
}
