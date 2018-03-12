package edu.tum.cs.i1.seecx.chat.networkLayer;

import edu.tum.cs.i1.seecx.chat.presentationLayer.PresentationLayerInterface;

public interface NetworkLayerInterface {

	void sendMessage(String message);
	void receiveMessage(String message);
	
	void openConnection();
	void closeConnection();
	
	//TODO: Part 2: Replace with setter and getter for presentation layer
	/*void setApplicationLayer(ApplicationLayerInterface applicationLayer);
	ApplicationLayerInterface getApplicationLayer();*/
		
	void setPresentationLayer(PresentationLayerInterface presentationLayer);
	PresentationLayerInterface getPresentationLayer();
	
}
