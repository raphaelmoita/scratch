package com.scratch.app;

import java.nio.file.Files;
import java.nio.file.*;

public class App {

	public void readResourceFile() { 
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            Path platformIndependentPath = Paths.get(classloader.getResource("IN.TXT").toURI());
            System.out.println(new String(Files.readAllBytes(platformIndependentPath)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
    public static void main( String[] args ) {
        new App().readResourceFile();
    }
}
