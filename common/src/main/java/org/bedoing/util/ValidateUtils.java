package org.bedoing.util;

import org.apache.commons.lang3.StringUtils;
import org.bedoing.constant.ErrorDescriptionConstant;
import org.bedoing.constant.ServiceErrorCode;
import org.bedoing.constant.TableAttrConstant;
import org.bedoing.exception.ServiceException;
import org.bedoing.vo.ErrorDetail;

import static javax.ws.rs.core.Response.*;

/**
 * Created by ken on 12/7/2016.
 */
public class ValidateUtils {

    public static void validateRequestParameterIsRequired(String paramKey, String paramValue) {
        if (StringUtils.isBlank(paramValue)) {
            String description = String.format(ErrorDescriptionConstant.MISSING_PARAM, paramKey);
            throw new ServiceException(Status.BAD_REQUEST, new ErrorDetail(ServiceErrorCode.invalid_request.name(), description));
        }
    }

    public static void validateRequestParameterIsRequired(String paramKey, Integer paramValue) {
        if (paramValue == null) {
            String description = String.format(ErrorDescriptionConstant.MISSING_PARAM, paramKey);
            throw new ServiceException(Status.BAD_REQUEST, new ErrorDetail(ServiceErrorCode.invalid_request.name(), description));
        }
    }

    public static void validateRequestParameterIsRequired(String paramKey, Object paramValue) {
        if (paramValue == null) {
            String description = String.format(ErrorDescriptionConstant.MISSING_PARAM, paramKey);
            throw new ServiceException(Status.BAD_REQUEST, new ErrorDetail(ServiceErrorCode.invalid_request.name(), description));
        }
    }

    public static void validateObject(String key, Object obj) {
        validateRequestParameterIsRequired(key, obj);
    }

    public static void validateId(Integer id) {
        validateRequestParameterIsRequired(TableAttrConstant.ID, id);
    }

    public static void validateArticleId(Integer articleId) {
        validateRequestParameterIsRequired(TableAttrConstant.ARTICLE_ID, articleId);
    }

    public static void validateTagName(String tagName) {
        validateRequestParameterIsRequired(TableAttrConstant.TAG_NAME, tagName);
    }

    public static void recordNotExistException(String objectName, String... key) {

        String description = String.format(ErrorDescriptionConstant.RECORD_NOT_EXIST, objectName,
                StringUtils.join(key, ","));
        ErrorDetail errorDetail = new ErrorDetail(ServiceErrorCode.not_found.name(), description);
        throw new ServiceException(Status.NOT_FOUND, errorDetail);
    }

    private ValidateUtils(){}
}
