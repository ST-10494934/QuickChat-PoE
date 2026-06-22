/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;


/**
 * MessageStorage class for QuickChat - Part 3 
 * Handles all arrays and operations on stored, sent and disregarded messages 
 * Gson libary by Google used for JSON reading: https://github.com/google/gson 
 * @author Lorenza 
 */
public class MessageStorage {
    
    // Arrays 
    private ArrayList<String> sentMessages = new ArrayList<>();
    private ArrayList<String> disregardedMessages = new ArrayList<>();
    private ArrayList<String> storedMessages = new ArrayList<>(); 
    private ArrayList<String> messageHashes = new ArrayList<>();
    private ArrayList<String> messageIDs = new ArrayList<>();
    
    // Parallel arrays for recipients 
    private ArrayList<String> sentRecipients = new ArrayList<>();
    private ArrayList<String> storedRecipients = new ArrayList<>();
    
    // JSON file path 
    private static final String JSON_FILE = "stored_message.json";
    
    /**
     * Adds a sent message to the sent arrays
     * 
     * @param messageID the message ID
     * @param messageHash the message hash 
     * @param recipient the recipient cell number 
     * @param messageText the message text 
     */
    public void addSentMessage(String messageID, String messageHash,
            String recipient, String messageText){
        sentMessages.add(messageText);
        sentRecipients.add(recipient);
        messageHashes.add(messageHash);
        messageIDs.add(messageID);
    }
    
    /**
     * Adds a disregarded message to the disregarded array
     * 
     * @param messageText the message text 
     */
    public void addDisregardedMessage(String messageText){
        disregardedMessages.add(messageText);
    }
    
}
