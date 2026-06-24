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
        } catch (IOException e) {
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
/**
 * Searches for a message by ID and returns the recipient and message
 * 
 * @param messageID the message ID to search for 
 * @return the recipient and message to text or error message 
 */
public String searchByMessageID(String messageID){
    for (int i = 0; i < messageIDs.size(); i++) {
        if (messageIDs.get(i).equals(messageID)) { 
            return "Recipient: " + getRecipientByIndex(i)
                    + "\nMessage: " + getMessageByIndex(i);
        }
    }
    return "Message ID not found";
}    

/**
 * Searches for all the messages sent or stored for a particular recipient 
 * 
 * @param recipient the recipient cell number to search for 
 * @return all messages for the recipient 
 */
public String searchByRecipient(String recipient) {
    StringBuilder sb = new StringBuilder();
    //Search sent message 
    for (int i = 0; i < sentRecipients.size(); i++){
        if (sentRecipients.get(i).equals(recipient)) {
            sb.append("Message: ").append(sentMessages.get(i)).append("\n");
        }
    }
    // Search stored messages
    for (int i = 0; i < storedRecipients.size(); i++) {
        if (storedRecipients.get(i).equals(recipient)) {
            sb.append("Message: ").append(storedMessages.get(i)).append("\n");
        }
    }
    return sb.length() == 0 ? "No messages found for this recipient." : sb.toString();
}    

/**
 * Deletes a message using the message hash 
 * 
 * @param messageHash the hash of the message to delete 
 * @return confirmation or error message 
 */
public String deleteMessageByHash(String messageHash) {
    for (int i = 0; i < messageHashes.size(); i++) {
        if (messageHashes.get(i).equals(messageHash)) {
            String deletedMessage =getMessageByIndex(i);
            //Remove from all arrays 
            messageHashes.remove(i);
            messageIDs.remove(i);
            // Try to remove from sent or stored 
            if (i < sentMessages.size()) {
                sentMessages.remove(i);
                sentRecipients.remove(i);
            } else {
                int storedIndex = i - sentMessages.size();
                if (storedIndex < storedMessages.size()) {
                    storedMessages.remove(storedIndex);
                    storedRecipients.remove(storedIndex);
                }
            }
            return "Message: \"" + deleteMessage + "\" successfully deleted.";
        }
    }
    return "Message hash not found.";
}

/**
 * Display a full report of all sent messages 
 * 
 * @return formatted report string 
 */
public String displayReport() {
    if(sentMessages.isEmpty() && storedMessages.isEmpty()){
        return "No message to display";
    }
    StringBuilder sb = new StringBuilder();
    sb.append("\n=== MESSAGE REPORT ===\n");
    
    //Sent messages
    sb.append("\n--- Sent Messages ---\n");
    for (int i = 0; i < sentMessages.size(); i++) {
        sb.append("Message Hash: ").append(messageHashes.get(i)).append("\n");
        sb.append("Recipient: ").append(sentRecipients.get(i)).append("\n");
        sb.append("Message: ").append(sentMessages.get(i)).append("\n");
        sb.append("---\n");
    }
    
    //Stored messages 
    sb.append("\n---Stored Messages ---\n");
    for (int i = 0; i < storedMessages.size(); i++) {
        sb.append("Recipient: ").append(storedRecipients.get(i)).append("\n");
        sb.append("Message: ").append(storedMessages.get(i)).append("\n");
        sb.append("---\n");
    }
    return sb.toString();
}

/**
 * Helper method to get recipient by index across all arrays 
 */
private String getRecipientByIndex(int index) {
    if (index < sentRecipients.size()) {
        return sentRecipients.get(index);
    }
    int storedIndex = index - sentRecipients.size();
    if (storedIndex < storedRecipients.size()) {
        return storedRecipients.get(storedIndex);
    }
    return "Unknown";
}

/**
 * Helper method to get message by index across all arrays 
 */
private String getMessageByIndex(int index) {
    if (storedIndex < sentMessages.size()) {
        return storedMessages.get(storedIndex);
    }
    return "Unknown";
}










}

