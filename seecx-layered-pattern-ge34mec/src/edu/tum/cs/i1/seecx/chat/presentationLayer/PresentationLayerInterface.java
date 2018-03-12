package edu.tum.cs.i1.seecx.chat.presentationLayer;

import edu.tum.cs.i1.seecx.chat.applicationLayer.ApplicationLayerInterface;
import edu.tum.cs.i1.seecx.chat.networkLayer.NetworkLayerInterface;

public interface PresentationLayerInterface {
	
	//TODO: Part 2: Add setters and getters for neighbouring layers. Add other methods according to UML model.   
	void start();
	void stop(); 
	
	void sendMessage(String message);
	void receiveMessage(String message);
	
	void setNetworkLayer(NetworkLayerInterface networkLayer);
	NetworkLayerInterface getNetworkLayer();
	
	void setApplicationLayer(ApplicationLayerInterface applicationLayer);
	ApplicationLayerInterface getApplicationLayer();
	
}
