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
			
			//atualizar registro de BD tabela vendedor. Tem que ter codição WHERE.
			st = conn.prepareStatement("UPDATE seller "
					                   + "SET BaseSalary = BaseSalary + ? "
					                   + "WHERE "
					                   + "DepartmentId = ? ");
			
			//valor que vai atualizar o salário e cód do departamento
			st.setDouble(1, 200.0);
			st.setInt(2, 2);
			
			//variável com nome rowAffected que vai receber a execução infomando linha alterada 
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
