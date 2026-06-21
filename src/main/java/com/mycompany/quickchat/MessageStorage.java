/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


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
    
}
