package com.labskeleton.kuzmenko.model;

import java.util.Base64;

public class Constants {

    public static final String BASIC_AUTH = "Basic";
    public static final String BEARER = "Bearer";
    public static final String KEY_SIGNATURE = "random_secret_key";
    public static final String TOKEN_USER_ID_CLAIM = "userId";
    public static final String TOKEN_ROLES_CLAIM = "role";

    public static byte[] key = Base64.getEncoder().encode(Constants.KEY_SIGNATURE.getBytes());

}

