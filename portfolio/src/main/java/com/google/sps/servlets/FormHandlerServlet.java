package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the values entered in the form.
    String emailValue = request.getParameter("email-input");
    String textValue = request.getParameter("text-input");

    // Print the values in the server logs.
    System.out.println("Email: " + emailValue);
    System.out.println("Message: " + textValue);

    response.sendRedirect("http://rfeckoury-sps-summer22.appspot.com");
  }
  
}