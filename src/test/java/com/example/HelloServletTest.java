package com.example;

import org.junit.Test;
import org.mockito.Mockito;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

public class HelloServletTest {

    @Test
    public void testDoGet() throws Exception {
        // Create mocks for HttpServletRequest and HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        // Create a StringWriter to capture the response output
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        // Stubbing behavior for HttpServletResponse methods
        Mockito.when(response.getWriter()).thenReturn(writer);

        // Call the servlet's doGet method
        HelloServlet helloServlet = new HelloServlet();
        helloServlet.doGet(request, response);

        // Verify that the response contains the expected content
        writer.flush();
        String output = stringWriter.toString();
        assert (output.contains("<h1>Hello, Jenkins!</h1>"));
    }
}
