package com.oguzhantuncer.libraryapienoca.exception;

public class BusinessException extends BaseException{

        public BusinessException(String key) {
            super(key);
        }

        public BusinessException(String key, String... args) {
            super(key, args);
        }


}
