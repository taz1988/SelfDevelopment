#Introduction
I have created this project to practice classloader programming in java. The purpose of the classloader
to decrypt encrypted class files at runtime.

#How to compile
To compile my project, run the following command:
```
mvn clean package
```

When the build finished successfully, you shoud see something similar in the build log:
```
Start encrypting the compiled class files
Class directory to encrypt: /home/taz/github/SelfDevelopment/classloader/target/classes/com/selfdevelopment/secret/
Encrypt class file: /home/taz/github/SelfDevelopment/classloader/target/classes/com/selfdevelopment/secret/TopSecretCode.class
Secret Password what we used for the encryption: 3v8gpa0pgrbsefnlad15pss9h7
Finish encrypting the compiled class files
```

The Secret password need for run the program. Every build generate a new password.

#How to run the program
Here is how to run the program from the project root directory:
```
java -Djava.system.class.loader=com.selfdevelopment.classloader.DecryptionClassLoaderFromUrlClassLoader -Dkey="<INSERT_PASSWORD_HERE>"  -jar target/classloader-1.0-SNAPSHOT-jar-with-dependencies.jar
```

#What is happening?
When maven compile the program, the DecryptionService has been called which decrypt the classes under the secret package.

When you run the program, the DecryptionClassLoaderFromUrlClassLoader decrypt the classes which are under the secret package.

#Resources
* http://docs.oracle.com/javase/7/docs/technotes/guides/security/crypto/CryptoSpec.html
* http://www.javaworld.com/article/2077342/core-java/cracking-java-byte-code-encryption.html
* http://stackoverflow.com/questions/25478223/why-is-custom-system-classloader-not-working
