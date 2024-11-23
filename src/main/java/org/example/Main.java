package org.example;

/**
 * Main class
 * validate provided parameters and start up the program.
 *
 * @version {@value VERSION}
 */
public class Main {
    public final static String VERSION = "0.1";

    /**
     * private constructor to make Main a Singleton.
     */
    private Main() { }

    /**
     * Main function gets executed at program start.
     *
     * @param args 1: webhook address
     *             2: refresh interval
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("You need to add to parameters (webhook link) (Interval in seconds)");
            System.exit(1);
            return;
        }
        String webhook = args[0];

        int interval;
        try {
            interval = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("Interval needs to be whole numbers.");
            System.exit(1);
            return;
        }

        System.out.println("Starting program.");
        new MessageManager(webhook, interval);
    }
}