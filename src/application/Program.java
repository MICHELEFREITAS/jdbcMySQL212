package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			
			//atualizar registro de BD tabela vendedor. Tem que ter codi��o WHERE.
			st = conn.prepareStatement("UPDATE seller "
					                   + "SET BaseSalary = BaseSalary + ? "
					                   + "WHERE "
					                   + "DepartmentId = ? ");
			
			//valor que vai atualizar o sal�rio e c�d do departamento
			st.setDouble(1, 200.0);
			st.setInt(2, 2);
			
			//vari�vel com nome rowAffected que vai receber a execu��o infomando linha alterada 
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! " + rowsAffected);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
