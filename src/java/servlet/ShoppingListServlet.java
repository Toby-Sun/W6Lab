package servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        session.setAttribute("username", username);
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String action = request.getParameter("action");

        session.setAttribute("username", username);
        getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);

        if (session.getAttribute("items") == null) {
            ArrayList<String> items = new ArrayList<>();
            session.setAttribute("items", items);
        } else if (action.equals("add")) {
            ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
            String item = request.getParameter("item");
            items.add(item);
            request.setAttribute("items", items);
            session.setAttribute("items", item);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
        } else if (action.equals("delete")) {
            ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
            String item = request.getParameter("item");
            items.remove(item);
            request.setAttribute("items", items);
            session.setAttribute("items", items);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
    }
}
