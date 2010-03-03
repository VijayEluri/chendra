package com.rubicon.data.io;

import com.rubicon.data.format.DataFieldGetter;
import com.rubicon.data.format.DataFieldSetter;
import com.rubicon.data.format.DataFormat;
import com.rubicon.data.types.LongArrayType;
import com.rubicon.data.util.ListUtils;

public class LongArrayDataFormat implements DataFormat {
	private static String separator = ",";

	private long[] values;

	public LongArrayDataFormat() {
		values = new long[0];
	}

	public LongArrayDataFormat(long[] values) {
		this.values = values;
	}

	@DataFieldGetter(name = "values", type = LongArrayType.class)
	public long[] getValues() {
		return values;
	}

	@DataFieldSetter(name = "values", type = LongArrayType.class)
	public void setValues(long[] values) {
		this.values = values;
	}

	public String toString() {
		return ListUtils.join(separator, values);
	}
}
