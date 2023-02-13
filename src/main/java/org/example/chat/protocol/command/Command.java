package org.example.chat.protocol.command;

/**
 * @author tanghuailong
 * @date 2023/2/14
 */
public class Command {

    public static final Byte LOGIN_REQUEST = 1;

    public static final Byte LOGIN_RESPONSE = 2;

    public static final Byte MESSAGE_REQUEST = 3;

    public static final Byte MESSAGE_RESPONSE = 4;

    public static final Byte LOGOUT_REQUEST = 5;

    public static final Byte LOGOUT_RESPONSE = 6;

    public static final Byte CREATE_GROUP_REQUEST = 7;

    public static final Byte CREATE_GROUP_RESPONSE = 8;
}
