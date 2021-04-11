import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.io.*;
import java.security.Key;

public class Odev2 {

    public static void main(String[] args) throws IOException {

    	File file = new File("sample-5mb-text-file.txt");
        byte[] orjinalMetin  = new byte[(int) file.length()];

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            //fileInputStream.read(orjinalMetin);
            String okunanVeri = new String(orjinalMetin);
            //System.out.println(file.length());

            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            Key key = keyGen.generateKey();

            Cipher cipher1 = Cipher.getInstance("AES");
            // Cipher cipher1 = Cipher.getInstance("AES/CBC/PKCS5Padding");   // Bu þekil yazdýðýmda Decryption da hata veriyor

            cipher1.init(Cipher.ENCRYPT_MODE, key);
            long t1 = System.currentTimeMillis();
            //cipher.doFinal(okunanVeri.getBytes());
            byte[] sifreliMetin1 = cipher1.doFinal(okunanVeri.getBytes());
            long t2 = System.currentTimeMillis();
            System.out.println("Ýþlem:Encryption" + "   Anahtar:AES" + "   Þifreleme Modu:AES/CBC/PKCS5Padding" + "   Zaman:"+ (t2-t1));

            cipher1.init(Cipher.DECRYPT_MODE, key);
            long t3 = System.currentTimeMillis();
            byte[] cozulmusMetin1 = cipher1.doFinal(sifreliMetin1);
            long t4 = System.currentTimeMillis();
            System.out.println("Ýþlem:Decryption" + "   Anahtar:AES" + "   Þifreleme Modu:AES/CBC/PKCS5Padding" + "   Zaman:"+ (t4-t3));

            Cipher cipher2 = Cipher.getInstance("AES/ECB/PKCS5Padding");

            cipher2.init(Cipher.ENCRYPT_MODE, key);
            long t5 = System.currentTimeMillis();
            //cipher.doFinal(okunanVeri.getBytes());
            byte[] sifreliMetin2 = cipher2.doFinal(okunanVeri.getBytes());
            long t6 = System.currentTimeMillis();
            System.out.println("Ýþlem:Encryption" + "   Anahtar:AES" + "   Þifreleme Modu:AES/ECB/PKCS5Padding" + "   Zaman:"+ (t6-t5));

            cipher2.init(Cipher.DECRYPT_MODE, key);
            long t7 = System.currentTimeMillis();
            byte[] cozulmusMetin2 = cipher2.doFinal(sifreliMetin2);
            long t8 = System.currentTimeMillis();
            System.out.println("Ýþlem:Decryption" + "   Anahtar:AES" + "   Þifreleme Modu:AES/ECB/PKCS5Padding" + "   Zaman:"+ (t8-t7));

            KeyGenerator keyGen2 = KeyGenerator.getInstance("DES");
            Key key2 = keyGen2.generateKey();

            Cipher cipher3 = Cipher.getInstance("DES");
            // Cipher cipher3 = Cipher.getInstance("DES/CBC/PKCS5Padding");   // Bu þekil yazdýðýmda Decryption da hata veriyor

            cipher3.init(Cipher.ENCRYPT_MODE, key2);
            long t9 = System.currentTimeMillis();
            //cipher.doFinal(okunanVeri.getBytes());
            byte[] sifreliMetin3 = cipher3.doFinal(okunanVeri.getBytes());
            long t10 = System.currentTimeMillis();
            System.out.println("Ýþlem:Encryption" + "   Anahtar:DES" + "   Þifreleme Modu:DES/CBC/PKCS5Padding" + "   Zaman:"+ (t10-t9));

            cipher3.init(Cipher.DECRYPT_MODE, key2);
            long t11 = System.currentTimeMillis();
            byte[] cozulmusMetin3 = cipher3.doFinal(sifreliMetin3);
            long t12 = System.currentTimeMillis();
            System.out.println("Ýþlem:Decryption" + "   Anahtar:AES" + "   Þifreleme Modu:DES/CBC/PKCS5Padding" + "   Zaman:"+ (t12-t11));

            Cipher cipher4 = Cipher.getInstance("DES/ECB/PKCS5Padding");

            cipher4.init(Cipher.ENCRYPT_MODE, key2);
            long t13 = System.currentTimeMillis();
            //cipher.doFinal(okunanVeri.getBytes());
            byte[] sifreliMetin4 = cipher4.doFinal(okunanVeri.getBytes());
            long t14 = System.currentTimeMillis();
            System.out.println("Ýþlem:Encryption" + "   Anahtar:DES" + "   Þifreleme Modu:DES/ECB/PKCS5Padding" + "   Zaman:"+ (t14-t13));

            cipher4.init(Cipher.DECRYPT_MODE, key2);
            long t15 = System.currentTimeMillis();
            byte[] cozulmusMetin4 = cipher4.doFinal(sifreliMetin4);
            long t16 = System.currentTimeMillis();
            System.out.println("Ýþlem:Decryption" + "   Anahtar:DES" + "   Þifreleme Modu:DES/ECB/PKCS5Padding" + "   Zaman:"+ (t16-t15));

            fileInputStream.close();

        } catch (Exception e) {
                e.printStackTrace();
        }
    }
}
