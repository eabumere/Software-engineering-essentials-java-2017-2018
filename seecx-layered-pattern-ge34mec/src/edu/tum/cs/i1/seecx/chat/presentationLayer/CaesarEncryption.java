package edu.tum.cs.i1.seecx.chat.presentationLayer;

import edu.tum.cs.i1.seecx.chat.applicationLayer.ApplicationLayerInterface;
import edu.tum.cs.i1.seecx.chat.networkLayer.NetworkLayerInterface;

public class CaesarEncryption implements PresentationLayerInterface  {

	private final int key;
	
	private NetworkLayerInterface networkLayer;
	private ApplicationLayerInterface applicationLayer;

	public CaesarEncryption(int key) {
		if (key <= 0 || key >= 26) {
			throw new IllegalArgumentException("The key must have a value between 1 to 25");
		}
		this.key = key;
	}

	public String encrypt(String w, int k) {
		String result = new String();
		for (int i = 0; i < w.length(); i++) {
			char ch = w.charAt(i);
			if (ch >= 'A' && ch <= 'Z') {
				ch = shift('A', ch, key);
			} else if (ch >= 'a' && ch <= 'z') {
				ch = shift('a', ch, key);
			}
			result = result + ch;
		}
		return result;
	}

	private char shift(char offset, char input, int key) {
		return (char) (offset + (input - offset + key) % 26);
	}

	public String decrypt(String encrypted, int k) {
		// ugly workarounds:
		if (encrypted.startsWith("Welcome to chat! Your client ID is")) {
			return encrypted;
		}
		if (encrypted.replaceFirst("Client [0-9]+ logged out", "").equals(".")) {
			return encrypted;
		}
		String serverPrefix = encrypted.substring(0, encrypted.indexOf(":") + 2);
		encrypted = encrypted.replaceAll("Client [0-9]+: ", "");
		// end ugly workaround
		
		String result = new String();
		for (int i = 0; i < encrypted.length(); i++) {
			char ch = encrypted.charAt(i);
			if (ch >= 'A' && ch <= 'Z') {
				ch = shift('A', ch, 26 - key);
			} else if (ch >= 'a' && ch <= 'z') {
				ch = shift('a', ch, 26 - key);
			}
			result = result + ch;
		}
		return serverPrefix + result;
	}

	//TODO: Part 2: The send message method must encrypt the message before sending
	//TODO: Part 2: The receive message method must decrypt the message before giving it to upper layer
	
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
		String encryptedMessage = encrypt(message, key);
		networkLayer.sendMessage(encryptedMessage);
		
	}
		
	@Override
	public void receiveMessage(String message) {
		String decryptedMessage = decrypt(message, key);
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
