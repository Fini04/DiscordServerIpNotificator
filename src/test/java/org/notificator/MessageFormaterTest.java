package org.notificator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageFormaterTest {

    private static final String JSON_Expected = "{\"embeds\": [{"
            + "\"title\": \"Title\","
            + "\"description\": \"Content\","
            + "\"color\": 15258703"
            + "}]}";

    @Test
    void getFormatedDiscordMessage() {
        String result = MessageFormater.getFormatedDiscordMessage("Title", "Content");
        assertEquals(JSON_Expected, result);
    }
}