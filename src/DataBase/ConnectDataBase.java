package DataBase;

import java.sql.*;

public class ConnectDataBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				 try {
			            // 1. Load the MySQL JDBC driver
			            Class.forName("com.mysql.cj.jdbc.Driver");

			            // 2. Create a database connection
			            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user	", "root", "mysql");

			            // 3. Create a statement
			            Statement st = conn.createStatement();

			            // 4. Execute a query
			            ResultSet rs = st.executeQuery("SELECT * FROM useraccount");

			            // 5. Retrieve and print data
			            ResultSetMetaData rsmd = rs.getMetaData();
			            int col = rsmd.getColumnCount(); // Determine the number of columns

			            for (int i = 1; i <= col; i++) {
			                System.out.print(rsmd.getColumnLabel(i) + "\t"); // Print column labels
			            }
			            System.out.println(); // Print a new line

			            while (rs.next()) {
			                for (int i = 1; i <= col; i++) {
			                    System.out.print(rs.getString(i) + "\t"); // Print data
			                }
			                System.out.println(); // Print a new line for each row
			            }

			            // 6. Close the resources
			            rs.close();
			            st.close();
			            conn.close();

			        } catch (ClassNotFoundException e) {
			            e.printStackTrace();
			        } catch (SQLException e) {
			            e.printStackTrace();
			        }
			}
			
		}
