package com.github.syr0ws.minelocatorbar.util;

public class ServerVersionNotFoundException extends Exception {

    public ServerVersionNotFoundException(String message) {
        super(message);
    }

    public ServerVersionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
