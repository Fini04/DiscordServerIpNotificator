package org.notificator;

/**
 * Record for holding message data.
 *
 * @param title Message title
 * @param description Content of the message.
 */
public record Message(String title, String description) {
}
