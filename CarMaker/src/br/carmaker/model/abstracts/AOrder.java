/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model.abstracts;

import br.carmaker.model.JCar;
import br.carmaker.model.JFeedstock;
import br.carmaker.model.enums.EDeliveryStatus;
import java.util.Date;

/**
 *
 * @author felipe
 */
public abstract class AOrder {
    private String protocol;
    private EDeliveryStatus status;
    private Date expectedDate;

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public EDeliveryStatus getStatus() {
        return status;
    }

    public void setStatus(EDeliveryStatus status) {
        this.status = status;
    }

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }
    
    
}
