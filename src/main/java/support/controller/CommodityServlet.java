package support.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import support.model.gordonBean;
import support.service.GordonInfoService;
import support.service.impl.GordonInfoServiceImpl;
import support.util.GlobalService;

@MultipartConfig(location = "", fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 1024 * 1024
		* 500, maxRequestSize = 1024 * 1024 * 500 * 5)

@WebServlet("/register.do")
public class CommodityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8"); // 文字資料轉內碼
		HttpSession session = request.getSession();
		Map<String, String> errorMsg = new HashMap<String, String>();
		// 準備存放註冊成功之訊息的Map物件
		Map<String, String> msgOK = new HashMap<String, String>();
		request.setAttribute("MsgMap", errorMsg); // 顯示錯誤訊息
		session.setAttribute("MsgOK", msgOK); // 顯示正常訊息
		String P_CATEGORY = "";
		String P_NAME = "";

		Blob P_COVER_Blob = null;
		long P_COVER_Size = 0;
		InputStream P_COVER_is = null;
		String P_COVER_fileName = "";

		String P_FILENAME = "";
		int P_PDQTY = 0;
		int P_PDSUM = 0;
		int P_STOCK = 0;
		int P_SDQTY = 0;
		Double P_PRICE = 0.0;

		Blob P_PIC1_Blob = null;
		long P_PIC1_Size = 0;
		InputStream P_PIC1_is = null;
		String P_PIC1_fileName = "";
		String P_FILENAME1 = "";

		Blob P_PIC2_Blob = null;
		long P_PIC2_Size = 0;
		InputStream P_PIC2_is = null;
		String P_PIC2_fileName = "";
		String P_FILENAME2 = "";

		Blob P_PIC3_Blob = null;
		long P_PIC3_Size = 0;
		InputStream P_PIC3_is = null;
		String P_PIC3_fileName = "";
		String P_FILENAME3 = "";

//		Clob P_NOTE_Clob = null;
//		long P_NOTE_Size = 0;

		Collection<Part> parts = request.getParts();

		if (parts != null) { // 如果這是一個上傳資料的表單
			for (Part p : parts) {
				String fldName = p.getName();
				Object value = request.getParameter(fldName);

				// 1. 讀取使用者輸入資料
				if (p.getContentType() == null) {
					if (fldName.equals("P_CATEGORY")) {
						P_CATEGORY = (String) value;
					} else if (fldName.equals("P_NAME")) {
						P_NAME = (String) value;
					}

					else if (fldName.equals("P_FILENAME")) {
						P_FILENAME = (String) value;
					} else if (fldName.equals("P_PDQTY")) {
						if(((String) value).trim().length() == 0) {
//							輸入為空值時歸零
							value="0";
						}
						P_PDQTY=Integer.valueOf((String) value);
					} else if (fldName.equals("P_PDSUM")) {
						if(((String) value).trim().length() == 0) {
//							輸入為空值時歸零
							value="0";
						}
						P_PDSUM=Integer.valueOf((String) value);
//						P_PDSUM = (String) value;
					} else if (fldName.equals("P_STOCK")) {
						if(((String) value).trim().length() == 0) {
//							輸入為空值時歸零
							value="0";
						}
						P_STOCK=Integer.valueOf((String) value);
						System.out.println("P_STOCK結束");
					} else if (fldName.equals("P_SDQTY")) {
						if(((String) value).trim().length() == 0) {
//							輸入為空值時歸零
							value="0";
						}
						P_SDQTY=Integer.valueOf((String) value);
//						P_SDQTY = (String) value;
						System.out.println("P_PRICE結束");
					} else if (fldName.equals("P_PRICE")) {
						if(((String) value).trim().length() == 0) {
//							輸入為空值時歸零
							value="0";
						}
						P_PRICE=Double.valueOf((String) value);
//						P_PRICE = (String) value;
					} else if (fldName.equals("P_FILENAME1")) {
						P_FILENAME1 = (String) value;
					} else if (fldName.equals("P_FILENAME2")) {
						P_FILENAME2 = (String) value;
					} else if (fldName.equals("P_FILENAME3")) {
						P_FILENAME3 = (String) value;
					}
				} else if (fldName.equals("P_COVER")) {
					// 取出圖片檔的檔名
					P_COVER_fileName = GlobalService.getFileName(p);
					// 調整圖片檔檔名的長度，需要檔名中的附檔名，所以調整主檔名以免檔名太長無法寫入表格
					P_COVER_fileName = GlobalService.adjustFileName(P_COVER_fileName,
							GlobalService.IMAGE_FILENAME_LENGTH);
					if (P_COVER_fileName != null && P_COVER_fileName.trim().length() > 0) {
						P_COVER_Size = p.getSize();
						P_COVER_is = p.getInputStream();
					}
					if (P_COVER_is != null) {
						try {
							P_COVER_Blob = GlobalService.fileToBlob(P_COVER_is, P_COVER_Size);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				} else if (fldName.equals("P_PIC1")) {
					// 取出圖片檔的檔名
					P_PIC1_fileName = GlobalService.getFileName(p);
					// 調整圖片檔檔名的長度，需要檔名中的附檔名，所以調整主檔名以免檔名太長無法寫入表格
					P_PIC1_fileName = GlobalService.adjustFileName(P_PIC1_fileName,
							GlobalService.IMAGE_FILENAME_LENGTH);
					if (P_PIC1_fileName != null && P_PIC1_fileName.trim().length() > 0) {
						P_PIC1_Size = p.getSize();
						P_PIC1_is = p.getInputStream();
					}
					if (P_PIC1_is != null) {
						try {
							P_PIC1_Blob = GlobalService.fileToBlob(P_PIC1_is, P_PIC1_Size);
						} catch (IOException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				} else if (fldName.equals("P_PIC2")) {
					// 取出圖片檔的檔名
					P_PIC2_fileName = GlobalService.getFileName(p);
					// 調整圖片檔檔名的長度，需要檔名中的附檔名，所以調整主檔名以免檔名太長無法寫入表格
					P_PIC2_fileName = GlobalService.adjustFileName(P_PIC2_fileName,
							GlobalService.IMAGE_FILENAME_LENGTH);
					if (P_PIC2_fileName != null && P_PIC2_fileName.trim().length() > 0) {
						P_PIC2_Size = p.getSize();
						P_PIC2_is = p.getInputStream();
					}
					if (P_PIC2_is != null) {
						try {
							P_PIC2_Blob = GlobalService.fileToBlob(P_PIC2_is, P_PIC2_Size);
						} catch (IOException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				} else if (fldName.equals("P_PIC3")) {
					// 取出圖片檔的檔名
					P_PIC3_fileName = GlobalService.getFileName(p);
					// 調整圖片檔檔名的長度，需要檔名中的附檔名，所以調整主檔名以免檔名太長無法寫入表格
					P_PIC3_fileName = GlobalService.adjustFileName(P_PIC3_fileName,
							GlobalService.IMAGE_FILENAME_LENGTH);
					if (P_PIC3_fileName != null && P_PIC3_fileName.trim().length() > 0) {
						P_PIC3_Size = p.getSize();
						P_PIC3_is = p.getInputStream();
					}
					if (P_PIC3_is != null) {
						try {
							P_PIC3_Blob = GlobalService.fileToBlob(P_PIC3_is, P_PIC3_Size);
						} catch (IOException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}

			}
		}
		try {
			// 4. 產生MemberDao物件，以便進行Business Logic運算
			// MemberDaoImpl_Jdbc類別的功能：
			// 1.檢查帳號是否已經存在，已存在的帳號不能使用，回傳相關訊息通知使用者修改
			// 2.若無問題，儲存會員的資料
			GordonInfoService service = new GordonInfoServiceImpl();

			gordonBean mem = new gordonBean(0, P_CATEGORY, P_NAME, P_COVER_Blob, P_FILENAME, P_PDQTY, P_PDSUM, P_STOCK,
					P_SDQTY, P_PRICE, P_PIC1_Blob, P_FILENAME1, P_PIC2_Blob, P_FILENAME2, P_PIC3_Blob, P_FILENAME3);

			int n = service.saveproduct(mem);
			if (n == 1) {
				msgOK.put("InsertOK", "<Font color='red'>新增成功，請開始使用本系統</Font>");
				response.sendRedirect("./index.jsp");
				return;
			} else {
				errorMsg.put("errorIdDup", "新增此筆資料有誤(RegisterServlet)");
			}

		} catch (Exception e) {
			e.printStackTrace();
			errorMsg.put("errorIdDup", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("./commodity/AddCommodity.jsp");
			rd.forward(request, response);
		}
	}
}
