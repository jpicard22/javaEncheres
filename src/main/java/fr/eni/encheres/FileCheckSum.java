package fr.eni.encheres;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileCheckSum {

	    public static void main(String[]args) throws NoSuchAlgorithmException, IOException {
	    	String maChaine ="Bonjour";
	    	byte[] byteChaine = maChaine.getBytes(StandardCharsets.UTF_8);
	    	MessageDigest md = MessageDigest.getInstance("MD5");
	    	byte[] hash = md.digest(byteChaine);
	    }

	    private static byte[]checksum(String filepath, MessageDigest md) throws IOException {

	        try (DigestInputStream dis = new DigestInputStream(new FileInputStream(filepath), md)) {
	            while (dis.read() != -1) ;//empty loop to clear the data
	            md = dis.getMessageDigest();
	        }

	        return md.digest();

	    }

	    private static String bytesToHex(byte[]hashInBytes) {

	        StringBuilder sb = new StringBuilder();
	        for (byte b : hashInBytes) {
	            sb.append(String.format("%02x", b));
	        }
	        return sb.toString();

	    }

}
