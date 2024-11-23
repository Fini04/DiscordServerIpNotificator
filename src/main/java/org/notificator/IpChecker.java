package org.notificator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Class for receiving current device id.
 */
public class IpChecker {

    /**
     * Returns the current ipv4 of the device.
     * 
     * @return ipv4 address as string
     *
     * @throws IOException something went wrong
     */
    public static String getIp() throws IOException {
        URL whatismyip = new URL("http://checkip.amazonaws.com");
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));
            String ip = in.readLine();
            return ip;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Couldn't close the input stream");
                }
            }
        }
    }
}