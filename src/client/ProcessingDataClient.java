package client;

import model.Log;
import model.SdlSig;
import model.Stopping;
import ws.ProcessingDataWebService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Napha on 30.11.2016.
 */
public class ProcessingDataClient extends TimerTask {
    private static final String SOAP_SERVICE_URL = "http://localhost:9999/processingLogs?wsdl";
    private static final String NAMESPACE_URI = "http://ws/";
    private static final String LOCAL_PART = "ProcessingDataWebServiceImplService";
    private static final String PATH_TO_LOG_FILE = "D:\\log.txt";
    private static final long DELAY = 0;
    private static final long PERIOD = 300000; // 5 min = 300000 milisec.

    public static void main(String[] args){
        Timer time = new Timer();
        ProcessingDataClient processingDataClient = new ProcessingDataClient();
        time.schedule(processingDataClient, DELAY, PERIOD);
    }

    @Override
    public void run() {
        try{
            URL url = new URL(SOAP_SERVICE_URL);
            QName qname = new QName(NAMESPACE_URI, LOCAL_PART);
            Service service = Service.create(url, qname);
            ProcessingDataWebService processingDataWebService = service.getPort(ProcessingDataWebService.class);

            try {
                Log log = processingDataWebService.gettingSdlSigAndStoppingMassagesFromLogFile(PATH_TO_LOG_FILE);
                System.out.println("SdlSig");
                for(SdlSig sdlSig: log.getSdlSigs()){
                    System.out.println(sdlSig.getMassage());
                }

                System.out.println("Stopping");
                for (Stopping stopping : log.getStoppings()){
                    System.out.println(stopping.getMassage());
                }
            }catch (IOException ex){
                ex.printStackTrace();
            }

        } catch (MalformedURLException exp){
            exp.printStackTrace();
        }
    }
}
