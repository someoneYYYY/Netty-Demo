package org.example.chat.protocol;

/**
 * @author tanghuailong
 * @date 2023/2/12
 */
public abstract class Packet {

    private Byte version = 1;

    public abstract Byte getCommand();
}
