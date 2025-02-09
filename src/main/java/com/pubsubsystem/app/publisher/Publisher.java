package com.pubsubsystem.app.publisher;

import com.pubsubsystem.app.subscriber.Subscriber;
import com.pubsubsystem.model.Message;
import com.pubsubsystem.model.Topic;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Publisher {
    private static Publisher instance;
    private final Map<String, Topic> topicMap;

    private Publisher() {
        this.topicMap = new HashMap<>();
    }

    public static Publisher getInstance() {
        if (Objects.isNull(instance)) {
            instance = new Publisher();
        }
        return instance;
    }

    public void registerTopic(final String topicId) {
        topicMap.put(topicId, new Topic(topicId));
    }

    public void addNewSubscriberToTopic(final String topicId,
                                        final Subscriber subscriber) {
        final Topic topic = topicMap.get(topicId);
        topic.addNewSubscriber(subscriber);
    }

    public void publishMessageToTopic(final String topicId,
                                      final Message message) {
        if(!topicMap.containsKey(topicId)) {
            System.out.println("This publisher can't publish to topic: " + topicId);
            return;
        }
        final Topic topic = topicMap.get(topicId);
        topic.publishMessage(message);
    }
}
