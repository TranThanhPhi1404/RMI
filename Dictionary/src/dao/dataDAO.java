package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.data;

public class dataDAO implements DAOInterface<data> {
	public static dataDAO getInstance() {
		return new dataDAO();
	}
	@Override
	public int insert(data t) throws SQLException {
		// TODO Auto-generated method stub
		int result=0;
		try {
			Connection con = new JDBCUtil().getConnection();
			Statement st =con.createStatement();
			String sql = "INSERT INTO data(vocabulary,mean)"
					+ " VALUES('"+t.getVocabulary()+"', '"+t.getMean()+"')";
			System.out.println(sql);
			
			result = st.executeUpdate(sql);
			System.out.println("Đã thêm "+result+" dòng!");
			con.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int update(data t) {
		int result=0;
		try {
			Connection con = new JDBCUtil().getConnection();
			Statement st =con.createStatement();
			String sql = "UPDATE data"
					+ " SET vocabulary= '"+t.getVocabulary()+"', mean='"+t.getMean()+"' WHERE id="+t.getId()+"";
			System.out.println(sql);
			
			result = st.executeUpdate(sql);
			System.out.println("Đã cập nhật "+result+" dòng!");
			con.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int delete(data t) {
		int result=0;
		try {
			Connection con = new JDBCUtil().getConnection();
			Statement st =con.createStatement();
			String sql = "DELETE from data"
					+ " WHERE id="+t.getId()+"";
			System.out.println(sql);
			
			result = st.executeUpdate(sql);
			System.out.println("Đã xóa "+result+" dòng!");
			con.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public ArrayList<data> selectAll() {
		ArrayList<data> result=new ArrayList<data>();
		try {
			// Tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Tạo ra đối tượng statement
			Statement st = con.createStatement();

			// Thực thi câu lệnh SQL
			String sql = "SELECT *FROM data";
			System.out.println(sql);
			 ResultSet rs=st.executeQuery(sql);
			// Thông báo:
			while(rs.next()) {
				int id = rs.getInt("id");
				String vocabulary = rs.getString("vocabulary");
				String mean = rs.getString("mean");
				
				data dt = new data(id,vocabulary,mean);
				result.add(dt);
				
			}
			// Ngắt kết nối
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public data selectById(data t) {
		data result=null;
		try {
			// Tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Tạo ra đối tượng statement
			Statement st = con.createStatement();

			// Thực thi câu lệnh SQL
			String sql = "SELECT *FROM data where id="+t.getId()+"";
			System.out.println(sql);
			 ResultSet rs=st.executeQuery(sql);
			// Thông báo:
			while(rs.next()) {
				int id = rs.getInt("id");
				String vocabulary = rs.getString("vocabulary");
				String mean = rs.getString("mean");
				
				result = new data(id,vocabulary,mean);
				
				
			}
			// Ngắt kết nối
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public data selectByVocabulary(data t) {
		data result=null;
		try {
			// Tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Tạo ra đối tượng statement
			Statement st = con.createStatement();

			// Thực thi câu lệnh SQL
			String sql = "SELECT *FROM data where vocabulary='"+t.getVocabulary()+"'";
			 ResultSet rs=st.executeQuery(sql);
			// Thông báo:
			while(rs.next()) {
				int id = rs.getInt("id");
				String vocabulary = rs.getString("vocabulary");
				String mean = rs.getString("mean");
				
				result = new data(id,vocabulary,mean);
								
			}
			// Ngắt kết nối
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<data> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
