package org.bedoing.vo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Maps;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by ken on 12/7/2016.
 */
public class ErrorDetail implements Serializable {

    private static final long serialVersionUID = -2952002760723099799L;

    @JsonProperty("error_code")
    private String errorCode;

    @JsonProperty("error_description")
    private String errorDescription;

    protected Map<String, Object> extension;

    public ErrorDetail() {
    }

    public ErrorDetail(String errorCode, String errorDescription) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    @JsonAnyGetter
    public Map<String, Object> getExtension() {
        return extension;
    }

    public void setExtension(Map<String, Object> extension) {
        this.extension = extension;
    }

    @JsonAnySetter
    public void setExtension(String name, Object value) {
        if (extension == null) {
            extension = Maps.newHashMap();
        }
        this.extension.put(name, value);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}