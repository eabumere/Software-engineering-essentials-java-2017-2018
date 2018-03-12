package edu.tum.cs.i1.seecx.chat.applicationLayer;

import edu.tum.cs.i1.seecx.chat.presentationLayer.PresentationLayerInterface;

public interface ApplicationLayerInterface {
	
	void start();
	void stop();
	void sendMessage(String message);
	void receiveMessage(String message);

	//TODO: Part 2: Replace with setters and getters for presentation layer 
	//TODO: Part 2: In the implementation of application layer, replace the reference to network layer with the reference to presentation layer. 
	/*void setNetworkLayer(NetworkLayerInterface networkLayer);
	NetworkLayerInterface getNetworkLayer();*/
	
	void setPresentationLayer(PresentationLayerInterface presentationLayer);
	PresentationLayerInterface getPresentationLayer();

}