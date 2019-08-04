package com.example.demo.converter;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;

@Component
public class DateUtilToDateSQLConverter implements Converter<java.util.Date, Date> {

    @Override
    public Date convert(java.util.Date source) {
        return new Date(source.getTime());
    }

	@Override
	public JavaType getInputType(TypeFactory arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaType getOutputType(TypeFactory arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}