package com.selfdevelopment.classloader;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DecryptionService {

    private String password;
    private Cipher cipher;

    public byte[] loadClassData(String name) throws ClassNotFoundException {
        System.out.println("loadClassData (" + name + ")");
        initCipher();
        final String classResource = name.replace('.', '/') + ".class";
        final URL classURL = getClass().getClassLoader().getResource(classResource);

        if (classURL == null) {
            throw new ClassNotFoundException(name);
        }
        try {
            byte[] data = Files.readAllBytes(Paths.get(classURL.toURI()));
            return cipher.doFinal(data);
        } catch (IOException | URISyntaxException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
            throw new ClassNotFoundException(name);
        }
    }

    private void initCipher() {
        if (cipher == null) {
            password = System.getProperty("key");
            try {
                DESKeySpec keySpec = new DESKeySpec(password.getBytes("UTF-8"));
                SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
                SecretKey key = keyFactory.generateSecret(keySpec);
                cipher = Cipher.getInstance("DES");
                cipher.init(Cipher.DECRYPT_MODE, key);
            } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | UnsupportedEncodingException | InvalidKeySpecException e) {
                e.printStackTrace();
            }
        }
    }
}
