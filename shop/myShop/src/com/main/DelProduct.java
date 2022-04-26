package com.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


@WebServlet("/DelProduct")
public class DelProduct extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory fact = cfg.buildSessionFactory();
		Session session = fact.openSession();
		
		Transaction t = session.beginTransaction();
		
		String str = String.format("Delete from ProductPersist where id='%s'", id);
		Query query = session.createQuery(str);
		int res = query.executeUpdate();
	
		t.commit();
		session.close();
		PrintWriter pr = response.getWriter();
		pr.println("<h1>Product deleted successfully!</h1>");
	}

}
