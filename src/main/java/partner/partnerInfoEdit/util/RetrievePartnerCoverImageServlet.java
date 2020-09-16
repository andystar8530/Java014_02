package partner.partnerInfoEdit.util;

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

import partner.partnerInfoEdit.model.PartnerBean;
import partner.partnerInfoEdit.service.PartnerService;
import partner.partnerInfoEdit.service.Impl.PartnerServiceImpl;

//@WebServlet("/util/getPartnerCoverImage")
public class RetrievePartnerCoverImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		OutputStream os = null;
		InputStream is = null;
		String p_covFilename = null;
		String mimeType = null;
		Blob blob = null;
		try {
			// 讀取瀏覽器傳送來的主鍵
			String m_No = request.getParameter("m_No");
			// 讀取瀏覽器傳送來的type，以分辨要處理哪個表格
			PartnerService partnerService = new PartnerServiceImpl();
			PartnerBean bean = partnerService.queryPartner(m_No);
			
			if (bean != null) {
				blob = bean.getP_coverPic();
				if (blob != null) { //有bean不一定有圖
					is = blob.getBinaryStream();
				}
				p_covFilename = bean.getP_covFilename();
			}
			// 如果圖片的來源有問題，就送回預設圖片(/images/NoImage.png)	
			if (is == null) {
				p_covFilename = "NoImage.png" ; 
				is = getServletContext().getResourceAsStream(
						"data/Image/" + p_covFilename);
			}
			
			// 由圖片檔的檔名來得到檔案的MIME型態
			mimeType = getServletContext().getMimeType(p_covFilename);
			// *****設定輸出資料的MIME型態
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
		throw new RuntimeException("partner.util.RetrievePartnerImageServlet#doGet()發生SQLException: " + ex.getMessage());
	}finally
	{
		if (is != null)
			is.close();
		if (os != null)
			os.close();

	}
}}