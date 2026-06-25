/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for MessageStorage class - Part 3
 *
 * @author Lorenza
 */
public class MessageStorageTest {
    
    private MessageStorage storage;
    
    @BeforeEach
    public void setUp() {
        storage = new MessageStorage();
        
        // Test Data Message 1 - Sent 
        storage.addSentMessage("1234567890", "12:1:DIDCAKE",
                "+27834557896", "Did you get the cake?");
        
        //Test Data Message 2 - Stored
        storage.addStoredMessage ("2345678901", "23:2:WHERETIME"
                "+27838884567",
                "Where are you? You are late! I have asked you to be on time.");
        
        // Test Data Message 3 - Disregarded
        storage.addDisregardedMessage("Yohoooo, I am at your gate.");

        // Test Data Message 4 - Sent
        storage.addSentMessage("3456789012", "34:4:ITTIME",
                "0838884567", "It is dinner time !");

        // Test Data Message 5 - Stored
        storage.addStoredMessage("4567890123", "45:5:OKWITHOUT",
                "+27838884567", "Ok, I am leaving without you.");
    }
    
    // Sent Messages array test 
    
    @Test 
    public void testSentMessagesArrayPopulated(){
        // Test Data: Message 1 and Message 4 are sent 
        String sentMessages = storage.getSentMessages().toString();
        assertEquals(true, sentMessages.contains("Did you get the cake?"));
        assertEquals(true, sentMessages.contains("It is dinner time !"));
    }
    
    // Longest message test 
    public void testFindLongestMessage() {
        // Test Data: Message 2 is the longest 
        assertEquals ("Where are you? You are late! I have asked you to be on time.",
                storage.findLongestMessage());
    }











}
