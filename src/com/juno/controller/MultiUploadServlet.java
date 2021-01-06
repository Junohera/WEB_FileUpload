package com.juno.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class MultiUploadServlet
 */
@WebServlet("/upload2.do")
public class MultiUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultiUploadServlet() {
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
		response.setContentType("text/html; charset=UTF-8");
		
		
		String savePath = "fileUpload";
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		
		PrintWriter out = response.getWriter();
		
		try {
			MultipartRequest multi = new MultipartRequest(
					request,
					uploadFilePath,
					5*1024*1024,
					"UTF-8",
					new DefaultFileRenamePolicy()
			);
			/*
				이전 예제에서 getfileSystemName() 메서드로 파일 이름을 얻어내고 그 외 항목도
				getParameter()를 사용했지만, 현재는 여러 파일이 동시 업로드 되었기때문에
				Enumeration 을 이용하며 업로드된 내용을 하나씩 접근하고 접근한 객체에
				getFileSystemName과 parameter를 사용합니다.
			*/
			Enumeration files = multi.getFileNames();
			// multi.getFileNames(); 전송된 태그 name과 실제 파일이름이 저장되어 있는 파일이름 객체 리스트
			while (files.hasMoreElements()) {
				String file = (String) files.nextElement(); // 다음 파일 추출
				String file_name = multi.getFilesystemName(file); // 업로드된 파일이름 추출
				String org_file_name = multi.getOriginalFileName(file); // 실제파일 이름 추출
				
				out.print("<br> 업로드된 파일명 : " + file_name);
				out.print("<br> 원본파일명 : " + org_file_name);
				out.print("<hr>");
			}
			
		} catch (Exception e) {
			
		}
	}

}
