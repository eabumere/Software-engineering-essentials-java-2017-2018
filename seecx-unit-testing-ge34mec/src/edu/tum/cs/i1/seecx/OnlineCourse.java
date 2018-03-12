package edu.tum.cs.i1.seecx;

import java.net.MalformedURLException;
import java.net.URL;

public class OnlineCourse extends Course  {

    private URL url;

    public OnlineCourse(String title){
        super(title);
    }

    public void setUrl(String urlString) throws MalformedURLException {
        url = new URL(urlString);
    }

    public URL getUrl() {
        return url;
    }


}
