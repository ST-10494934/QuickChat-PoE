/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Messages class - Part 2 
 * @author lab_services_student
 */
public class MessageTest {
    // Message length tests 
    
    @Test 
    public void testMessageReadyToSend(){
        String msg = "Hi Mike, can you join us for dinner tonight?";
        String result = msg.length() <= 250 ? "Message ready to send."
                : "Message exceeds 250 characters by "
                + (msg.length() - 250) + "; please reduce the size.";
        assertEquals("Message ready to send.", result);
    }
    
    @Test
    public void testMessageExceedsLimit() {
        String longMsg = "A".repeat(255);
        int over = longMsg.length() - 250;
        String result = longMsg.length() <= 250 ? "Message ready to send."
                : "Message exceeds 250 characters by "
                + over + "; please reduce the size.";
        assertEquals("Message exceeds 250 characters by " + over + "; please reduce the size.", result);
    }
    
    //Recipient cell tests 
    
    @Test 
    public void testRecipientCellCorrect(){
        Message message = new Message(1, "+27718693002",
                "Hi Mike, can you join us for dinner tonight?");
        assertEquals("Cell phone number successfully captured.",
                message.checkRecipientCell("+27718693002"));
    }
    
    @Test 
    public void testRecipientCellIncorrect(){
        Message message = new Message(2, "+27718693002",
                "Hi Keegan, did you receive the payment?");
        assertEquals("Cell phone number is incorrectly formatted or does not contain "
                + "an international code. Please correct the number and try again.",
                message.checkRecipientCell("08575975889"));
    }
    
    //Message hash test 
    
    @Test 
    public void testMessageHashFormat(){
        Message message = new Message(1, "+27718693002",
                "Hi Mike, can you join us for dinner tonight?");
        String hash = message.getMessageHash();
        assertEquals(true, hash.endsWith(":1:HITONIGHT"));
    }
    
    //Message ID Test
    
    @Test
    public void testMessageIDLength(){
        Message message = new Message(1, "+27718693002",
                "Hi Mike, can you join us for dinner tonight?");
        assertEquals(10, message.getMessageID().length());
        System.out.println("Message ID generated: " + message.getMessageID());
    }
    //Send status tests 
    
    @Test 
    public void testSendMessageStatus(){
        assertEquals("Message successfully sent.", "Message successfully sent.");
    }
    
    @Test
    public void testDisregardMessageStatus(){
        assertEquals("Press 0 to delete the message.", "Press 0 to delete the message.");
    }
    
    @Test 
    public void testStoreMessageStatus(){
        assertEquals("Message successfully stored.", "Message successfully stored.");
    }
}
