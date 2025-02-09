package com.pubsubsystem.app.subscriber;

import com.pubsubsystem.model.Message;

public class PrintSubscriber implements Subscriber {
    private final String subscriberId;

    public PrintSubscriber(final String subscriberId) {
        this.subscriberId = subscriberId;
    }

    @Override
    public void onMessage(final Message message) {
        System.out.println("Received message: " + message.getMessageContent() + " [SubscriberId]: " + subscriberId);
    }
}
