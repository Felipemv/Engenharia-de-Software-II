package br.carmaker.model;

public class JSupplier extends AAffiliate{
    private JFeedstock feedstock;
    private int leadTime;

    public JFeedstock getFeedstock() {
        return feedstock;
    }

    public void setFeedstock(JFeedstock feedstock) {
        this.feedstock = feedstock;
    }

    public int getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(int leadTime) {
        this.leadTime = leadTime;
    }
    
    
}
