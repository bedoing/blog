package org.bedoing.constant;

/**
 * Created by ken on 12/7/2016.
 */
public class ErrorDescriptionConstant {
    public static final String MISSING_PARAM = "parameter %s is empty or null";
    public static final String INVALID_PARAM = "parameter %s is invalid";
    public static final String NOT_ALLOWED_PARAM = "parameter %s value not allowed";
    public static final String MISMATCH_PARAM = "parameter %s mismatch";
    public static final String PARAM_DUPLICATE = "parameter %s duplicate";
    public static final String RESOURCE_NOT_EXIST = "parameter %s is not exist";
    public static final String RECORD_NOT_EXIST = "record of %s through %s not exist";
    public static final String RECORD_NOT_EXIST2 = "record of %s through %s,%s not exist";
    public static final String RECORD_ALREADY_EXIST = "record of %s through %s already exist";
    public static final String RECORD_ALREADY_EXIST2 = "record of %s through %s,%s already exist";
    public static final String INTERNAL_SERVER_ERROR = "Internal server error.";

    private ErrorDescriptionConstant(){}
}
