package com.pubsubsystem.model;

public class Message {
    private final String content;

    public Message(final String content) {
        this.content = content;
    }

    public String getMessageContent() {
        return this.content;
    }
}
