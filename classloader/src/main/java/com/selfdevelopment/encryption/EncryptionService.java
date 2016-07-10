package com.selfdevelopment.encryption;

public class EncryptionService {

    public static void main (String... args) {
        System.out.println("Start encrypting the compiled class files");
        System.out.println("Class directory to encrypt: " + args[0]);
        System.out.println("Secret Password what we use for the encryption: " + args[1]);

        System.out.println("Finish encrypting the compiled class files");
    }


}
