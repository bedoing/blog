package org.bedoing.util;

import java.util.Collection;

/**
 * Created by ken on 12/7/2016.
 */
public final class CollectionUtils {

    public static <T> boolean isNotEmpty(Collection<T> c) {
        return !org.apache.cxf.common.util.CollectionUtils.isEmpty(c);
    }

    private CollectionUtils(){}
}
