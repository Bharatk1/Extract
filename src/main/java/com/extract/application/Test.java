	package com.extract.application;
	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	
	public class Test {
		public static Connection dbConnection = null;
		public static void main(String[] args) {
			System.out.println("Print " + dBConnectionCode2());
			
		}
	
			// TODO Auto-generated method stub
			static String dBConnectionCode2() {
				String result = null;
				Connection conn = null;
	
				try {
	
					String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
					dbDriver = System.getProperty("dbDriver", dbDriver);
					// System.out.println(dbDriver);
					try {
						Class.forName(dbDriver).newInstance(); // use java
																// reflection to
																// load the database
																// driver
					} catch (Exception ex) {
						System.out.println("failure");
					}
					// String[] clmnToFetch = clmnToFetchFromFn.split(",");
					System.out.println("running");
					String dbURL = "jdbc:sqlserver://DESKTOP-4C4VDDE\\SQLEXPRESS:1433;databaseName=TestDb;trusted_connection=Yes;integratedSecurity=true";
					String user = "Jeevi";
					String pass = "barath3011";
					/*String user = "satya\\admin";
					String pass = "satyab";*/
					conn = DriverManager.getConnection(dbURL, user, pass);
					 System.out.println("success");
					Statement stmt = conn.createStatement();
	
					ResultSet rs = stmt.executeQuery("select * from dbo.Customers where AGE=25");
	
					// System.out.println("success");
	
					while (rs.next()) {
	
						String[] arr = null;
	
						String em = rs.getString("NAME");
						arr = em.split("\n");
						for (int i = 0; i < arr.length; i++) {
							// System.out.println(arr[i]);
							result = arr[i];
	
						}
	
					}
				} catch (SQLException ex) {
					System.out.println(ex);
					System.out.println("Result set is null");
				} finally {
					try {
						if (conn != null && !conn.isClosed()) {
							conn.close();
						}
					} catch (SQLException ex) {
						System.out.println("Error connecting to Data Base");
					}
				}
	
				return result;
	
			}
		
		/*static void connectAutomationDB() {
	
			
			
			  String dbURL = "jdbc:sqlserver://ADMIN\\SQLEXPRESS:1433;databaseName=TestDb";
	
			try {
				
				
				Class.forName(System.getProperty("dbDriver", "com.microsoft.sqlserver.jdbc.SQLServerDriver")).newInstance();
				
				DriverManager.setLoginTimeout(30);
				dbConnection = DriverManager.getConnection(dbURL, "Admin", "Tulasi3@2");
			
				
			} catch (Exception Exception) {
				Exception.printStackTrace();
		
			}
		}
	
		public void disconnectDB() {
			try {
				if (this.dbConnection != null && !this.dbConnection.isClosed())
					this.dbConnection.close();
			} catch (SQLException ex) {
				System.out.println("Exception in db disconnection:" + ex.toString());
			}
		}*/
	
	}
			
			
	
