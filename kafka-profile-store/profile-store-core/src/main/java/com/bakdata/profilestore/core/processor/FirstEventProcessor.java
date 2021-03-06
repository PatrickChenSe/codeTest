package com.bakdata.profilestore.core.processor;

import com.bakdata.profilestore.common.avro.ListeningEvent;
import com.bakdata.profilestore.core.ProfileStoreMain;
import com.bakdata.profilestore.core.avro.UserProfile;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;

public class FirstEventProcessor implements Processor<Long, ListeningEvent> {
    private KeyValueStore<Long, UserProfile> profileStore;

    @Override
    public void init(final ProcessorContext processorContext) {
        this.profileStore =
                (KeyValueStore<Long, UserProfile>) processorContext.getStateStore(ProfileStoreMain.PROFILE_STORE_NAME);
    }

    @Override
    public void process(final Long userId, final ListeningEvent listeningEvent) {
        final UserProfile profile = DefaultUserProfile.getOrDefault(this.profileStore.get(userId));
        if (profile.getEventCount() == 0
                || profile.getFirstListeningEvent().compareTo(listeningEvent.getTimestamp()) > 0) {
            profile.setFirstListeningEvent(listeningEvent.getTimestamp());
        }
        this.profileStore.put(userId, profile);
    }

    @Override
    public void close() {

    }
}
