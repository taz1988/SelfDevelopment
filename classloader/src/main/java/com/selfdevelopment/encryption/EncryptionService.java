package com.selfdevelopment.encryption;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import static java.nio.file.Files.move;
import static java.nio.file.Files.readAllBytes;

public class EncryptionService {

    private String password;
    private Cipher cipher;

    public EncryptionService() throws NoSuchPaddingException, NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException, InvalidKeySpecException {
        cipher = Cipher.getInstance("DES");
        SecureRandom secureRandom = new SecureRandom();
        password = new BigInteger(130, secureRandom).toString(32);//secureRandom.generateSeed(16));
        DESKeySpec keySpec = new DESKeySpec(password.getBytes("UTF-8"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey key = keyFactory.generateSecret(keySpec);
        cipher.init(Cipher.ENCRYPT_MODE, key);
    }

    public static void main(String... args) {
        System.out.println("Start encrypting the compiled class files");
        System.out.println("Class directory to encrypt: " + args[0]);
        EncryptionService service = null;
        try {
            service = new EncryptionService();
            service.encryptClassesInFolder(new File(args[0]));
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | InvalidKeySpecException | IOException e) {
            e.printStackTrace();
        }
        System.out.println("Secret Password what we used for the encryption: " + service.getPassword());
        System.out.println("Finish encrypting the compiled class files");
    }

    private void encryptClassesInFolder(File folder) throws IOException {
        if (folder.isDirectory()) {
            for (File file : folder.listFiles()) {
                if (!file.isDirectory() && file.getAbsolutePath().endsWith("class")) {
                    encryptClassFile(file);
                }
            }
            for (File file : folder.listFiles()) {
                if (!file.isDirectory() && file.getAbsolutePath().endsWith("class")) {
                    move(Paths.get(file.getAbsolutePath() + ".bak"), Paths.get(file.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }
    }

    private void encryptClassFile(File file) {
        System.out.println("Encrypt class file: " + file.getAbsolutePath());
        File decryptedFile = new File(file.getAbsolutePath() + ".bak");
        try {
            Files.write(decryptedFile.toPath(), cipher.doFinal(readAllBytes(file.toPath())), StandardOpenOption.CREATE);
        } catch (IOException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }

    private String getPassword() {
        return password;
    }
}
