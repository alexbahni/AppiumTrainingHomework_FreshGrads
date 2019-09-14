package fragments;

import configs.AppTouchActions;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PostRequestFormPage {
    AndroidDriver<MobileElement> driver;
    AppTouchActions appTouchActions;

    private MobileElement requestDescription;
    private MobileElement requestCategoryField;
    private MobileElement requestCategoryItem;
    private MobileElement requestSubcategoryField;
    private MobileElement requestSubcategoryItem;
    private MobileElement requestPlatformField;
    private MobileElement requestPlatformItem;
    private MobileElement requestExpertiseField;
    private MobileElement requestExpertiseItem;
    private MobileElement requestDeliveryTimeField;
    private List<MobileElement> requestDeliveryTimeItem;
    private MobileElement requestBudgetField;
    private MobileElement requestSubmitButton;

    private MobileElement requestPendingStatus;
    private MobileElement requestDescriptionCheck;
    private MobileElement requestDurationCheck;
    private MobileElement requestBudgetCheck;

    private MobileElement requestDeleteRequestButton;
    private MobileElement confirmDeleteRequest;

    WebDriverWait wait;


    public PostRequestFormPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }


    public void initElements() {
        wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.fiverr.fiverr:id/multiline_edit_text")));

        requestDescription = driver.findElement(By.id("com.fiverr.fiverr:id/multiline_edit_text"));
        requestCategoryField = driver.findElement(By.id("com.fiverr.fiverr:id/post_request_category"));
        requestSubcategoryField = driver.findElement(By.id("com.fiverr.fiverr:id/post_request_subcategory"));
    }

    public MobileElement selectCategoryItem(String itemToSelect) {
        wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.CheckedTextView[@text='" + itemToSelect + "']")));

        requestCategoryItem = driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='" + itemToSelect + "']"));

        return requestCategoryItem;
    }

    public MobileElement selectSubcategoryItem(String itemToSelect) {
        wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.CheckedTextView[@text='" + itemToSelect + "']")));
        requestSubcategoryItem = driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='" + itemToSelect + "']"));

        return requestSubcategoryItem;
    }

    public void initCategorySpecificFields() {
        appTouchActions = new AppTouchActions(driver);
        appTouchActions.scroolDownAction();

        requestPlatformField = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout"));
        requestExpertiseField = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout"));
        requestDeliveryTimeField = driver.findElement(By.id("com.fiverr.fiverr:id/post_request_delivery_time"));
        requestBudgetField = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[4]/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.EditText"));
        requestSubmitButton = driver.findElement(By.id("com.fiverr.fiverr:id/post_request_submit_btn"));
    }

    public MobileElement selectPlatformItem(String itemToSelect) {
        requestPlatformItem = driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='" + itemToSelect + "']"));

        return requestPlatformItem;
    }

    public MobileElement selectExpertiseItem(String itemToSelect) {
        requestExpertiseItem = driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='" + itemToSelect + "']"));

        return requestExpertiseItem;
    }

    public List<MobileElement> selectDeliveryTimeItem(String itemToSelect) {
        return driver.findElements(By.xpath("//android.widget.CheckedTextView[@text='" + itemToSelect + "']"));
    }



    public void scrollToDesiredDateDelivery(String itemToSelect) {
        appTouchActions = new AppTouchActions(driver);

        while( selectDeliveryTimeItem(itemToSelect).size() == 0 ){
            appTouchActions.scroolDownInListAction();
        }

        if( selectDeliveryTimeItem(itemToSelect).size() > 0 ) {
            selectDeliveryTimeItem(itemToSelect).get(0).click();
        }
    }


    public void createRequest(
            String requestDescriptionToSet,
            String requestCategoryToSet,
            String requestSubcategoryToSet,
            String requestPlatformToSet,
            String requestExpertiseToSet,
            String requestDeliveryTimeToSet,
            String requestBudgetToSet) {

        //set request description
        requestDescription.sendKeys(requestDescriptionToSet);

        //choose request category
        requestCategoryField.click();
        selectCategoryItem(requestCategoryToSet).click();

        //choose request subcategory
        requestSubcategoryField.click();
        selectSubcategoryItem(requestSubcategoryToSet).click();

        //scrollToNextElements
        initCategorySpecificFields();

        //choose platform
        requestPlatformField.click();
        selectPlatformItem(requestPlatformToSet).click();

        //choose expertise
        requestExpertiseField.click();
        selectExpertiseItem(requestExpertiseToSet).click();

        //choose delivery time
        requestDeliveryTimeField.click();
        scrollToDesiredDateDelivery(requestDeliveryTimeToSet);

        //set request budget
        requestBudgetField.click();
        requestBudgetField.sendKeys(requestBudgetToSet);

        //submit request
        requestSubmitButton.click();

    }

    public void initElementsAfterCreatingRequest() {
        wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.fiverr.fiverr:id/request_status")));

        requestPendingStatus = driver.findElement(By.id("com.fiverr.fiverr:id/request_status"));
        requestDescriptionCheck = driver.findElement(By.id("com.fiverr.fiverr:id/offer_description"));
        requestDurationCheck = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.TextView[2]"));
        requestBudgetCheck = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.TextView[2]"));

        requestDeleteRequestButton = driver.findElement(By.id("com.fiverr.fiverr:id/request_delete_btn"));
    }

    public void initConfirmDeleteRequest(){
        wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/button1")));

        confirmDeleteRequest = driver.findElement(By.id("android:id/button1"));
    }

    public boolean checkIfContains(String textToCheck, MobileElement fieldToCheck) {
        return fieldToCheck.getText().contains(textToCheck);
    }

    public MobileElement getConfirmDeleteRequest() {
        return confirmDeleteRequest;
    }


    public MobileElement getRequestPendingStatus() {
        return requestPendingStatus;
    }

    public MobileElement getRequestDescriptionCheck() {
        return requestDescriptionCheck;
    }

    public MobileElement getRequestDurationCheck() {
        return requestDurationCheck;
    }

    public MobileElement getRequestBudgetCheck() {
        return requestBudgetCheck;
    }

    public MobileElement getRequestDeleteRequestButton() {
        return requestDeleteRequestButton;
    }
}
