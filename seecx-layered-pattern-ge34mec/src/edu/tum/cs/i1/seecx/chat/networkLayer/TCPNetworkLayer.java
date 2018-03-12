package edu.tum.cs.i1.seecx.chat.networkLayer;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import edu.tum.cs.i1.seecx.chat.applicationLayer.ApplicationLayerInterface;
import edu.tum.cs.i1.seecx.chat.presentationLayer.PresentationLayerInterface;

public class TCPNetworkLayer implements NetworkLayerInterface {

	private Socket socket;
	private Scanner socketInput;
	private PrintWriter socketOutput;
	private Thread waitForIncommingMessageThread;

	private String host;
	private int port;
	//TODO: Part 2: Replace with a reference to presentation layer 
	//private ApplicationLayerInterface applicationLayer;
	private PresentationLayerInterface presentationLayer;

	public TCPNetworkLayer(String host, int port) throws IOException {
		this.host = host;
		this.port = port;
	}

	@Override
	public void sendMessage(String message) {
		socketOutput.println(message);
	}

	@Override
	public void receiveMessage(String message) {
		this.presentationLayer.receiveMessage(message);
	}
	
	
	//TODO: Part 2: Replace with setter and getter for presentation layer
	/*@Override
	public void setApplicationLayer(ApplicationLayerInterface applicationLayer) {
		this.applicationLayer = applicationLayer;
	}
	
	@Override
	public ApplicationLayerInterface getApplicationLayer() {
		return applicationLayer;
	}*/
	
	@Override
	public void setPresentationLayer(PresentationLayerInterface presentationLayer) {
		this.presentationLayer = presentationLayer;
		
	}

	@Override
	public PresentationLayerInterface getPresentationLayer() {
		return this.presentationLayer;
	}
	
	private void waitForIncommingMessages() throws IOException {
		if (waitForIncommingMessageThread == null) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (socketInput.hasNextLine()) {
						String incommingMessage = socketInput.nextLine();
						receiveMessage(incommingMessage);
					}
				}
			}).start();
		}
	}

	@Override
	public void openConnection() {
		System.out.println("Connecting to server ...");
		try {
			socket = new Socket(host, port);
			socketInput = new Scanner(new InputStreamReader(socket.getInputStream()));
			socketOutput = new PrintWriter(socket.getOutputStream(), true);
			waitForIncommingMessages();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Connection Stablished.");
		
	}

	@Override
	public void closeConnection() {
		try {
			if (socketInput != null)
				socketInput.close();
			if (socketOutput != null)
				socketOutput.close();
			if (socket != null)
				socket.close();
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		
	}
	
}