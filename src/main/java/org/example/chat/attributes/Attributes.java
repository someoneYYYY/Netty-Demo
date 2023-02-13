package org.example.chat.attributes;

import io.netty.util.AttributeKey;
import org.example.chat.session.Session;

/**
 * @author: tanghuailong
 * @date: 2023/2/12
 */
public class Attributes {

    public static final AttributeKey<Session> SESSION = AttributeKey.newInstance("session");

}
