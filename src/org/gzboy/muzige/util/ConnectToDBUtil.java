package org.gzboy.muzige.util;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ConnectToDBUtil {
	/**
	 * 数据库连接类
	 * @return
	 * @throws SQLException
	 * @throws java.lang.ClassNotFoundException
	 */
	public static Connection getConnection() throws SQLException,
			java.lang.ClassNotFoundException {
		String url = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_gzboyweixin?useUnicode=true&characterEncoding=utf8";
		Class.forName("com.mysql.jdbc.Driver");
		String userName = "zyl15yo2k3";
		String password = "0i3jzhzh4kw114lwlkhw50yiy4kwy021m5khih4z";
		Connection con = DriverManager.getConnection(url, userName, password);
		return con;
	}
	/**
	 * 更新用户信息
	 * @param weixin_openid
	 * @param userName
	 * @param userSex
	 * @param birthday
	 * @param phone_no
	 */
	public static void UpdateUserData(String weixin_openid, String userName,
			String userSex, String birthday, String phone_no) {
		try {
			int sex_id = 0;
			if(userSex.equals("男")){
				sex_id = 1;
			}
			Connection con = getConnection();
			Statement sql = con.createStatement();
			String query = "update user_info set user_name = '" + userName + "',sex_id = " + sex_id + " ,birthday = '" + birthday + "',phone_no = '" + phone_no + "' where weixin_openid = '" + weixin_openid + "';";
			sql.execute(query);
			sql.close();
			con.close();
		} catch (java.lang.ClassNotFoundException e) {
			System.err.println("ClassNotFoundException:" + e.getMessage());
		} catch (SQLException ex) {
			System.err.println("SQLException:" + ex.getMessage());
		}
	}
	/**
	 * 用户关注时添加用户的weixin_openid到数据库
	 * @param weixin_openid
	 */
	public static void InsertUserData(String weixin_openid) {
		try {
			Connection con = getConnection();
			Statement sql = con.createStatement();
			String query = "insert into user_info(weixin_openid) values('" + weixin_openid + "');";
			sql.execute(query);
			sql.close();
			con.close();
		} catch (java.lang.ClassNotFoundException e) {
			System.err.println("ClassNotFoundException:" + e.getMessage());
		} catch (SQLException ex) {
			System.err.println("SQLException:" + ex.getMessage());
		}
	}
	/**
	 * 用户取消关注时删除用户信息
	 * @param weixin_openid
	 */
	public static void DeleteUserData(String weixin_openid) {
		try {
			Connection con = getConnection();
			Statement sql = con.createStatement();
			String query = "insert into user_info(weixin_openid) values('" + weixin_openid + "');";
			sql.execute(query);
			sql.close();
			con.close();
		} catch (java.lang.ClassNotFoundException e) {
			System.err.println("ClassNotFoundException:" + e.getMessage());
		} catch (SQLException ex) {
			System.err.println("SQLException:" + ex.getMessage());
		}
	}
	
	public static Map SelectUserData(String weixin_openid) {
		Map<String,String> userinfoMap=new HashMap<String,String>(); 
		String userName = null;
		String userSex = null;
		String birthday = null;
		String phone_no = null;
		try {
			Connection con = getConnection();
			Statement sql = con.createStatement();
			String query = "select * from user_info where weixin_openid='" + weixin_openid + "';";
			ResultSet rs = sql.executeQuery(query);
			while(rs.next()){
				userName = rs.getString("user_name");
				int SexId = rs.getInt("sex_id");
				birthday = rs.getString("birthday");
				phone_no = rs.getString("phone_no");
				userinfoMap.put("userName",userName);
				userinfoMap.put("SexId",String.valueOf(SexId));
				userinfoMap.put("birthday",birthday);
				userinfoMap.put("phone_no",phone_no);
			}
			sql.close();
			con.close();
		} catch (java.lang.ClassNotFoundException e) {
			System.err.println("ClassNotFoundException:" + e.getMessage());
		} catch (SQLException ex) {
			System.err.println("SQLException:" + ex.getMessage());
		}
		return userinfoMap;
	}
}