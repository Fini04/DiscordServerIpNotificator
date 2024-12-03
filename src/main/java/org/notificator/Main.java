package org.notificator;

import org.apache.commons.lang.NumberUtils;

import java.util.Arrays;

/**
 * Main class
 * validate provided parameters and start up the program.
 *
 * @version {@value VERSION}
 */
public class Main {
    public final static String VERSION = "0.2";

    /**
     * private constructor to make Main a Singleton.
     */
    private Main() { }

    /**
     * Main function gets executed at program start
     *
     * @param args 1: webhook address
     *             2: refresh interval
     */
    public static void main(String[] args) {
        if (!(validParameterAmount(args) && validTimeInterval(args))) {
            System.exit(1);
            return;
        }

        String[] webhooks = new String[args.length - 1];
        System.arraycopy(args, 0, webhooks, 0, webhooks.length);
        int interval = Integer.parseInt(args[args.length - 1]);

        printStartMessage(args);
        new MessageManager(webhooks, interval);
    }

    private static void printStartMessage(String[] parameters) {
        String[] webhooks = new String[parameters.length - 1];
        System.arraycopy(parameters, 0, webhooks, 0, webhooks.length);

        String interval = parameters[parameters.length - 1];


        System.out.println("Program started");
        System.out.println("Version: " + VERSION);
        System.out.printf("Update Interval: %s seconds%n", interval);
        System.out.println("Webhooks: " + Arrays.toString(webhooks));
    }

    private static boolean validTimeInterval(String[] parameters) {
        if (NumberUtils.isNumber(parameters[parameters.length - 1])) {
            return true;
        }
        System.err.println("Interval could not be converted to integer");
        return false;
    }

    private static boolean validParameterAmount(String[] parameters) {
        if (parameters.length >= 2) {
            return true;
        }
        System.err.println("You need to add minimal two parameters (webhook link) and (Interval in seconds)");
        return false;
    }

}