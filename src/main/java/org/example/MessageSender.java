package org.example;

import javax.net.ssl.HttpsURLConnection;
import java.io.OutputStream;
import java.net.URL;

/**
 * Class to send Messages
 */
public class MessageSender {
    /**
     * Send discord message over webhook.
     *
     * @param webhook address
     * @param message to send
     */
    public static void sendDiscordMessage(String webhook, Message message) {
        String formattedMessage = MessageFormater
                .getFormatedDiscordMessage(message.title(), message.description());
        try {
            URL url = new URL(webhook);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.addRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            OutputStream stream = con.getOutputStream();
            stream.write(formattedMessage.getBytes());
            stream.flush();
            stream.close();
            con.getInputStream().close();
            con.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
