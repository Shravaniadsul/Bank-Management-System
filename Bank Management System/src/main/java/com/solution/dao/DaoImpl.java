package com.solution.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.solution.Employee.Employee;
import com.solution.util.JDBCUtil;

public class DaoImpl implements IDao{

	@Override
	public Employee select(int Serial_no) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		Employee emp = null;
		
		try {
			connection  = JDBCUtil.getConnection();
			
			String sqlSelectQuery = "SELECT * FROM branch WHERE Serial_no= ?";
			
			if(connection != null) {
				pstmt = connection.prepareStatement(sqlSelectQuery);
			}
			
			if(pstmt != null) {
				pstmt.setInt(1, Serial_no);
				
				resultSet = pstmt.executeQuery();
			}
			
			if(resultSet != null) {
			   emp = new Employee();
				while(resultSet.next()) {
			   emp.setSerial_no(resultSet.getInt(1));
			   emp.setName(resultSet.getString(2));
			   emp.setAccount_no(resultSet.getLong(3));
			   emp.setIFSC_no(resultSet.getString(4));
			   emp.setBalance(resultSet.getInt(5));

				}
				return emp;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				JDBCUtil.cleanUp(connection, pstmt, resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
		
	}

	@Override
	public Integer insert(Employee emp) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		Integer rowCount = null;
		
		
		try {
			connection  = JDBCUtil.getConnection();
			
			String sqlInsertQuery = "Insert into branch(Serial_no,Name,Account_no,IFSC_no,Balance) values (?,?,?,?,?)";
			if(connection != null) {
				pstmt = connection.prepareStatement(sqlInsertQuery);
			}
			
			if(pstmt != null) {
				pstmt.setInt(1, emp.getSerial_no());
				pstmt.setString(2, emp.getName());
				pstmt.setLong(3, emp.getAccount_no());
				pstmt.setString(4, emp.getIFSC_no());
				pstmt.setInt(5,emp.getBalance());
				
				 rowCount = pstmt.executeUpdate();
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				JDBCUtil.cleanUp(connection, pstmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowCount;
		
		
	}

	
	
	@Override
	public Integer delete(int Serial_no) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		Integer rowCount = null;
		
		
		try {
			connection  = JDBCUtil.getConnection();
			
			String sqlDeleteQuery = "Delete from branch Where Serial_no= ?";
			if(connection != null) {
				pstmt = connection.prepareStatement(sqlDeleteQuery);
			}
			
			if(pstmt != null) {
				pstmt.setInt(1,Serial_no);
				 rowCount = pstmt.executeUpdate();
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				JDBCUtil.cleanUp(connection, pstmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowCount;
		
		
			
	}



	@Override
	public Integer update(Employee emp) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		Integer rowCount = null;
		
		try {
			connection  = JDBCUtil.getConnection();
			
			String sqlUpdateQuery = "Update branch set name=?,account_no=?,IFSC_no=?,Balance=? WHERE Serial_no= ?";
			
			if(connection != null) {
				pstmt = connection.prepareStatement(sqlUpdateQuery);
			}
			
			
			if(pstmt != null) {
				pstmt.setString(1, emp.getName());
				pstmt.setLong(2, emp.getAccount_no());
				pstmt.setString(3, emp.getIFSC_no());
				pstmt.setInt(4, emp.getBalance());
				pstmt.setInt(5, emp.getSerial_no());
				
				 rowCount = pstmt.executeUpdate();
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				JDBCUtil.cleanUp(connection, pstmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowCount;
	}
}
