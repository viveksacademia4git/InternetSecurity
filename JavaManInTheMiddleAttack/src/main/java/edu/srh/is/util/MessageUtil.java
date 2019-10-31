package edu.srh.is.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class MessageUtil {


	/**
	 * Returns the decryped message
	 * @param plainText {@link String}
	 * @param encryptionKey {@link BigInteger}
	 * @return encryptedMessage {@link Byte[]}
	 */
	public static byte[] encryptMessage(String plainText, BigInteger encryptionKey) throws UnsupportedEncodingException{
		byte[] keyBytes = encryptionKey.toByteArray();
		byte[] messageBytes = plainText.getBytes();
		byte[] cipherBytes = new byte[messageBytes.length];
		for(int i = 0; i < messageBytes.length; i++){
			cipherBytes[i] = (byte) (messageBytes[i] ^ keyBytes[i]);
		}
		return cipherBytes;
	}


	/**
	 * Returns the decrypted message
	 * @param cipherText {@link Byte[]}
	 * @param encryptionKey {@link BigInteger}
	 * @return decryptedMessage {@link String}
	 */
	public static String decryptMessage(byte[] cipherText, BigInteger encryptionKey) throws UnsupportedEncodingException{
		byte[] keyBytes = encryptionKey.toByteArray();
		byte[] messageBytes = new byte[cipherText.length];
		for(int i = 0; i < messageBytes.length; i++)
			messageBytes[i] = (byte) (cipherText[i] ^ keyBytes[i]);
		return new String(messageBytes, StandardCharsets.UTF_8);
	}


	public static BigInteger getRandomBigInteger(BigInteger start, BigInteger primeNumber) {
		Random rand = new Random();
		BigInteger result;
		do
			result = new BigInteger(primeNumber.bitCount(), rand);
		while(result.compareTo(primeNumber) >= 0 || result.compareTo(start) < 0);

		return result;
	}


	public static BigInteger getPrime(int bitLen){
		Random random = new Random();
		BigInteger bi = BigInteger.probablePrime(bitLen, random);
		return bi;
	}

}
