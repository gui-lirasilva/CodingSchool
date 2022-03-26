package br.com.coddingSchool.servlets;

import br.com.coddingSchool.dao.CategoryDao;
import br.com.coddingSchool.dto.CategoryFormDTO;
import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.util.JpaUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Criar categoria", value = "/insereCategoria")
public class CreateCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/insertCategory.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDao categoryDao = new CategoryDao(JpaUtil.getEntityManager());
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        int order = Integer.valueOf(request.getParameter("order"));
        String description = request.getParameter("description");
        boolean active = request.getParameter("active").equals("true");
        String iconPath = request.getParameter("iconPath");
        String colorCode = request.getParameter("colorCode");
        String studyGuide = request.getParameter("studyGuide");

        CategoryFormDTO categoryFormDTO = new CategoryFormDTO(name, code, order, description, active, iconPath,
                colorCode, studyGuide);

        Category category = categoryFormDTO.toEntity();
        categoryDao.insertNewCategory(category);

        response.sendRedirect("/listaCategorias");
    }
}
