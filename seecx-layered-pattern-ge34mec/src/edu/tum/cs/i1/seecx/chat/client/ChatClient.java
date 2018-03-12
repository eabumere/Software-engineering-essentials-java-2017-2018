package edu.tum.cs.i1.seecx.chat.client;

import java.io.IOException;
import java.util.Scanner;

import edu.tum.cs.i1.seecx.chat.applicationLayer.ApplicationLayer;
import edu.tum.cs.i1.seecx.chat.applicationLayer.ApplicationLayerInterface;
import edu.tum.cs.i1.seecx.chat.networkLayer.NetworkLayerInterface;
import edu.tum.cs.i1.seecx.chat.networkLayer.TCPNetworkLayer;
import edu.tum.cs.i1.seecx.chat.presentationLayer.AESEncryption;
import edu.tum.cs.i1.seecx.chat.presentationLayer.CaesarEncryption;
import edu.tum.cs.i1.seecx.chat.presentationLayer.PresentationLayerInterface;


public class ChatClient {

	private static final String SERVER_HOST = "easelayeredpattern-bruegge.in.tum.de";
	private static final int SERVER_PORT = 1337;
	
	private static final String LOGOUT_MESSAGE = ".logout";
	private static Thread waitForUserInputThread;
	
	//TODO: Make sure to set this value every time a new message is received. 
	private String lastMessgeReceived = null;

	private ApplicationLayerInterface applicationLayer;	

	public static void main(String[] args) throws IOException {
		ChatClient chatClient = new ChatClient(SERVER_HOST, SERVER_PORT);
		chatClient.start();
		waitForUserInputThread = new Thread(new Runnable() {
			@Override
			public void run() {
				chatClient.waitForUserInput();
			}
		});
		waitForUserInputThread.start();
		System.out.println("ChatClient started.");
	}
	
	public ChatClient(String serverHost, int serverPort) throws IOException {
		//TODO: Part 2: Instantiate and configure the layers
		//TODO: Part 3: Add and use an AESEncryption implementation of the presentation layer.
		this.applicationLayer = new ApplicationLayer(this);
		//PresentationLayerInterface presentationLayer = new CaesarEncryption(3);
		PresentationLayerInterface presentationLayer = new AESEncryption("0123456701234567".getBytes("UTF-8"));
		NetworkLayerInterface networkLayer = new TCPNetworkLayer(serverHost, serverPort);
		
		this.applicationLayer.setPresentationLayer(presentationLayer);
		presentationLayer.setApplicationLayer(applicationLayer);
		presentationLayer.setNetworkLayer(networkLayer);
		networkLayer.setPresentationLayer(presentationLayer);
	}
	
	public void start() {
		applicationLayer.start();
	}
		
	private void waitForUserInput() {
		Scanner scanner = new Scanner(System.in);
		try {
			while (true) {
				String outgoingMessage = scanner.nextLine();
				if(LOGOUT_MESSAGE.equals(outgoingMessage)){
					shutDown();
				}else{
					sendMessage(outgoingMessage);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	public void receiveMessage(String message) {
		this.lastMessgeReceived = message;
		//TODO: Part 1: Print the received message by invoking the printMessage() method
		printMessage(message);
	}
	
	public void sendMessage(String outgoingMessage) {
		//TODO: Part 1: Use the application layer to send the message. 
		applicationLayer.sendMessage(outgoingMessage);
	}

	@SuppressWarnings("deprecation")
	private void shutDown() {
		applicationLayer.stop();
		//Not a good way to stop a program! But is enough for our purpose. 
		waitForUserInputThread.stop();
		System.exit(0);
	}

	private void printMessage(String message) {
		System.out.println(message);
	}
	
	/**
	 * Added for tests
	 * @return
	 */
	public ApplicationLayerInterface getApplicationLayer() {
		return applicationLayer;
	}

	/**
	 * Added for tests
	 * @return
	 */
	public String getLastMessgeReceived() {
		return lastMessgeReceived;
	}

}