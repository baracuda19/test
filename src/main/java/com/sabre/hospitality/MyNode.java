package com.sabre.hospitality;

import java.io.IOException;
import java.util.Arrays;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.node.ValueNode;

public class MyNode extends ValueNode {
	byte[] bytes;

	public MyNode(byte[] bytes) {
		this.bytes = bytes;
	}

	public JsonToken asToken() {
		return JsonToken.VALUE_EMBEDDED_OBJECT;
	}

	public boolean isPojo() {
		return false;
	}

	public byte[] getBinaryValue() throws IOException {
		return bytes;
	}

	public String asText() {
		try {
			return new String(bytes, "UTF-8");
		} catch (Exception ex) {
			return "";
		}

	}

	public boolean asBoolean(boolean defaultValue) {
		return defaultValue;
	}

	public int asInt(int defaultValue) {
		return defaultValue;
	}

	public long asLong(long defaultValue) {
		return defaultValue;
	}

	public double asDouble(double defaultValue) {
		return defaultValue;
	}

	public final void serialize(JsonGenerator jg, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		jg.writeRawValue(new String(bytes, "UTF-8"), 0, bytes.length);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(bytes);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyNode other = (MyNode) obj;
		if (!Arrays.equals(bytes, other.bytes))
			return false;
		return true;
	}

}
