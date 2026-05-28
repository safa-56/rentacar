package com.turkcell.rentacar.core.utilities.exceptions.problemDetails;

public class BusinessProblemDetails extends ProblemDetails{
    public BusinessProblemDetails() {
        // bunlar standart olduğu için direkt atama yaptık. detail kısmı hataya göre değişecek
        setTitle("Business Rule Violation");
        setType("http://mydomain.com/exceptions/business");
        setStatus("400");
    }
}
