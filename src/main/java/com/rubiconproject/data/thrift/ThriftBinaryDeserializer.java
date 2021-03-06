package com.rubiconproject.data.thrift;

import java.io.IOException;
import java.io.InputStream;

import org.apache.hadoop.io.serializer.Deserializer;
import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TIOStreamTransport;
import org.apache.thrift.transport.TTransport;

public class ThriftBinaryDeserializer<T extends TBase> implements
		Deserializer<T> {

	private Class<T> cls;

	private InputStream in;

	private TTransport transport;

	private TProtocol proto;

	public ThriftBinaryDeserializer(Class<T> cls) {
		this.cls = cls;
	}

	public void open(InputStream in) throws IOException {
		this.in = in;
		this.transport = new TIOStreamTransport(in);
		this.proto = new TBinaryProtocol(transport);
	}

	public T deserialize(T obj) throws IOException {
		try {
			if (obj == null) {
				obj = cls.newInstance();
			}
			obj.read(this.proto);
			return obj;
		} catch (TException e) {
			e.printStackTrace();
			throw new IOException(e);
		} catch (InstantiationException e) {
			throw new IOException(e);
		} catch (IllegalAccessException e) {
			throw new IOException(e);
		} finally {
		}
	}

	public void close() throws IOException {
		this.transport.close();
		this.transport = null;
		this.proto = null;
	}

}
