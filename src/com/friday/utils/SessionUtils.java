package com.friday.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionUtils {
	public static SqlSessionFactory ssf = null;
	
	public static SqlSession getSession() throws Exception{
		if (ssf == null) {
			try {
				ssf = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("Configuration.xml"));
			} catch (Exception e) {
				throw e;
			}
		}
		
		return ssf.openSession();
	}
	
	public static void closeSession(SqlSession session) {
		if (session != null) {
			session.close();
		}
	}
}
