package _02_login.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _00_init.util.GlobalService;
// 本過濾器監控 /_02_login/login.jsp。
// 當使用者要求此jsp時，容器會將本jsp網頁轉譯為java程式，接者編譯為類別檔，然後載入並執行此jsp。
// 當容器執行jsp之前會先執行本過濾器。其目的是要檢視瀏覽器送來的Cookie中是否含有帳、密等資料。
// 如果有，取出來，將密碼解密，然後存入Request物件內，以便jsp能將其加入相關之input標籤的value屬性內。

@WebFilter("/_02_login/login.jsp")
public class FindUserPassword implements Filter {
	String requestURI;
	public FindUserPassword() {

	}	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 容器會在遠方客戶端提出請求、要求容器執行_02_login/login.jsp前，先執行本程式
		if (request instanceof HttpServletRequest
				&& response instanceof HttpServletResponse) {
			HttpServletRequest req = (HttpServletRequest) request;
			// **********Remember Me****************
			String cookieName = "";
			String user = "";
			String password = "";
			String rememberMe = "";
			// 取出瀏覽器送來的Cookie
			Cookie[] cookies = req.getCookies();
			if (cookies != null) {   						// 如果含有Cookie
				for (int i = 0; i < cookies.length; i++) {	// 檢視每個Cookie
					cookieName = cookies[i].getName();
					if (cookieName.equals("user")) {
						//找到user這個Cookie
						user = cookies[i].getValue();
					} else if (cookieName.equals("password")) {
						//找到password這個Cookie						
						String tmp  = cookies[i].getValue();
						// 將密碼解密
						if (tmp!= null){
							password = 	GlobalService.decryptString(
									        GlobalService.KEY, tmp);
						}
					} 
					else if (cookieName.equals("rm")) {
						//找到rm這個Cookie(rm: rememberMe)
						rememberMe = cookies[i].getValue();
					}
				}
			} else {
				// 找不到Cookie，沒有關係，就讓使用者輸入資料即可。
			}
			// 將這三項資料存入request物件
			request.setAttribute("rememberMe", rememberMe);
			request.setAttribute("user", user);
			request.setAttribute("password", password);
		}
		chain.doFilter(request, response);   // 請容器執行下一棒程式
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}
	@Override
	public void destroy() {
	}
	
}
