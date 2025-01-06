package sys.browser.password;

import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import java.security.Key;
import java.security.SecureRandom;

public class DESCrypter {

    public static SecretKey key(byte[] plaintext) throws NoSuchAlgorithmException,
            InvalidKeySpecException, InvalidKeyException {
        //key
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.put(plaintext);
        buffer.put((byte) 0);
        buffer.put((byte) 0);
        //
        SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
        DESKeySpec keySpec = new DESKeySpec(buffer.array());
        SecretKey secretKey = factory.generateSecret(keySpec);
        //
        return secretKey;
    }

    public static String encode(SecretKey key, String text) throws NoSuchAlgorithmException,
            NoSuchPaddingException, IllegalBlockSizeException,
            BadPaddingException, InvalidKeyException {
        //
        Cipher cipher = Cipher.getInstance(key.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, key);
        //
        byte[] ciphered = cipher.doFinal(text.getBytes());
        //
        Encoder encoder = Base64.getEncoder();
        byte[] encoded = encoder.encode(ciphered);
        //
        return new String(encoded);
    }

    public static String decode(SecretKey key, String encriptedText) throws NoSuchAlgorithmException,
            NoSuchPaddingException, IllegalBlockSizeException,
            BadPaddingException, InvalidKeyException {
        //
        Cipher cipher = Cipher.getInstance(key.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, key);
        //
        Decoder decoder = Base64.getDecoder();
        byte[] decoded = decoder.decode(encriptedText);
        //
        byte[] unciphered = cipher.doFinal(decoded);
        //
        return new String(unciphered);
    }

    public static String generateKey() throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance("DES");
        generator.init(new SecureRandom());
        Key key = generator.generateKey();
        byte[] data = key.getEncoded();
        final StringBuilder sb = new StringBuilder(data.length * 2);
        for (final byte b : data) {
            sb.append(String.format("%02X", b));
        }
        String pass = sb.toString();
        return sb.substring(0, 6);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException,
            InvalidKeySpecException, NoSuchPaddingException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
//        SecretKey key = key("123456".getBytes());
//        String encrypted = encode(key, "E ai galerinha! Vamos tentar decriptografar?");
//        String decrypted = decode(key, encrypted);
//        //
//        System.out.println("Texto criptografado: " + encrypted);
//        System.out.println("Texto descriptografado: " + decrypted);
//
//        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
//
//        //Creating a SecureRandom object
//        SecureRandom secRandom = new SecureRandom();
//
//        //Initializing the KeyGenerator
//        keyGen.init(secRandom);

        //Creating/Generating a key
//      Key key = keyGen.generateKey();
//      
//      System.out.println(key);      
//      Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");      
//      cipher.init(cipher.ENCRYPT_MODE, key);      
//
//      String msg = new String("Hi how are you");
//      byte[] bytes = cipher.doFinal(msg.getBytes());      
//      System.out.println(bytes);
        System.err.println(generateKey());
    }
}
