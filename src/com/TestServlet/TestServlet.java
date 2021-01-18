package com.TestServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

//import org.apache.commons.collections.keyvalue.TiedMapEntry;


/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		if (request.getParameter("submit").equals("serialize")) {
			NewClass test = new NewClass();
			
			test.setUsername(request.getParameter("username"));
			test.setEmail(request.getParameter("email"));
			test.setDob(request.getParameter("dob"));
			test.setGender(request.getParameter("gender"));
			
			final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			final ObjectOutputStream objectOutputStream;
			
			try {
				objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
				objectOutputStream.writeObject(test);
				objectOutputStream.close();
				String serialize = Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
				request.setAttribute("serialized", serialize);
				
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} catch (IOException e) {
				throw new Error(e);
			}
		} else {
			byte[] decoded = Base64.getDecoder().decode(request.getParameter("serialized"));

			ByteArrayInputStream in = new ByteArrayInputStream(decoded);
			ObjectInputStream is = new ObjectInputStream(in);
			try {
				NewClass test = (NewClass) is.readObject();
				request.setAttribute("deserialized", test);

				request.getRequestDispatcher("index.jsp").forward(request, response);
			} catch (Exception e) {
				throw new Error(e);
			}
		}
	}
}
