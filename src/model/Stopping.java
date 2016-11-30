package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Napha on 29.11.2016.
 */
@XmlRootElement(name = "Stopping", namespace = "http://model/")
@XmlAccessorType(XmlAccessType.FIELD)
public class Stopping implements Serializable {
    @XmlElement(name = "massage")
    private String massage;

    public Stopping(String massage) {
        this.massage = massage;
    }

    public Stopping() {
    }

    public String getMassage() {
        return massage;
    }
}
