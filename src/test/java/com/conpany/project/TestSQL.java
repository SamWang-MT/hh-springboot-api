package com.conpany.project;

import java.sql.*;
public class TestSQL {
	
	 
		public static void main(String[] args) {
			String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";//设置SQL Server数据库引擎
			String connectDB = "jdbc:sqlserver://10.90.48.51:2071;DatabaseName=HR_CHINA";//指定数据库
			try {
				Class.forName(JDriver);//加载数据库引擎
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.exit(0);
			}
	 
			try {
				String user = "wechatwrite";
				String password = "6XHm%Qrowrite";//登陆密码
				Connection con = DriverManager.getConnection(connectDB, user, password);//连接数据库
				System.out.println("连接数据库成功");
				Statement cmd = con.createStatement();//创建SQL命令对象
			/*
			 * //创建表 String create = "create table PERSON(" + "ID NCHAR(2)," +
			 * "NAME NCHAR(10)" + ")"; cmd.executeUpdate(create);// 执行SQL命令对象
			 * 
			 * //输入数据 String insert1 = "INSERT INTO PERSON VALUES('1','Jone')"; String
			 * insert2 = "INSERT INTO PERSON VALUES('2','Mike')"; String insert3 =
			 * "INSERT INTO PERSON VALUES('3','Bob')";
			 * cmd.executeUpdate(insert1);//执行SQL命令对象 cmd.executeUpdate(insert2);
			 * cmd.executeUpdate(insert3);
			 */
				//读取数据
				System.out.println("开始读取数据");
				ResultSet rs = cmd.executeQuery(
						"SELECT COLLATIONPROPERTY('Chinese_PRC_Stroke_CI_AI_KS_WS', 'CodePage') "
//						 " SELECT * FROM  local_sap_data.ChemicalWMStorageDetail"
//						" SELECT * FROM  ChemicalWMStock2"
//						"Select Name FROM SysObjects Where XType='U' orDER BY Name"
				);
				
				int index = 0;
				while (rs.next()) {
//					System.out.println( ++index + ":"+  rs.getString("StorageBin") + "\t" + rs.getString("MaterialNo"));
//					System.out.println( ++index + ":"+  rs.getString("storageId") );
					System.out.println( rs.toString() );
				}
	 
				// 关闭连接
				cmd.close();//关闭命令对象连接
				con.close();//关闭数据库连接
			} catch (SQLException e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
}
