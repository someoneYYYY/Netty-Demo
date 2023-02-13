package org.example.chat.protocol.request;

import org.example.chat.protocol.Packet;
import org.example.chat.protocol.command.Command;

/**
 * @author tanghuailong
 * @date 2023/2/14
 */
public class LoginRequestPacket extends Packet {

    private String username;
    private String password;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }
}
