package io.github.noyzys.rdm.core.logging.system;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author: NoyZys on 17:26, 27.10.2020
 **/
public final class LoggerChannel implements Comparable<LoggerChannel> {

    public static final Collection<LoggerChannel> VALUES_CHANNELS = new ArrayList<>();

    private final String channel;
    private final double priority;

    public LoggerChannel(final String channelName, final double priority) {
        this.channel = channelName;
        this.priority = priority;
    }

    @Override
    public int compareTo(@NotNull final LoggerChannel o) {
        return Double.compare(priority, o.priority);
    }

    public String getChannel() {
        return channel;
    }

    public double getPriority() {
        return priority;
    }

    @NotNull
    public static LoggerChannel of(final String channel) {
        for (LoggerChannel valuesChannel : VALUES_CHANNELS) {
            if (valuesChannel.getChannel().equalsIgnoreCase(channel)) {
                return valuesChannel;
            }
        }

        throw new UnsupportedOperationException(channel + " is not supported by default");
    }
}
