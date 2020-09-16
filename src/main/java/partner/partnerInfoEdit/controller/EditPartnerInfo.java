package partner.partnerInfoEdit.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
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

import _00_init.util.GlobalService;
import ch01_h_register.model.MemberBean;
import ch01_h_register.service.MemberService;
import partner.partnerInfoEdit.model.PartnerBean;
import partner.partnerInfoEdit.service.PartnerService;
import partner.partnerInfoEdit.service.Impl.PartnerServiceImpl;

@MultipartConfig(location = "", fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 1024 * 1024
		* 500, maxRequestSize = 1024 * 1024 * 500 * 5)
//@WebServlet("/partnerInfoEdit.do")
public class EditPartnerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8"); // 文字資料轉內碼
		// 準備存放錯誤訊息的Map物件
		Map<String, String> errorMsg = new HashMap<String, String>();
		// 準備存放註冊成功之訊息的Map物件
		Map<String, String> msgOK = new HashMap<String, String>();
		// 註冊成功後將用response.sendRedirect()導向新的畫面，所以需要
		// session物件來存放共用資料。
		HttpSession session = request.getSession();
		request.setAttribute("MsgMap", errorMsg); // 顯示錯誤訊息
		session.setAttribute("MsgOK", msgOK); // 顯示正常訊息

		String p_info = "";
		String p_mId = "";
		String p_storeName = "";
		Blob p_coverPic = null;
		String p_covFilename = "";
		Blob p_stamp = null;
		String p_staFilename = "";
		String p_service = "";
		String p_area = "";
		String p_lineId = "";
		String p_hRate = "";
		String p_bankAcc = "";
		Timestamp p_createTime = null;
		Timestamp p_editTime = null;
		long cov_sizeInBytes = 0;
		long sta_sizeInBytes = 0;
		InputStream cis = null;
		InputStream sis = null;
		Blob cov_blob = null;
		Blob sta_blob = null;
		String cov_fileName = "";		
		String sta_fileName = "";		
		int parea = 0;
		int phRate = 0;
		int pmId = 0;
		int pbankAcc = 0;

		// 取出HTTP multipart request內所有的parts
		Collection<Part> parts = request.getParts();
//		GlobalService.exploreParts(parts, request);
		// 由parts != null來判斷此上傳資料是否為HTTP multipart request
		if (parts != null) { // 如果這是一個上傳資料的表單
			for (Part p : parts) {
				String fldName = p.getName();
				String value = request.getParameter(fldName);

				// 1. 讀取使用者輸入資料 //String getContentType()：
				// 取得 Part 物件的 Content-Type 表頭內容。如果是一般的欄位或是沒有上傳資料的話會得到 null。
				if (p.getContentType() == null) {
					if (fldName.equals("p_info")) {
						p_info = value;
						System.out.println("p_info = " + p_info);
					} else if (fldName.equals("p_mId")) {
						p_mId = value;
						System.out.println("p_mId = " + p_mId);
					} else if (fldName.equals("p_storeName")) {
						p_storeName = value;
						System.out.println("p_storeName = " + p_storeName);
					} else if (fldName.equals("p_coverPic")) {
						p_covFilename = value;
					} else if (fldName.equals("serviceRadios")) {
						p_service = value;
						System.out.println("service = " + p_service);
					} else if (fldName.equals("areaRadios")) { // 要型態轉換
						p_area = value;
						System.out.println("area = " + p_area);
					} else if (fldName.equals("p_lineId")) {
						p_lineId = value;
						System.out.println("p_lineId = " + p_lineId);
					} else if (fldName.equals("p_bankAcc")) { // 要型態轉換
						p_bankAcc = value;
						System.out.println("p_bankAcc = " + p_bankAcc);
					} else if (fldName.equals("p_hRate")) { // 要型態轉換
						p_hRate = value;
						System.out.println("p_hRate = " + p_hRate);
					}
				} else if(p.getContentType() != null && fldName.equals("p_coverPic")){
					// 取出圖片檔的檔名
					cov_fileName = GlobalService.getFileName(p);
					// 調整圖片檔檔名的長度，需要檔名中的附檔名，所以調整主檔名以免檔名太長無法寫入表格
					cov_fileName = GlobalService.adjustFileName(cov_fileName, GlobalService.IMAGE_FILENAME_LENGTH);
					if (cov_fileName != null && cov_fileName.trim().length() > 0) {
						cov_sizeInBytes = p.getSize();
						cis = p.getInputStream();
					} else {
						errorMsg.put("errPicture", "必須挑選圖片檔");
					}
				}else if(p.getContentType() != null && fldName.equals("p_stamp")) {
					sta_fileName = GlobalService.getFileName(p);
					// 調整圖片檔檔名的長度，需要檔名中的附檔名，所以調整主檔名以免檔名太長無法寫入表格
					sta_fileName = GlobalService.adjustFileName(sta_fileName, GlobalService.IMAGE_FILENAME_LENGTH);
					if (sta_fileName != null && sta_fileName.trim().length() > 0) {
						sta_sizeInBytes = p.getSize();
						sis = p.getInputStream();
					} else {
						errorMsg.put("errPicture", "必須挑選圖片檔");
					}
				}
			}
			// 2. 進行必要的資料轉換
			try {
				parea = Integer.parseInt(p_area);
				pmId = Integer.parseInt(p_mId);
				phRate = Integer.parseInt(p_hRate);
//				System.out.println(phRate+50);
	

			} catch (NumberFormatException e) {

				System.out.println(e.getMessage());
			}
//			Date editTime = Date.valueOf(p_editTime);

			// 3. 檢查使用者輸入資料
			if (p_storeName == null || p_storeName.trim().length() == 0) {
				errorMsg.put("errorStoreNameEmpty", "店家名稱必須輸入");
			}
			if (p_info == null || p_info.trim().length() == 0) {
				errorMsg.put("errorInfoEmpty", "簡介欄必須輸入30字以上");
			}
			if (p_service == null || p_service.trim().length() == 0) {
				errorMsg.put("errorServiceEmpty", "主要服務必須選擇");
			}
			if (p_area == null || p_area.trim().length() == 0) {
				errorMsg.put("errorAreaEmpty", "服務區域必須選擇");
			}
			if (p_lineId == null || p_lineId.trim().length() == 0) {
				errorMsg.put("errorLineId", "LineId必須輸入");
			}
			if (p_bankAcc == null || p_bankAcc.trim().length() == 0) {
				errorMsg.put("errorbankAcc", "銀行帳戶必須輸入");
			}
			if (p_hRate == null || p_hRate.trim().length() == 0) {
				errorMsg.put("errorHRate", "預估時薪必須輸入");
			}

		} else {
			errorMsg.put("errTitle", "此表單不是上傳檔案的表單");
		}

		// 如果有錯誤
		if (!errorMsg.isEmpty()) {
//			Set<String> set = errorMsg.keySet();
//			for(String s : set) {
//				System.out.println(s);
//			}
			// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
			RequestDispatcher rd = request.getRequestDispatcher("/partner/partnerInfoEdit.jsp");
			rd.forward(request, response);
			return;
		}
		try {
			// 4. 產生PartnerDao物件，以便進行Business Logic運算
			// PartnerImpl_Jdbc類別的功能：
			// 若無問題，儲存合作商的資料
			PartnerService service = new PartnerServiceImpl();
//			MemberInfoBean member = (MemberInfoBean) session.getAttribute("LoginOK");
			MemberBean member = (MemberBean) session.getAttribute("LoginOK");
			String mNo =String.valueOf(member.getM_No()); 
			if (!service.idExists(mNo)) {
				// 如果沒有這個會員編號存在partner表格，則新增一筆紀錄
				
//				Blob blob =null
				if (cis != null) {
					cov_blob = GlobalService.fileToBlob(cis, cov_sizeInBytes);
				}
				if (sis != null) {
					sta_blob = GlobalService.fileToBlob(sis, sta_sizeInBytes);
				}
				Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());
				PartnerBean bean = new PartnerBean(
						0, 0, p_storeName, sta_blob, cov_blob, p_service, 
						p_info, parea, 0.0, p_lineId, p_bankAcc,
						Integer.parseInt(p_hRate), ts, ts, cov_fileName,
						sta_fileName);
//				PartnerBean bean = (PartnerBean) session.getAttribute("partnerBean");

				int n = service.savePartner(bean);
				if (n == 1) {
					System.out.println("新增成功");
//					msgOK.put("InsertOK", "<Font color='red'>新增成功，請開始使用本系統</Font>");
//					response.sendRedirect("/displayPartnerInfo.do");
					request.getRequestDispatcher("/displayPartnerInfo.do").forward(request, response);
					return;
				} else {
					System.out.println("修改此筆資料有誤(EditPartnerInfoServlet)");
					errorMsg.put("errorIdDup", "修改此筆資料有誤(EditPartnerInfoServlet)");
				}
			} else {
				// 為了配合Hibernate的版本。
				// 要在此加密，不要在 dao.saveMember(mem)進行加密

				Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());

				// 將所有合作商資料封裝到PartnerBean(類別的)物件
				/*
				PartnerBean bean = new PartnerBean(0, pmId, p_storeName, p_stamp, p_coverPic, p_service, p_info,
						parea, 0.0, p_lineId, p_bankAcc, phRate, p_createTime, p_editTime, p_covFilename,
						p_staFilename);
//
				 */
//				PartnerBean bean = (PartnerBean) session.getAttribute("partnerBean");
				if (cis != null) {
					cov_blob = GlobalService.fileToBlob(cis, cov_sizeInBytes);
				}
				if (sis != null) {
					sta_blob = GlobalService.fileToBlob(sis, sta_sizeInBytes);
				}
//				MemberInfoService service2 = new MemberInfoServiceImpl();
//				MemberInfoBean mb = service2.queryMember(p_mId);
				MemberService service2 = new MemberService();
				MemberBean mb = service2.get(Integer.valueOf(p_mId));
				Timestamp t = mb.getM_CreateTime();	
				PartnerBean bean = new PartnerBean(0, pmId, p_storeName, sta_blob, cov_blob, p_service, p_info,
						parea, 0.0, p_lineId, p_bankAcc, phRate, t, ts, cov_fileName,
						sta_fileName);
//
//			bean.setP_stamp(p_stamp);
//			bean.setP_staFilename(p_staFilename);
//			bean.setP_coverPic(p_coverPic);
//			bean.setP_covFilename(p_covFilename);
//			bean.setP_info(p_info);
//			bean.setP_area(parea);
//			bean.setP_lineId(p_lineId);
//			bean.setP_bankAcc(p_bankAcc);
//			bean.setP_hRate(phRate);
//			Date d = new Date();
//			bean.setP_editTime( new Timestamp(System.currentTimeMillis()));
				// 呼叫PartnerBean的updatePartner方法
				int n = service.updatePartner(bean);
				if (n == 1) {
					System.out.println("修改成功");
//					HttpSession secondSession = request.getSession();
//					secondSession.setAttribute("PartnerBean", bean);
//					msgOK.put("InsertOK", "<Font color='red'>新增成功，請開始使用本系統</Font>");
//					response.sendRedirect("/partner/partner.jsp");
					request.getRequestDispatcher("/displayPartnerInfo.do").forward(request, response);
					return;
				} else {
					System.out.println("修改此筆資料有誤(EditPartnerInfoServlet)");
					errorMsg.put("errorIdDup", "修改此筆資料有誤(EditPartnerInfoServlet)");
				}

//			// 5.依照 Business Logic 運算結果來挑選適當的畫面
				if (!errorMsg.isEmpty()) {
					// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
					RequestDispatcher rd = request.getRequestDispatcher("/partner/partnerInfoEdit.jsp");
					rd.forward(request, response);
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorMsg.put("errorIdDup", e.getMessage());
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/partner/partnerInfoEdit.jsp");
			rd.forward(request, response);
		}
// 	}
//
	}

	public static String getDateTime() {
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		String strDate = sdFormat.format(date);
		// System.out.println(strDate);
		return strDate;
	}

}
