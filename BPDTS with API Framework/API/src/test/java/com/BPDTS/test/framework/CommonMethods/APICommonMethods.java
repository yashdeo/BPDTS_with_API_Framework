package com.BPDTS.test.framework.CommonMethods;

import io.restassured.response.Response;

public class APICommonMethods {

    public static int extractStatusCode(Response response){
        return response.getStatusCode();
    }


    public static boolean compareMessage(Response response, String message){
        return response.body().asString().contains(message);
    }

    public static String getContentType(Response response){
        return response.headers().get("Content-Type").toString();
    }

    public static String getConnection(Response response){
        return response.headers().get("Connection").toString();
    }

    public static String getServer(Response response){
        return response.headers().get("Server").toString();
    }

    public static String getVia(Response response){
        return response.headers().get("Via").toString();
    }

    public static String getErrorMessage(Response response){
        return response.body().prettyPeek().toString();
    }


/*

    public static boolean validateHeaders(Response response){
        boolean correctHeader = false;

        if(response.headers().get("Content-Length").toString().contains("Content-Length=3")) ;

    }*/

}
