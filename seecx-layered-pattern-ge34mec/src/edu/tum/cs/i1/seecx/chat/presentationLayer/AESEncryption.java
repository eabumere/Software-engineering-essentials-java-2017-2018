package edu.tum.cs.i1.seecx.chat.presentationLayer;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import edu.tum.cs.i1.seecx.chat.applicationLayer.ApplicationLayerInterface;
import edu.tum.cs.i1.seecx.chat.networkLayer.NetworkLayerInterface;

/**
 * Code from Stackoverflow.
 * http://stackoverflow.com/questions/15554296/simple-java-aes-encrypt-decrypt-example
 *
 */

public class AESEncryption implements PresentationLayerInterface  {

	private byte[] key;
	private String initVector = "RandomInitVector";
	
	private NetworkLayerInterface networkLayer;
	private ApplicationLayerInterface applicationLayer;

	public AESEncryption(byte[] key) {
		this.key = key;
	}

	private String encrypt(String s) {
		  try {
	            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
	            SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");

	            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

	            byte[] encrypted = cipher.doFinal(s.getBytes());
	            return Base64.getEncoder().encodeToString(encrypted);
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }

		  return "Errors in encryption.";
	}

	private String decrypt(String encrypted) {
		//ugly workarounds:
		if(encrypted.startsWith("Welcome to chat! Your client ID is")) {
			return encrypted;
		}
		if(encrypted.replaceFirst("Client [0-9]+ logged out", "").equals(".")){
			return encrypted;
		}
		String serverPrefix = encrypted.substring(0, encrypted.indexOf(":") + 2);
		encrypted = encrypted.replaceAll("Client [0-9]+: ", "");
		// end ugly workarounds
		
		 try {
	            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
	            SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");

	            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
	            
	            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));
	            return serverPrefix + new String(original);
	        } catch (Exception ex) {
	        	ex.printStackTrace();
	        }
         return "Errors in decryption.";
	}

	
	//TODO: Part 3: The send message method must encrypt the message before sending
	//TODO: Part 3: The receive message method must decrypt the message before giving it to upper layer
	
	@Override
	public void setNetworkLayer(NetworkLayerInterface networkLayer) {
		this.networkLayer = networkLayer;
		
	}

	@Override
	public NetworkLayerInterface getNetworkLayer() {
		return this.networkLayer;
	}

	@Override
	public void setApplicationLayer(ApplicationLayerInterface applicationLayer) {
		this.applicationLayer = applicationLayer;
	}

	@Override
	public ApplicationLayerInterface getApplicationLayer() {
		return this.applicationLayer;
	}

	@Override
	public void sendMessage(String message) {
		String encryptedMessage = encrypt(message);
		networkLayer.sendMessage(encryptedMessage);
		
	}
		
	@Override
	public void receiveMessage(String message) {
		String decryptedMessage = decrypt(message);
		applicationLayer.receiveMessage(decryptedMessage);
		
	}	
	
	@Override
	public void start() {
		networkLayer.openConnection();
		
	}

	@Override
	public void stop() {
		networkLayer.closeConnection();
		
	}
	
}
