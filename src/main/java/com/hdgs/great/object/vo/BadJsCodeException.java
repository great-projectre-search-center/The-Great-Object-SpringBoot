package com.hdgs.great.object.vo;

import org.springframework.security.core.AuthenticationException;

/**
 * jscode异常
 */
public class BadJsCodeException extends AuthenticationException {
    public BadJsCodeException(String msg) {
        super(msg);
    }

    public BadJsCodeException(String msg, Throwable t) {
        super(msg, t);
    }
}
