package com.company;

import Server.TCPServer;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        TCPServer server = new TCPServer();
        server.connectionExpl();
    }
}
