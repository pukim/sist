/**
 * 
 */
package org.ari.archi.seed;

import org.ari.archi.seed.seedx;

/**
 * @author Administrator
 *
 */
public class SeedUtils {
	
	public void seedUtils(String orgData) {
		int pdwRoundKey[] = new int[32];
		// User secret key
		byte pbUserKey[]  = {(byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00,
		                     (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00};
		
		/*
	// input plaintext to be encrypted
		byte pbData[]     = {(byte)0x00, (byte)0x01, (byte)0x02, (byte)0x03, (byte)0x04, (byte)0x05, (byte)0x06, (byte)0x07,
		                     (byte)0x08, (byte)0x09, (byte)0x0A, (byte)0x0B, (byte)0x0C, (byte)0x0D, (byte)0x0E, (byte)0x0F};
		*/
		byte pbData[] = new byte[16];
		
		byte pbCipher[]   = new byte[16];
		byte pbPlain[]    = new byte[16];
	
		
		pbData = chgStr2Byte(orgData);
		System.out.print("[ Test SEED reference code ]"+"\n");
		System.out.print("\n\n");
		
	//Derive roundkeys from user secret key
		seedx.SeedRoundKey(pdwRoundKey, pbUserKey);		
	
	//Encryption		
		seedx.SeedEncrypt(pbData, pdwRoundKey, pbCipher);
	
		System.out.print("[ Test Encrypt mode ]"+"\n");
		System.out.print("Key\t\t: ");
	  for (int i=0; i<16; i++)	System.out.print(Integer.toHexString(0xff&pbUserKey[i])+" ");
	  System.out.print("\n");
		System.out.print("Plaintext\t: ");
	  for (int i=0; i<16; i++)	System.out.print(Integer.toHexString(0xff&pbData[i])+" ");
	  System.out.print("\n");
		System.out.print("Ciphertext\t: ");
	  for (int i=0; i<16; i++)	System.out.print(Integer.toHexString(0xff&pbCipher[i])+" ");
	  System.out.print("\n\n");
	
	//Decryption
		seedx.SeedDecrypt(pbCipher, pdwRoundKey, pbPlain);
		
		System.out.print("[ Test Decrypt mode ]"+"\n");
		System.out.print("Key\t\t: ");
	  for (int i=0; i<16; i++)	System.out.print(Integer.toHexString(0xff&pbUserKey[i])+" ");
	  System.out.print("\n");
		System.out.print("Ciphertext\t: ");
	  for (int i=0; i<16; i++)	System.out.print(Integer.toHexString(0xff&pbCipher[i])+" ");
	  System.out.print("\n");
		System.out.print("Plaintext\t: ");
	  for (int i=0; i<16; i++)	System.out.print(Integer.toHexString(0xff&pbPlain[i])+" ");
	  System.out.print("\n\n");
	}
	
	public byte[] chgStr2Byte(String s) {
		char[] buffer = s.toCharArray(); 
		byte[] b = new byte[buffer.length << 1]; 

		for(int i = 0; i < buffer.length; i++) { 
			int bpos = i << 1; 
			/*
			b[bpos] = (byte) ((buffer[i]&0xFF00)>>8); 
			b[bpos + 1] = (byte) (buffer[i]&0x00FF); 
			*/
			b[i] = (byte) (buffer[i]&0x00FF);
		} 
		return b; 
	}
	
	public static void main(String[] args) {
		
		SeedUtils su = new SeedUtils();
		String s = "APPLEapple";
		
		
		su.seedUtils(s);
	}	
}
