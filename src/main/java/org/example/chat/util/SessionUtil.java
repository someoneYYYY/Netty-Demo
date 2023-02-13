package org.example.chat.util;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.util.AttributeKey;
import org.example.chat.attributes.Attributes;
import org.example.chat.session.Session;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: tanghuailong
 * @date: 2023/2/12
 */
public class SessionUtil {

    private static final Map<String, Channel> userIdChannelMap = new ConcurrentHashMap<>();

    private static final Map<String, ChannelGroup> groupIdChannelGroupMap = new ConcurrentHashMap<>();


    public static void bindSession(Session session, Channel channel) {
        userIdChannelMap.put(session.getUserId(), channel);
        channel.attr(Attributes.SESSION).set(session);
    }

    public static void unBindSession(Channel channel) {
        if (hasLogin(channel)) {
            Session session = getSession(channel);
            channel.attr(Attributes.SESSION).set(null);
            userIdChannelMap.remove(session.getUserId());
            System.out.println(session + "退出登陆");
        }
    }

    public static boolean hasLogin(Channel channel) {
        return getSession(channel) != null;
    }

    public static Session getSession(Channel channel) {
        return channel.attr(Attributes.SESSION).get();
    }

    public static Channel getChannel(String userId) {
        return userIdChannelMap.get(userId);
    }






}
