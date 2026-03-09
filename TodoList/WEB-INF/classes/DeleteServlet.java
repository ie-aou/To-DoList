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

@WebServlet("/deleteServlet")

public class DeleteServlet extends HttpServlet{
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
        String[] delete = req.getParameterValues("delete");

        ServletContext sc = this.getServletContext();
        List<Task> list = (List<Task>)sc.getAttribute("list");
        
        if(delete != null){
            if(delete[0].equals("all")){
                list.clear();
            }else{       
                for(int i = delete.length - 1; i >= 0; i--){
                    list.remove(Integer.parseInt(delete[i]));
                }
            }    
        }
        sc.setAttribute("list", list);

        RequestDispatcher d = req.getRequestDispatcher("/view.jsp");
        d.forward(req, res);
    }
}