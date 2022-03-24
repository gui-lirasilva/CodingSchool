package br.com.coddingSchool.servlets;

import br.com.coddingSchool.dao.CategoryDao;
import br.com.coddingSchool.helpers.HelperCsv;
import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.util.JpaUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ListaCategorias" , value = "/listaCategorias")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDao categoryDao = new CategoryDao(JpaUtil.getEntityManager());
        List<Category> categoryList = categoryDao.listAll();
        PrintWriter print = response.getWriter();
        print.println("<html>");
        print.println("<head>");
        print.println("<meta charset=\"UTF-8\">");
        print.println("</head>");
        print.println("<body>");
        for (Category c : categoryList) {
            print.printf("""
                            <ul>
                                <li>Category id = %d</li>
                                <br>
                                <li>Category name = %s</li>
                                <br>
                                <li>Category code = %s</li>
                                <br>
                                <li>Order = %d</li>
                                <br>
                                <li>Description = %s</li>
                                <br>
                                <li>Active = %s</li>
                                <br>
                                <li>Icon path = %s</li>
                                <br>
                                <li>Hexadecimal color code = %s</li>
                                <br>
                                <li>Study guide = %s</li>
                            </ul>
                            <p>------------------------------------------------------------------------------------------------------------------</p>
                            <br>
                            <br>
                            <br>
                            %n""",
                    c.getId(), c.getName(), c.getCode(), c.getOrder(), c.getDescription(),
                    HelperCsv.isActive(c.getActive()), c.getIconPath(), c.getColorCode(), c.getStudyGuide());
        }
        print.println("</body>");
        print.println("</html>");
    }

}
