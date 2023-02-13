package org.example.chat.client.console;

import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author tanghuailong
 * @date 2023/2/12
 */
public interface ConsoleCommand {

    void exec(Scanner scanner, Channel channel);
}
