package com.blockchainmarty.TwitterAutoBot;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.io.*;
import java.nio.charset.Charset;


public class TwitterAutoBot {


    public static void main(String[] args) {
        tweetLines();
    }


    private static void tweetLines() {
    	
    	
    	
    	//WeatherDoc doc = new WeatherDoc("2347579", "f");
    	//WeatherDisplay disp = new WeatherDisplay();
    	
    	//String temperature = disp.getTemperature();
    	//System.out.println(temperature);
        String line;
        try {
            try (
            		InputStream fis = new FileInputStream("C:/Users/Dalton/workspace/TwitterAutoBot/src/main/java/tweets.txt");
            		
                    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("Cp1252"));
                    BufferedReader br = new BufferedReader(isr);
            ) {
                while ((line = br.readLine()) != null) {
                	//line = line+temperature;
                	
                    // Deal with the line
                   sendTweet(line);
                    System.out.println("Tweeting: " + line + "...");

                    try {
                        System.out.println("Sleeping for 30 minutes...");
                        Thread.sleep(1800000); // every 30 minutes
                        // Thread.sleep(10000); // every 10 seconds
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static void sendTweet(String line) {
        Twitter twitter = TwitterFactory.getSingleton();
        Status status;
        try {
            status = twitter.updateStatus(line);
            System.out.println(status);
        } catch (TwitterException e) {;
            e.printStackTrace();
        }
    }


}