package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
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

    // Uses datastore to store all submitted information
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Contace Me Form");
    FullEntity taskEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("email", emailValue)
            .set("message", textValue)
            .build();
    datastore.put(taskEntity);

    response.sendRedirect("http://rfeckoury-sps-summer22.appspot.com");
  }
  
}