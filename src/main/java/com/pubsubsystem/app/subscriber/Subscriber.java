package com.pubsubsystem.app.subscriber;

import com.pubsubsystem.model.Message;

public interface Subscriber {
    void onMessage(final Message message);
}
