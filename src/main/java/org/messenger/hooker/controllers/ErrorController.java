package org.messenger.hooker.controllers;

import com.antkorwin.commonutils.exceptions.BaseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ErrorController extends Throwable {

    @ExceptionHandler(BaseException.class)
    public String exceptionHandler(Exception e) {
        return "asd";
    }
}