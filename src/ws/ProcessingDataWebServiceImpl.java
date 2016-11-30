package ws;

import model.*;

import javax.jws.WebService;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

/**
 * Created by Napha on 29.11.2016.
 */
@WebService(endpointInterface = "ws.ProcessingDataWebService")
public class ProcessingDataWebServiceImpl implements ProcessingDataWebService {
    @Override
    public Log gettingSdlSigAndStoppingMassagesFromLogFile(String path) throws IOException{

        List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);

        Log log = null;

        Pattern pattern = Pattern.compile("(SdlSig|Stopping)");

        List<SdlSig> sdlSigs = new ArrayList<>();
        List<Stopping> stoppings = new ArrayList<>();
        for(String line: lines){
            Matcher matcher = pattern.matcher(line);
            if(matcher.find()){
                if(matcher.group().equals("SdlSig")){
                    sdlSigs.add(new SdlSig(line));
                } else {
                    stoppings.add(new Stopping(line));
                }
            }
        }

        log = new Log(stoppings, sdlSigs);

        return log;
    }
}
