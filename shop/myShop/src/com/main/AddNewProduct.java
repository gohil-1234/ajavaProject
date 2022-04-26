package com.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@WebServlet("/AddNewProduct")
public class AddNewProduct extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("addproduct.html");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory fact = cfg.buildSessionFactory();
		Session session = fact.openSession();
		
		Transaction t = session.beginTransaction();
		ProductPersist p = new ProductPersist();
		p.setName(name);
		p.setPrice(price);
		session.persist(p);
		t.commit();
		session.close();
		PrintWriter pr = response.getWriter();
		pr.println("<h1>Product added successfully!</h1>");
	}

}
