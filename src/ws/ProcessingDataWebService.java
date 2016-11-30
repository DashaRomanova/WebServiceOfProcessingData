package ws;

import model.Log;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.io.IOException;

/**
 * Created by Napha on 29.11.2016.
 */

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use= SOAPBinding.Use.LITERAL)
public interface ProcessingDataWebService {
    @WebMethod
    Log gettingSdlSigAndStoppingMassagesFromLogFile(@WebParam(name = "pathToLogFile") String path)throws IOException;
}
