package com.spring.utility;

import com.spring.constants.StringConstants;

public class StringUtility {

    public static final boolean isStringNullOrEmpty(String paramString) {
        return !(paramString != null && !paramString.equals(StringConstants.EMPTY_STRING));
    }
}
