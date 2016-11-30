package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Napha on 29.11.2016.
 */
@XmlRootElement(name = "SdlSig", namespace = "http://model/")
@XmlAccessorType(XmlAccessType.FIELD)
public class SdlSig implements Serializable {
    @XmlElement(name = "massage")
    private String massage;

    public SdlSig() {
    }

    public SdlSig(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }
}
