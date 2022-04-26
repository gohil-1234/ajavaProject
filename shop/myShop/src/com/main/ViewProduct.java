package com.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
import org.hibernate.query.Query;

@WebServlet("/ViewProduct")
public class ViewProduct extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory fact = cfg.buildSessionFactory();
		Session session = fact.openSession();
		
		Transaction t = session.beginTransaction();
		
		String str = String.format("select id,name,price from ProductPersist where id='%s'", id);
		Query query = session.createQuery(str);
		List<ProductPersist> data = query.list();
		request.setAttribute("data", data.get(0));

		RequestDispatcher rd = request.getRequestDispatcher("product.jsp");
		rd.forward(request, response);
		System.out.println(data.get(0));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
