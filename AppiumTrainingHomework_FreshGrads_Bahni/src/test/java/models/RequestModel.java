package models;

public class RequestModel {
    private String requestDescription;
    private String requestCategory;
    private String requestSubcategory;
    private String requestPlatform;
    private String requestExpertise;
    private String requestDeliveryTime;
    private String requestBudget;

    public RequestModel() {}

    public String getRequestPlatform() {
        return requestPlatform;
    }

    public void setRequestPlatform(String requestPlatform) {
        this.requestPlatform = requestPlatform;
    }

    public String getRequestExpertise() {
        return requestExpertise;
    }

    public void setRequestExpertise(String requestExpertise) {
        this.requestExpertise = requestExpertise;
    }

    public String getRequestDescription() {
        return requestDescription;
    }

    public void setRequestDescription(String requestDescription) {
        this.requestDescription = requestDescription;
    }

    public String getRequestCategory() {
        return requestCategory;
    }

    public void setRequestCategory(String requestCategory) {
        this.requestCategory = requestCategory;
    }

    public String getRequestSubcategory() {
        return requestSubcategory;
    }

    public void setRequestSubcategory(String requestSubcategory) {
        this.requestSubcategory = requestSubcategory;
    }

    public String getRequestDeliveryTime() {
        return requestDeliveryTime;
    }

    public void setRequestDeliveryTime(String requestDeliveryTime) {
        this.requestDeliveryTime = requestDeliveryTime;
    }

    public String getRequestBudget() {
        return requestBudget;
    }

    public void setRequestBudget(String requestBudget) {
        this.requestBudget = requestBudget;
    }
}
