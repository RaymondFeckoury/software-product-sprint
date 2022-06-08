package com.google.sps.servlets;

import java.util.*;
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Creates a list of fun facts
    ArrayList<String> messages = new ArrayList<>();
    messages.add("My mom is an immigrant from France, and we have spent many summers there visiting friends and family!");
    messages.add("I raced motocross for a few years, and won a championship in a series that travels to almost every race track in Georgia.");
    messages.add("I earned my private pilots license while I was in high school, and I hope to begin flying again once graduate from college.");
    messages.add("In my free time I enjoy spending time in the outdoors as well as hitting the gym with my friends!");
    
    // Converts the list to json format
    String json = convertToJsonUsingGson(messages);

    // Send the JSON as the response
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }

  /**
   * Converts a ServerStats instance into a JSON string using the Gson library. Note: We first added
   * the Gson library dependency to pom.xml.
   */
  private String convertToJsonUsingGson(ArrayList<String> messages) {
    Gson gson = new Gson();
    String json = gson.toJson(messages);
    return json;
  }

}