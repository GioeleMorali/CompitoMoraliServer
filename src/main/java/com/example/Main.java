package com.example;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket socketS = new ServerSocket(6000);
            while (true) {
                Socket s = socketS.accept();
                ServerThread sThread = new ServerThread(s);
                sThread.start();
            }
        } catch (Exception e) {
           System.out.println("Errore");
        }
        
    }
}