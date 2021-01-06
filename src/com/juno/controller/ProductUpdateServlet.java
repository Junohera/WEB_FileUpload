package com.juno.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.juno.dao.ProductDAO;
import com.juno.dto.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class ProductUpdateServlet
 */
@WebServlet(name = "productupdate.do", urlPatterns = { "/productupdate.do" })
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		request.setAttribute("product", ProductDAO.getIst().getProductOne(code));
		RequestDispatcher rd = request.getRequestDispatcher("product/productUpdate.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("fileUpload");
		
		
		MultipartRequest multi = new MultipartRequest(
				request
				, path
				, 20 * 1024 * 1024
				, "UTF-8"
				, new DefaultFileRenamePolicy()
		);
		
		int code = Integer.parseInt(multi.getParameter("code"));
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String description = multi.getParameter("description");
		String pictureurl = multi.getFilesystemName("pictureurl");
		
		if (pictureurl == null) {
			pictureurl = multi.getParameter("nonUpdateImg");
		}
		
		ProductVO product = new ProductVO();
		product.setCode(code);
		product.setName(name);
		product.setPrice(price);
		product.setDescription(description);
		product.setPictureurl(pictureurl);
		
		ProductDAO.getIst().updateProduct(product);
		
		RequestDispatcher rd = request.getRequestDispatcher("view.do?code=" + code);
		rd.forward(request, response);
	}

}
