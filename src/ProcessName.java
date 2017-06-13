

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CApp.CustomerApp;



/**
 * Servlet implementation class ProcessName
 */
@WebServlet("/CheckName")
public class ProcessName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	public ProcessName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerApp.getCustomer(request.getParameter("firstName"),request.getParameter("lastName"));
		//CustomerApp.getCustomer("Adele", "Dean");
		
	}

}
