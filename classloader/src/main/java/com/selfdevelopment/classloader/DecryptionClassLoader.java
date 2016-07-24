package com.selfdevelopment.classloader;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.NoSuchPaddingException;

public class DecryptionClassLoader extends ClassLoader {

    public DecryptionService decryptionService = new DecryptionService();

    public DecryptionClassLoader(ClassLoader classLoader) throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException {
        super(classLoader);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException {
        System.out.println("Loading class :" + name);
        if (!name.contains("com/selfdevelopment/secret")) {
            return super.loadClass(name, resolve);
        }
        byte[] b = decryptionService.loadClassData(name);
        return defineClass(name, b, 0, b.length);
    }

}
