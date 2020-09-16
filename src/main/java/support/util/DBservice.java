package support.util;

public class DBservice {
	public static final String host = "127.0.0.1";
	public static final String DB_MYSQL = "MYSQL";
	public static final String DB_TYPE = DB_MYSQL;
	public static final String nameMy = "java:comp/env/jdbc/MarryMeDB";
	public static String JNDI_DB_NAME = nameMy;

	private static final String DBURL_MySQL = "jdbc:mysql://" + host
			+ "/jspdb?useUnicode=yes&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Taipei&allowPublicKeyRetrieval=true";
	public static final String USERID_MySQL = "root";
	public static final String PSWD_MySQL = "Do!ng123";


}
