package org.notificator;

/**
 * class to format Messages for sending.
 */
public class MessageFormater {
    /**
     * JSON Discord message template.
     */
    private static final String JSON_TEMPLATE= "{\"embeds\": [{"
            + "\"title\": \"%s\","
            + "\"description\": \"%s\","
            + "\"color\": 15258703"
            + "}]}";

    /**
     * Returns formatted Message for Discord as String.
     *
     * @param title of the Message.
     * @param content of the Message.
     *
     * @return formatted discord message
     */
    public static String getFormatedDiscordMessage(String title, String content) {
        return String.format(JSON_TEMPLATE, title, content);
    }}
