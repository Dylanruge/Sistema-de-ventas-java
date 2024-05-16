/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



package jakarta;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.PrintWriter;

public class JakartaHttpServletResponse extends HttpServletResponseWrapper {
    public JakartaHttpServletResponse(HttpServletResponse response) {
        super(response);
    }

    public void setCustomHeader(String name, String value) {
        addHeader(name, value);
    }

    public void writeCustomResponse(String message) {
        try {
            PrintWriter out = getWriter();
            out.println(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
