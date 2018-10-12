package fr.amu.servlets;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;
import java.io.Serializable;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;


@WebServlet(
        name = "MaServlet",
        urlPatterns = {"/hello","/bonjour"}
)
public class HelloServlet extends HttpServlet implements Serializable {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ServletOutputStream out = resp.getOutputStream();
		out.println("Bonjour");
		out.close();
	}
}
