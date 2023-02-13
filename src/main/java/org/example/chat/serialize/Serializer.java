package org.example.chat.serialize;

import org.example.chat.serialize.impl.JSONSerializer;

/**
 * @author tanghuailong
 */
public interface Serializer {

    Serializer DEFAULT = new JSONSerializer();

    byte getSerializerAlgorithm();

    byte[] serialize(Object object);

    <T> T deserialize(Class<T> clazz, byte[] bytes);
}
