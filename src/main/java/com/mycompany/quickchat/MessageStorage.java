/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


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
    
    /**
     * Reads stored messages from the JSON file into the JSON file into the storedMessages array
     * Reference: Gson library by Google - https://github.com/google/gson
     */
    public void loadStoredMessagesFromJSON(){
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(JSON_FILE)){
            Type listType = new TypeToken<List<Message.MessageData>>() {}.getType();
            List<Message.MessageData> stored = gson.fromJson(reader, listType);
            if (stored != null){
            for (Message.MessageData data : stored){
                storedMessages.add(data.messageText);
                storedRecipients.add(data.recipient);
                messageHashes.add(data.messageHash);
                messageIDs.add(data.messageID);
            }
        }
        }catch (IOException e) {
            System.out.println("No stored messages found.");
        }
    }
    
    /**
     * Display the recipient of all stored messages 
     * 
     * @return formatted string of all stored message recipients and messages 
     */
    public String displayStoredMessages(){
        if (storedMessages.isEmpty()){
           return "No stored messages found."; 
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\n===STORED MESSAGES ===\n");
        for (int i = 0; i < storedMessages.size(); i++) {
            sb.append("Recipient: ").append(storedRecipients.get(i)).append("\n");
            sb.append("Message: ").append(storedMessages.get(i)).append("\n");
            sb.append("---\n");
        }
        return sb.toString();
    }
    
    /**
     * Finds and returns the longest message across all arrays
     * 
     * @return the longest message test 
     */
    public String findLongestMessage() {
        String longest = ""; 
        //Check sent messages
        for (String msg : sentMessages) {
            if (msg.length() > longest.length()) {
                longest = msg;
            }
        }
        //Check stored messages
        for (String msg : storedMessages){
            if (msg.length() > longest.length()){
                longest = msg;
            }
        }
        return longest.isEmpty() ? "No message found." : longest;
    }














}

