package spec.builders;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class SpecBuilder {

    public static RequestSpecification req;
    public static ResponseSpecification res;

    public  static RequestSpecification getRequestSpec() throws IOException
    {

        req = new RequestSpecBuilder().setContentType(ContentType.JSON).build();
        return req;

    }

    public static ResponseSpecification getResponseSpec(Integer statusCode){
        res = new ResponseSpecBuilder().expectStatusCode(statusCode).build();
        return res;
    }

    public static RequestSpecification getRequestSpecWithLogs() throws FileNotFoundException {

        PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
        req = new RequestSpecBuilder().setContentType(ContentType.JSON).
                addFilter(RequestLoggingFilter.logRequestTo(log)).
                addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
        return req;

    }

}
