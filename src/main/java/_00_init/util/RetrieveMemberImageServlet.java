package _00_init.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _01_register.model.MemberInfoBean;
import _01_register.service.MemberInfoService;
import _01_register.service.impl.MemberInfoServiceImpl;

@WebServlet("/_00_init/getMemberImage")
public class RetrieveMemberImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		OutputStream os = null;
		InputStream is = null;
		String fileName = null;
		String mimeType = null;
		Blob blob = null;
		try {
			// 讀取瀏覽器傳送來的主鍵
			String id = request.getParameter("id");
			// 讀取瀏覽器傳送來的type，以分辨要處理哪個表格
			MemberInfoService memberInfoService = new MemberInfoServiceImpl();
			MemberInfoBean bean = memberInfoService.queryMember(id);
			if (bean != null) {
				blob = bean.getM_Propic();
				if (blob != null) { 
					is = blob.getBinaryStream();
				}
				fileName = bean.getM_FileName();
			}
			// 如果圖片的來源有問題，就送回預設圖片(/images/NoImage.png)	
			if (is == null) {
				fileName = "NoImage.png" ; 
				is = getServletContext().getResourceAsStream(
						"/images/" + fileName);
			}
			
			// 由圖片檔的檔名來得到檔案的MIME型態
			mimeType = getServletContext().getMimeType(fileName);
			// 設定輸出資料的MIME型態
			response.setContentType(mimeType);
			// 取得能寫出非文字資料的OutputStream物件
			os = response.getOutputStream();	
			// 由InputStream讀取位元組，然後由OutputStream寫出
			int len = 0;
			byte[] bytes = new byte[8192];
			while ((len = is.read(bytes)) != -1) {
				os.write(bytes, 0, len);
			}
		}catch(

	SQLException ex)
	{
		ex.printStackTrace();
		throw new RuntimeException("_00_init.util.RetrieveMemberImageServlet#doGet()發生SQLException: " + ex.getMessage());
	}finally
	{
		if (is != null)
			is.close();
		if (os != null)
			os.close();

	}
}}