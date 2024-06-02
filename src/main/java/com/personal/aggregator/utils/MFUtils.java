package com.personal.aggregator.utils;

import lombok.experimental.UtilityClass;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@UtilityClass
public class MFUtils {

    private MapperFacade mapperFacade;

    private static MapperFacade getMapperFacade(){
        mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();
        return mapperFacade;
    }
    public static <T> T convert(Object source, Class<T> destinationClass){
        return getMapperFacade().map(source, destinationClass);
    }
}
