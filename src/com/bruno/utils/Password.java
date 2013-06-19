package com.bruno.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;


/**
 * Created with IntelliJ IDEA.
 * User: bruno
 * Date: 15/06/13
 * Time: 13:45
 * To change this template use File | Settings | File Templates.
 */

public class Password {
    // The higher the number of iterations the more
    // expensive computing the hash is for us
    // and also for a brute force attack.
    private static final int iterations = 10 * 1024;
    private static final int saltLen = 32;
    private static final int desiredKeyLen = 256;

    /**
     * Computes a salted PBKDF2 hash of given plaintext password
     * suitable for storing in a database.
     * Empty passwords are not supported.
     */
    public static String getSaltedHash(String password){
        String hash = null;
        try{byte[] salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(saltLen);
        // store the salt with the password
        hash = Base64.encodeBase64String(salt) + "$" + hash(password, salt);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return hash;
    }

    /**
     * Checks whether given plaintext password corresponds
     * to a stored salted hash of the password.
     */
    public static boolean check(String password, String stored) {
        boolean match;
        try{
            String[] saltAndPass = stored.split("\\$");
            if (saltAndPass.length != 2){
                return false;
            }
            String hashOfInput = hash(password, Base64.decodeBase64(saltAndPass[0]));
            match=hashOfInput.equals(saltAndPass[1]);
        }
        catch (Exception e){
            return false;
        }
        return match;
    }

    // using PBKDF2 from Sun, an alternative is https://github.com/wg/scrypt
    // cf. http://www.unlimitednovelty.com/2012/03/dont-use-bcrypt.html
    private static String hash(String password, byte[] salt) {
        String hash = null;
        try{
        if (password == null || password.length() == 0)
            throw new IllegalArgumentException("Empty passwords are not supported.");
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecretKey key = f.generateSecret(new PBEKeySpec(
                password.toCharArray(), salt, iterations, desiredKeyLen)
        );
        hash = Base64.encodeBase64String(key.getEncoded());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return hash;

    }
}