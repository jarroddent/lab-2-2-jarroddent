// i was lazy and just made GreetingServlet in here :)

package seng2050.lab2;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GenerateValidHtml extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {

        String value = req.getParameter("name");
        String printvalue;
        if (value == null) {
            printvalue = "you didnt give me a name you might not even be a person...";
        } else if (value.contains("jarrod")) {
            printvalue = "is that my goat jarrod omg helo";
        } else {
            printvalue = "ok hi " + value + ", you aren't jarrod but it's fine";
        }

        PrintWriter out = resp.getWriter();
        out.println(HtmlGen.doctype());
        out.println("<head>");
        out.println(HtmlGen.title("Valid Title!"));
        out.println("</head>");
        out.println("<body>");
        out.println(HtmlGen.h1("Valid Heading!"));
        out.println("\t<p>Valid paragraph!");
        out.println("Presented to you by GenerateValidHTML Servlet.");
        out.println("\n" + printvalue + "</p>");
        out.println("</body>");
        out.println("</html>");

    }
}
