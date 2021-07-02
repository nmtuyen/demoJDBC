package dao;

import model.Blog;

import java.sql.SQLException;
import java.util.List;

public interface IblogDAO {
    public List<Blog> findAll();
    public Blog select(int id);
    public void insertBlog(Blog blog) throws SQLException, ClassNotFoundException;
    public boolean editBlog(int id);
    public boolean deleteBlog(Blog blog);
}
