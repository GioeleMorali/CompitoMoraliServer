package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread{
    Socket s;
    public ServerThread(Socket s)
    {
        this.s = s;
    }
    ArrayList <String> note = new ArrayList<>();
    @Override
    public void run(){
        try {
            System.out.println("Server avviato");
            System.out.println("Un client si è connesso");
            BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream output = new DataOutputStream(s.getOutputStream());
            String readline;
            Boolean esci = false;
            do {
                readline = input.readLine();
                 if (readline.equals("@")) {
                    output.writeBytes(note.toString() + '\n');
                 }
                 else if(readline.equals("ESCI"))
                 {
                    esci = true;
                 }
                 else if (!readline.equals("")) {
                     note.add(readline);
                 }
            } while (!esci);
            output.writeBytes("ESCI" + '\n');
            s.close();
            System.out.println("ESCI");
        } catch (Exception e) {
            System.out.println("ESCI");
        }
    }
}
