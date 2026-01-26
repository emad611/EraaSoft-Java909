package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.Item;
import service.ItemUtilService;

@WebServlet("/studentservlet")
public class studentservlet extends HttpServlet {

    @Resource(name = "jdbc/connection")
    private DataSource datasource;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
    	PrintWriter out = response.getWriter();
    
    	try {
    		ItemUtilService service= new ItemUtilService(datasource);
    		
    		List<Item>items=service.getItemsByIds();
    		
    		for(Item item : items) {
    			out.println("<h2>"+item.getId()+" - "
    					+item.getName()+" - "
    					+item.getPrice()+" - "
    					+"</h2>");
    		}
    	}catch(Exception e) {
    		out.println("ERROR :"+e.getMessage());
    	}
    
    }
    
};

