package sys.browser.generador;

//package sys.browser.exc;
//
//import java.security.Key;
//import javax.crypto.Cipher;
//import javax.crypto.spec.SecretKeySpec;
//import java.net.URLDecoder;
//import java.net.URLEncoder;
//import java.security.NoSuchAlgorithmException;
//import javax.crypto.KeyGenerator;
//import javax.crypto.SecretKey;
//
//public class CryptURL {
//
//    public static String Cryptar(String text, String key) {
//        try {
//            Key aesKey = new SecretKeySpec(key.getBytes(), "RSA");
//            Cipher cipher = Cipher.getInstance("RSA");
//            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
//            byte[] encrypted = cipher.doFinal(text.getBytes());
//            text = new String(encrypted);
//            System.err.println("ca" + text);
//            return URLEncoder.encode(text, "UTF-8");
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public static String Decryptar(String text, String key) {
//        try {
//            text = URLDecoder.decode(text, "UTF-8");
//            System.err.println("cc" + text);
//            Key aesKey = new SecretKeySpec(key.getBytes(), "RSA");
//            Cipher cipher = Cipher.getInstance("RSA");
//            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
//            byte[] encrypted = text.getBytes();
//            cipher.init(Cipher.DECRYPT_MODE, aesKey);
//            String decrypted = new String(cipher.doFinal(encrypted));
//            return decrypted;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//
//    }
//
//    public static String generateKey() throws NoSuchAlgorithmException {
//        String key = "";
//        try {
//            KeyGenerator keyGen = KeyGenerator.getInstance("DES");
//            keyGen.init(128);
//            SecretKey secretKey = keyGen.generateKey();
//            key = toHex(secretKey.getEncoded());
//        } catch (NoSuchAlgorithmException e) {
//            return null;
//        }
//        return key;
//    }
//
//    public static String toHex(final byte[] data) {
//        final StringBuilder sb = new StringBuilder(data.length * 2);
//        for (final byte b : data) {
//            sb.append(String.format("%02X", b));
//        }
//        return sb.toString();
//    }
//
//    public static void main(String[] args) throws Exception {
//
////        AESKeyGenerator keyGen = new AESKeyGenerator();
//
////        String s = generateKey();
//        String s = "0123456789abcdef";
//        
//        System.err.println("Key: " + s);
//
//        String cr = Cryptar("%Windir%\\Sys", s);
//        System.out.println(cr);
//
//        String cd = Decryptar(cr, s);
//        System.out.println(cd);
//
//    }
//}
