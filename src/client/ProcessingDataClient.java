package client;

import model.Log;
import model.SdlSig;
import model.Stopping;
import ws.ProcessingDataWebService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

/**
 * Created by Napha on 30.11.2016.
 */
public class ProcessingDataClient {
    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:8087/processingLogs?wsdl");
        QName qname = new QName("http://ws/", "ProcessingDataWebServiceImplService");

        Service service = Service.create(url, qname);

        ProcessingDataWebService processingDataWebService = service.getPort(ProcessingDataWebService.class);

        String pathToLogFile = "D:\\log.txt";
        Log log = processingDataWebService.gettingSdlSigAndStoppingMassagesFromLogFile(pathToLogFile);

        System.out.println("SdlSig");
        for(SdlSig sdlSig: log.getSdlSigs()){
            System.out.println(sdlSig.getMassage());
        }

        System.out.println("Stopping");
        for (Stopping stopping : log.getStoppings()){
            System.out.println(stopping.getMassage());
        }

    }
}
