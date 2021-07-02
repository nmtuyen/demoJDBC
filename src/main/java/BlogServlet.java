import dao.BlogDAO;
import model.Blog;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BlogServlet", urlPatterns = "/BlogServlet")
public class BlogServlet extends HttpServlet {
    BlogDAO blogDAO = new BlogDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("blog/list.jsp");
        List<Blog> blogs = blogDAO.findAll();
        request.setAttribute("blogs", blogs);
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "insert":
                try {
                    insert(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

        }
    }

    public void insert(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        String content = request.getParameter("content");
        String name = request.getParameter("name");
        Blog blog = new Blog(id, content, name);
        blogDAO.insertBlog(blog);
    }
    public void listBlog(HttpServletRequest request, HttpServletResponse response){
        List<Blog> blogs = blogDAO.findAll();
//        request.setAttribute("");
    }
}
