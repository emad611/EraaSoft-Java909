package item.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;

import item.model.Item;
import item.service.itemserv;
import item.service.impl.ItemServiceImpl;

@WebServlet("/itemcontroller")
public class ItemController extends HttpServlet {

    private itemserv itemService;

    @Resource(name = "jdbc/connection")
    private DataSource dataSource;

    // يشتغل أول ما السيرفلت يبدأ
    @Override
    public void init() {
        itemService = new ItemServiceImpl(dataSource);
    }

    // -------------------- GET Request --------------------
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            action = "show_items";
        }

        switch (action) {
            case "show_items":
                showItems(request, response);
                break;

            case "show_item":
                showItem(request, response);
                break;

            case "add_form":
                showAddForm(request, response);
                break;

            default:
                showItems(request, response);
        }
    }
   
    // -------------------- POST Request --------------------
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("add_item".equals(action)) {
            addItem(request, response);

        } else if ("delete".equals(action)) {
            deleteItem(request, response);

        } else if ("update".equals(action)) {
            updateItem(request, response);

        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    // -------------------- عرض كل الأصناف --------------------
    private void showItems(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            List<Item> items = itemService.getItems();
            request.setAttribute("allitems", items);
            request.getRequestDispatcher("/item/show_items.jsp").forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    // -------------------- عرض صنف واحد --------------------
    private void showItem(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        Item item = itemService.getItem(id);

        response.getWriter().append("<h1>Show Item</h1>");

        if (item != null) {
            response.getWriter().append("<p>" + item.getName() + " - " + item.getPrice() + "</p>");
        } else {
            response.getWriter().append("<p>Item not found</p>");
        }
    }

    // -------------------- عرض فورم الإضافة --------------------
    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/add_item.jsp").forward(request, response);
    }

    // -------------------- إضافة صنف --------------------
    private void addItem(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));

        Item item = new Item();
        item.setName(name);
        item.setPrice(price);

        itemService.createItem(item);

        response.sendRedirect("itemcontroller?action=show_items");
    }

    // -------------------- تعديل صنف --------------------
    private void updateItem(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));

        Item item = new Item();
        item.setId(id);
        item.setName(name);
        item.setPrice(price);

        itemService.updateItem(item); 

        response.sendRedirect("itemcontroller?action=show_items");
    }

    // -------------------- حذف صنف --------------------
    private void deleteItem(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        String role = (String) session.getAttribute("role");

        if (!"ADMIN".equals(role)) {
            response.getWriter().write("ممنوع الحذف");
            return;
        }

        Long id = Long.parseLong(request.getParameter("id"));
        itemService.removeItem(id);

        response.sendRedirect("itemcontroller?action=show_items");
    }
}