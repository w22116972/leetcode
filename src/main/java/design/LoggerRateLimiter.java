package design;

import java.util.HashMap;

public class LoggerRateLimiter {

    HashMap<String, Integer> timestampByMessage;

    public LoggerRateLimiter() {
        this.timestampByMessage = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (this.timestampByMessage.containsKey(message)) {
            if (timestamp < this.timestampByMessage.get(message)) {
                return false;
            } else {
                this.timestampByMessage.put(message, timestamp + 10);
                return true;
            }
        } else {
            this.timestampByMessage.put(message, timestamp + 10);
            return true;
        }
    }
}
