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
import java.util.List;

@WebServlet(name = "ListaCategorias", value = "/listaCategorias")
public class ListCategoryServlet extends HttpServlet {

    private CategoryDao categoryDao = new CategoryDao(JpaUtil.getEntityManager());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<CategoryDTO> categoryDTOList = CategoryDTO.fromDTO(categoryDao.listAll());

        request.setAttribute("categories", categoryDTOList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/categoryList.jsp");
        requestDispatcher.forward(request, response);
    }
}