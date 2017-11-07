package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Article;
import util.Pool;

public class ArticleDaoImpl implements ArticleDao{
    private static Pool pool = new Pool();
    private static Connection ct;
	@Override
	public boolean save(Article art) {
		ct = pool.getConnection();
		String sql = "insert into essay(content) value(?)";
		try {
			PreparedStatement psmt = ct.prepareStatement(sql);
			psmt.setString(1, art.getContent());
			psmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ct.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public Article get(int id) {
		ct = pool.getConnection();
		String sql = "select * from essay where id=?";
		try {
			PreparedStatement psmt = ct.prepareStatement(sql);
		    psmt.setInt(1, id);
		    ResultSet rs = psmt.executeQuery();
		    
		    if (rs.next()) {
		    	return new Article(rs.getInt(1),rs.getString(2));
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ct.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List getAll() {
		ct = pool.getConnection();
		String sql = "select * from essay";
		List list = new ArrayList();
		try {
			Statement st = ct.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new Article(rs.getInt(1),rs.getString(2)));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				ct.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return null;
	}
     
}
