package com.selfdevelopment.classloader;

import com.google.common.io.ByteStreams;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

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
            return cipher.doFinal(ByteStreams.toByteArray(classURL.openStream()));
        } catch (IOException | BadPaddingException | IllegalBlockSizeException e) {
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
