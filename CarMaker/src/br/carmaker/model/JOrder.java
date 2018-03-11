package br.carmaker.model;

import java.util.Date;

public class JOrder {	
    private String protocol;
    private JCar car;
    private JFeedstock feedstock;
    private EDeliveryStatus status;
    private Date expectedDate;
    
    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public JCar getCar() {
        return car;
    }

    public void setCar(JCar car) {
        this.car = car;
    }

    public JFeedstock getFeedstock() {
        return feedstock;
    }

    public void setFeedstock(JFeedstock feedstock) {
        this.feedstock = feedstock;
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