package com.selfdevelopment.classloader;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

public class DecryptionClassLoaderFromUrlClassLoader extends URLClassLoader {

    public DecryptionService decryptionService = new DecryptionService();

    public DecryptionClassLoaderFromUrlClassLoader(ClassLoader classLoader) {
        super(((URLClassLoader) classLoader).getURLs(), classLoader.getParent());
    }

    public DecryptionClassLoaderFromUrlClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public DecryptionClassLoaderFromUrlClassLoader(URL[] urls) {
        super(urls);
    }

    public DecryptionClassLoaderFromUrlClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException
    {
        System.out.println("Loading class :" + name);
        if (!name.contains("com.selfdevelopment.secret")) {
            return super.loadClass(name, resolve);
        }
        byte[] b = decryptionService.loadClassData(name);
        return defineClass(name, b, 0, b.length);
    }


}
