package org.example.chat.protocol;

import io.netty.buffer.ByteBuf;
import org.example.chat.protocol.request.LoginRequestPacket;
import org.example.chat.serialize.Serializer;
import org.example.chat.serialize.impl.JSONSerializer;

import java.util.HashMap;
import java.util.Map;

import static org.example.chat.protocol.command.Command.*;

/**
 * @author tanghuailong
 * @date 2023/2/12
 */
public class PacketCodeC {

    public static final int MAGIC_NUMBER = 0x123456;

    public static final PacketCodeC INSTANCE = new PacketCodeC();

    private final Map<Byte, Class<? extends Packet>> packetTypeMap;

    private final Map<Byte, Serializer> serializerMap;

    private PacketCodeC() {
        packetTypeMap = new HashMap<>();
        packetTypeMap.put(LOGIN_REQUEST, LoginRequestPacket.class);
//        packetTypeMap.put(LOGIN_RESPONSE, LoginResponsePacket.class);
//        packetTypeMap.put(MESSAGE_REQUEST, MessageRequestPacket.class);
//        packetTypeMap.put(MESSAGE_RESPONSE, MessageResponsePacket.class);
//        packetTypeMap.put(LOGOUT_REQUEST, LogoutRequestPacket.class);
//        packetTypeMap.put(LOGOUT_RESPONSE, LogoutResponsePacket.class);
//        packetTypeMap.put(CREATE_GROUP_REQUEST, CreateGroupRequestPacket.class);
//        packetTypeMap.put(CREATE_GROUP_RESPONSE, CreateGroupResponsePacket.class);
        serializerMap = new HashMap<>();

        Serializer serializer = new JSONSerializer();
        serializerMap.put(serializer.getSerializerAlgorithm(), serializer);
    }


    public void encode(ByteBuf byteBuf, Packet packet) {
        byte[] bytes = Serializer.DEFAULT.serialize(packet);

        byteBuf.writeInt(MAGIC_NUMBER);

    }

    public Packet decode(ByteBuf byteBuf) {
        // 跳过 magic number
        byteBuf.skipBytes(4);

        // 跳过版本号
        byteBuf.skipBytes(1);

        // 序列化算法
        byte serializeAlgorithm = byteBuf.readByte();

        // 指令
        byte command = byteBuf.readByte();

        // 数据包长度
        int length = byteBuf.readInt();

        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);

        Class<? extends Packet> requestType = getRequestType(command);
        Serializer serializer = getSerializer(serializeAlgorithm);

        if (requestType != null && serializer != null) {
            return serializer.deserialize(requestType, bytes);
        }

        return null;
    }

    private Serializer getSerializer(byte serializerAlgorithm) {
        return serializerMap.get(serializerAlgorithm);
    }

    private Class<? extends Packet> getRequestType(byte command) {
        return packetTypeMap.get(command);
    }
}
