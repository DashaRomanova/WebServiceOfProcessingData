package endpoint;

import ws.ProcessingDataWebServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by Napha on 30.11.2016.
 */
public class ProcessingDataPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8087/processingLogs", new ProcessingDataWebServiceImpl());
    }
}
