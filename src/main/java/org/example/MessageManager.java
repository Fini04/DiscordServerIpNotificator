package org.example;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * class for Managing messages.
 */
public class MessageManager {
    /**
     * Title of me ip notification message.
     */
    private static final String IP_MESSAGE_TITLE = "Current server IP address";
    /**
     * Title of me ip startup message.
     */
    private static final String STARTUP_MESSAGE_TITLE = "Server ip notificator started";
    /**
     * Message for Program startup.
     */
    private static final Message STARTUP_MESSAGE =
            new Message(STARTUP_MESSAGE_TITLE, "version: " + Main.VERSION);
    /**
     * Timer to schedule message interval
     */
    private static final Timer timer = new Timer();
    /**
     * last ip for comparison.
     */
    private static String oldIp = "";

    /**
     * Constructor.
     *
     * @param url webhook address
     * @param interval refreshing interval
     */
    public MessageManager(String url, int interval) {
        MessageSender.sendDiscordMessage(url, STARTUP_MESSAGE);

        TimerTask ipMessage = new TimerTask() {
            public void run() {
                String ip;
                try {
                    ip = IpChecker.getIp();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (!oldIp.equals(ip)) {
                    Message ipMessage = new Message(IP_MESSAGE_TITLE, ip);
                    MessageSender.sendDiscordMessage(url, ipMessage);
                    oldIp = ip;
                }
            }
        };
        timer.schedule(ipMessage, 0, interval);
    }
}
