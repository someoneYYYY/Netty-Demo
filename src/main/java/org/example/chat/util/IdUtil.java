package org.example.chat.util;

import java.util.UUID;

/**
 * @author tanghuailong
 */
public class IdUtil {


    public static String randomId() {
        return UUID.randomUUID().toString().split("-")[0];
    }
}
