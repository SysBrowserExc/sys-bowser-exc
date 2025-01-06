/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sys.browser.generador;

import java.security.InvalidKeyException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class KeyGeneratorExample {

    SecretKey key, randomDESKey;

    public static void main(String args[]) throws Exception {
        //Creating a KeyGenerator object
        KeyGenerator generator = KeyGenerator.getInstance("DES");
        generator.init(new SecureRandom());
        Key key = generator.generateKey();

//      byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
// rebuild key using SecretKeySpec
//SecretKey secretKey = KeyGenerator.getInstance("ALGO_SECRET_KEY_GENERATOR").generateKey();
// Crate base64 string 
        String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
        
        
        System.err.println(toHex(key.getEncoded()));

        System.err.println(encodedKey);

//       KeyGenerator generator;
//        SecretKey randomDESKey;
//        generator = KeyGenerator.getInstance("DES");
//        generator.init(new SecureRandom());
//        randomDESKey = generator.generateKey();
//        System.out.println("RDK " + new String(randomDESKey.getEncoded()));
    }
//    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
//    KeyGenerator des = KeyGenerator.getInstance("DES");
//    des.init(56);
//    SecretKey secretKey = des.generateKey();
//    Mac hmacSHA256 = Mac.getInstance("HmacSHA256");
//    hmacSHA256.init(secretKey);
//    byte[] bytes = hmacSHA256.doFinal("Hello Crypto".getBytes());
//    System.out.println(Base64.getEncoder().encodeToString(bytes));
//    System.out.println(new String(Base64.getEncoder().encode(bytes)));
//    System.out.println(hmacSHA256);
//    MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
//    System.out.println(sha256);
//}
        public static String toHex(final byte[] data) {
        final StringBuilder sb = new StringBuilder(data.length * 2);
        for (final byte b : data) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}
