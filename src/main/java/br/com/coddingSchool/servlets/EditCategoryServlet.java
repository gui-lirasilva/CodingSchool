package br.com.coddingSchool.servlets;

import br.com.coddingSchool.dao.CategoryDao;
import br.com.coddingSchool.dto.CategoryDTO;
import br.com.coddingSchool.util.JpaUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Editar Categoria", value = "/editarCategoria")
public class EditCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        CategoryDao categoryDao = new CategoryDao(JpaUtil.getEntityManager());
        CategoryDTO categoryDTO = new CategoryDTO(categoryDao.findById(id));
        request.setAttribute("category", categoryDTO);
        RequestDispatcher rd = request.getRequestDispatcher("/editCategoryForm.jsp");
        rd.forward(request, response);
    }
}
