package com.rubicon.data.io;

import com.rubicon.data.format.DataFieldGetter;
import com.rubicon.data.format.DataFieldSetter;
import com.rubicon.data.format.DataFormat;
import com.rubicon.data.types.StringType;

public class StringDataFormat implements DataFormat {

	private static final int VERSION = 1;

	private String text = "";

	public StringDataFormat() {
	}

	public StringDataFormat(String text) {
		this.text = text;
	}

	@DataFieldGetter(name = "text", version = 1, type = StringType.class)
	public String getText() {
		return text;
	}

	@DataFieldSetter(name = "text", version = 1, type = StringType.class)
	public void setText(String text) {
		this.text = text;
	}

	public int version() {
		return VERSION;
	}

	public String toString() {
		return this.text;
	}
}
