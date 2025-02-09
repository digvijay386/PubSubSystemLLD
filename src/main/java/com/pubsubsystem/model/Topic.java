package com.pubsubsystem.model;

import com.pubsubsystem.app.subscriber.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    private final String topicId;
    private final List<Subscriber> subscribers;

    public Topic(final String topicId) {
        this.topicId = topicId;
        this.subscribers = new ArrayList<>();
    }

    public void addNewSubscriber(final Subscriber newSubscriber) {
        this.subscribers.add(newSubscriber);
    }

    public void publishMessage(final Message message) {
        subscribers.forEach(subscriber -> subscriber.onMessage(message));
    }
}
