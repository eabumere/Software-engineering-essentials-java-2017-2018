package edu.tum.cs.i1.seecx.chat.applicationLayer;

import edu.tum.cs.i1.seecx.chat.client.ChatClient;
import edu.tum.cs.i1.seecx.chat.presentationLayer.PresentationLayerInterface;

public class ApplicationLayer implements ApplicationLayerInterface {

	//private NetworkLayerInterface networkLayer;
	private PresentationLayerInterface presentationLayer;
	private ChatClient chatClient;
	
	public ApplicationLayer(ChatClient chatClient) {
		this.chatClient = chatClient;
	}

	@Override
	public void start() {
		//TODO: Part 2: Replace with method invocation of the the presentation la
		//networkLayer.openConnection();
		presentationLayer.start();
	}

	@Override
	public void stop() {
		//TODO: Part 2: Replace with method invocation of the the presentation la
		//networkLayer.closeConnection();
		presentationLayer.stop();
	}

	@Override
	public void sendMessage(String message) {
		//TODO: Part 2: Replace with method invocation of the the presentation layer
		//networkLayer.sendMessage(message);
		presentationLayer.sendMessage(message);
	}

	@Override
	public void receiveMessage(String message) {
		//TODO: Part 1: Notify the ChatClient
		chatClient.receiveMessage(message);
	}

	//TODO: Part 2: Replace the reference to network layer with the reference to presentation layer.
	/*@Override
	public void setNetworkLayer(NetworkLayerInterface networkLayer) {
		this.networkLayer = networkLayer;
	}

	@Override
	public NetworkLayerInterface getNetworkLayer() {
		return networkLayer;
	}*/
	
	@Override
	public void setPresentationLayer(PresentationLayerInterface presentationLayer) {
		this.presentationLayer = presentationLayer;
		
	}

	@Override
	public PresentationLayerInterface getPresentationLayer() {
		return this.presentationLayer;
	}


	

}
