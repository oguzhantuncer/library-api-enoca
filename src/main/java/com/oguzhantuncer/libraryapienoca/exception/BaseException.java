package com.oguzhantuncer.libraryapienoca.exception;

import lombok.Getter;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

@Getter
public class BaseException extends RuntimeException {

    private final String key;
    private final String[] args;

    public BaseException(String key) {
        this.key = key;
        this.args = ArrayUtils.EMPTY_STRING_ARRAY;
    }

    public BaseException(String key, String... args) {
        this.key = key;
        this.args = args;
    }

    @Override
    public String getMessage() {
        return "Exception occurred " + key + " " + StringUtils.join(args);
    }
}