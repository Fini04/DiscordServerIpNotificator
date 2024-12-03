package org.notificator;

import javax.net.ssl.HttpsURLConnection;
import java.io.OutputStream;
import java.net.URI;

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
            URI url = new URI(webhook);
            HttpsURLConnection con = (HttpsURLConnection) url.toURL().openConnection();
            con.addRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            OutputStream stream = con.getOutputStream();
            stream.write(formattedMessage.getBytes());
            stream.flush();
            stream.close();
            con.getInputStream().close();
            con.disconnect();
            System.out.println("Message send to " + webhook);
        } catch (Exception e) {
            System.err.println("Sending Message to " + webhook + " failed");
            System.err.println(e.getMessage());
        }
    }
}
