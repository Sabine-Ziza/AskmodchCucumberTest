package customtype;

import awesomecucumber.domainobjects.BillingDetails;
import domain.BillingPage;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class CustomDataTableType {

    @DataTableType
    public BillingPage billingDetailsEntry(Map<String, String> entry){
        return new BillingPage(entry.get("firstname"),
                entry.get("lastname"),
                entry.get("address_line1"),
                entry.get("city"),
                entry.get("state"),
                entry.get("zip"),
                entry.get("email"));
    }
}
