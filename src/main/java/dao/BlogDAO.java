package dao;

import model.Blog;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogDAO implements IblogDAO{

    private String jdbcURL = "jdbc:mysql://localhost:3306/demojdbc1?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String SELECT_ALL_BLOG = "select * from blogs";
    private static final String INSERT_BLOGS = "insert into blogs values(?,?,?)";


    protected Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        return connection;
    }




    @Override
    public List<Blog> findAll() {
        List<Blog> blogs = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BLOG);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String content = resultSet.getString("content");
                String name = resultSet.getString("name");
                blogs.add(new Blog(id, content, name));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return blogs;
    }

    @Override
    public Blog select(int id) {
        return null;
    }

    @Override
    public void insertBlog(Blog blog) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BLOGS);
        preparedStatement.setInt(1,blog.getId());
        preparedStatement.setString(2,blog.getContent());
        preparedStatement.setString(3,blog.getName());
        preparedStatement.executeUpdate();
    }

    @Override
    public boolean editBlog(int id) {
        return false;
    }

    @Override
    public boolean deleteBlog(Blog blog) {
        return false;
    }
}
