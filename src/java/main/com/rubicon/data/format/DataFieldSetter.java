package com.rubicon.data.format;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.rubicon.data.types.DataType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DataFieldSetter {
	public String name();

	public int version();

	public Class<? extends DataType> type();

}
