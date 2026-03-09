import jakarta.servlet.ServletContext;
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import model.Task;
import java.util.List;
import java.util.ArrayList;

@WebServlet("/createServlet")
public class CreateServlet extends HttpServlet{
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
        String title = req.getParameter("title");
        String priority = req.getParameter("priority");
        String detail = req.getParameter("detail");

        ServletContext sc = this.getServletContext();

        Task task = new Task(title, priority, detail);
        
        List<Task> list = (List<Task>)sc.getAttribute("list");
        
        if(list == null){
            list = new ArrayList<Task>();
        }
        list.add(task);
        
        sc.setAttribute("list", list);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/view.jsp");
        dispatcher.forward(req, res);
    } 

    public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
        ServletContext sc = this.getServletContext();
        List<Task> list = (List<Task>)sc.getAttribute("list");
        
        if(list == null){
            list = new ArrayList<Task>();
        }

        sc.setAttribute("list", list);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/view.jsp");
        dispatcher.forward(req, res);

    }
}
        

