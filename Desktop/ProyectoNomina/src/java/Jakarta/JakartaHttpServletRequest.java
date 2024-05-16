/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dylan
 */
package jakarta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class JakartaHttpServletRequest extends HttpServletRequestWrapper {
    public JakartaHttpServletRequest(HttpServletRequest request) {
        super(request);
    }
    public String getCustomParameter(String name) {
        return getParameter(name);
    }

}
