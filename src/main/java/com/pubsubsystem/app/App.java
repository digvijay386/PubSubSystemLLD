package com.pubsubsystem.app;

import com.pubsubsystem.app.publisher.Publisher;
import com.pubsubsystem.app.subscriber.PrintSubscriber;
import com.pubsubsystem.app.subscriber.Subscriber;
import com.pubsubsystem.model.Message;

/**
 * Hello world!
 */
public class App {

    private static final String MESSAGE = "Hello World!";

    public App() {}

    public static void main(String[] args) {
        final String topicId1 = "Topic1";
        final String topicId2 = "Topic2";

        final Publisher publisher1 = Publisher.getInstance();

        publisher1.registerTopic(topicId1);
        publisher1.registerTopic(topicId2);

        final Subscriber subscriber1 = new PrintSubscriber("Subscriber1");
        final Subscriber subscriber2 = new PrintSubscriber("Subscriber2");
        final Subscriber subscriber3 = new PrintSubscriber("Subscriber3");

        publisher1.addNewSubscriberToTopic(topicId1, subscriber1);
        publisher1.addNewSubscriberToTopic(topicId1, subscriber2);
        publisher1.addNewSubscriberToTopic(topicId2, subscriber2);
        publisher1.addNewSubscriberToTopic(topicId2, subscriber3);

        // Publish messages
        publisher1.publishMessageToTopic(topicId1, new Message("Message1 for Topic1"));
        publisher1.publishMessageToTopic(topicId1, new Message("Message2 for Topic1"));

    }

    public String getMessage() {
        return MESSAGE;
    }
}
