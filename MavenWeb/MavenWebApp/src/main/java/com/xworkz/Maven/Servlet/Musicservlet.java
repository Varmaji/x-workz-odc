package com.xworkz.Maven.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.Maven.DAO.musicDAO;
import com.xworkz.Maven.DTO.musicDTO;


public class musicservlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String musicalbum = request.getParameter("Album");
		String singer = request.getParameter("Singer");
		String company = request.getParameter("Company");
		String year = request.getParameter("year");
		

		System.out.println(musicalbum + singer + company + year );
		

		musicDTO dto=new musicDTO();
		dto.setMusicalbum(musicalbum);
		dto.setSinger(singer);
		dto.setCompany(company);
		dto.setYear(Integer.parseInt(year));
		System.out.println(dto);
		
		
		ApplicationContext container = new ClassPathXmlApplicationContext("resources/Spring.xml");
		musicDAO refOfDAO= container.getBean(musicDAO.class);
		refOfDAO.saveDataUsingSpring(dto);
		

		
		 response.setContentType("text/html");
		//setting the content type
		PrintWriter pw=response.getWriter();
		pw.println("<h1>"+musicalbum+"</h1>");
		
	}
}
