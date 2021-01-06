package com.juno.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
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
		request.setCharacterEncoding("UTF-8");

		// 웹브라우저에 직접 내용을 써넣기 위한 ContentType 설정
		response.setContentType("text/html; charset=UTF-8");
		// JSP파일을 만들어두고 forward하는게 아니라 서블릿에서 직접 브라우저에 내용을 넣습니다.

		// 브라우저에 쓰기를 위한 객체 생성
		PrintWriter out = response.getWriter();
		
		// 파일이 업로드될 타겟 폴더 이름 설정
		String savePath = "fileUpload";
		
		// 업로드 되는 파일의 최대 용량을 제한하기 위한 설정
		int uploadFileSizeLimit = 5 * 1024 * 1024; // 5MB

		// korean encoding
		String encType = "UTF-8";

		// server directory
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println(uploadFilePath);
		try {
			MultipartRequest multi = new MultipartRequest(
					request, // 현재의 request 객체 : 한페이지에 두개의 리퀘스트가 존재하게 하지 않기 위해 MultipartRequest안에 request객체를 담아서 사용합니다.
					uploadFilePath, // physical path
					uploadFileSizeLimit, // upload limit size
					encType, // encoding 
					new DefaultFileRenamePolicy() // 업로드 파일과 동일 이름이 이미 존재하면 새이름 부여(중복방지)
					);
			// 위 명령에서 MultipartRequest 객체가 만들어지는 순간 파일은 먼저 업로드 됩니다.

			// jsp 파일의 form 에서 전달된 파일의 이름 및 그 외 항목들을 파라미터로 추출
			String fileName = multi.getFilesystemName("uploadFile"); 	// input:file uploadFile
			String name = multi.getParameter("name"); 					// input:text name
			String title = multi.getParameter("title"); 				// input:title title
			
			out.println("<br>writer : " + fileName);
			out.println("<br>title : " + name);
			out.println("<br>fileName : " + title);
		} catch (Exception e) {
			System.out.println("File Upload Exception : " + e);
		}
			
	}

}
