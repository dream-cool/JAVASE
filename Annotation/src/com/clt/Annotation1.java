package com.clt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value = ElementType.TYPE)
public   @interface  Annotation1{
    String  value();
}
