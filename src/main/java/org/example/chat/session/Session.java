package org.example.chat.session;

import lombok.Data;

/**
 * @author: tanghuailong
 * @date: 2023/2/12
 */
@Data
public class Session {

    private String userId;

    private String userName;

    public Session(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return userId + ":" + userName;
    }
}
