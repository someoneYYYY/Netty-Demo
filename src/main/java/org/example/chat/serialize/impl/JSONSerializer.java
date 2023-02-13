package org.example.chat.serialize.impl;

import com.alibaba.fastjson.JSON;
import org.example.chat.serialize.Serializer;
import org.example.chat.serialize.SerializerAlgorithm;

/**
 * @author : tanghuailong
 */
public class JSONSerializer implements Serializer {


    public byte getSerializerAlgorithm() {
        return SerializerAlgorithm.JSON;
    }

    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}
