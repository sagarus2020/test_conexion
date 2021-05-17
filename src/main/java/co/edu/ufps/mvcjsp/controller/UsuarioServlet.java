package co.edu.ufps.mvcjsp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import co.edu.ufps.mvcjsp.dao.UsuarioDao;
import co.edu.ufps.mvcjsp.modelo.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDao usuarioDao;
	
    /**
     * Default constructor. 
     */
    public UsuarioServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	this.usuarioDao = new UsuarioDao();
	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action= request.getServletPath();
		try {
		switch(action) {
		case "/new":
			showNewForm(request,response);
		break;
		case "/insert":
			insertarUsuario(request,response);
		break;
		case"/delete":
			eliminarUsuario(request,response);
		break;
		case"/update":
			actualizarUsuario(request,response);
		break;
		case"/edit":
			showEditFrom(request,response);
		break;
		default:
			listUsuarios(request,response);
			break;
		}}catch(SQLException e) {
			
			throw new ServletException(e);
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		
	
	}

	private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre= request.getParameter("nombre");
		String email= request.getParameter("email");
		String pais= request.getParameter("pais");
	    Usuario usuario = new Usuario(id,nombre,email,pais);
		usuarioDao.update(usuario);
		response.sendRedirect("list");
	}
	
	private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		usuarioDao.delete(id);
		response.sendRedirect("list");
	}
	// TODO Auto-generated method stub
		
	private void listUsuarios(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,SQLException ,IOException{
		// TODO Auto-generated method stub
		List <Usuario> listUsuarios = usuarioDao.selectAll();
		request.setAttribute("listUsuarios", listUsuarios);
		RequestDispatcher dispatcher= request.getRequestDispatcher("usuariolist.jsp");
		dispatcher.forward(request,response);
		
	}

	private void showEditFrom(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Usuario usuarioActual = usuarioDao.select(id);
		request.setAttribute("usuario", usuarioActual);
		RequestDispatcher dispatcher= request.getRequestDispatcher("usuario.jsp");
		dispatcher.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void showNewForm(HttpServletRequest request , HttpServletResponse response)
	throws ServletException, IOException
	{
	RequestDispatcher dispatcher= request.getRequestDispatcher("usuario.jsp");
	dispatcher.forward(request,response);
	}

	private void insertarUsuario(HttpServletRequest request , HttpServletResponse response)
			throws SQLException, IOException
	{
		String nombre= request.getParameter("nombre");
		String email= request.getParameter("email");
		String pais= request.getParameter("pais");
	    Usuario usuario = new Usuario(nombre,email,pais);
		usuarioDao.insert(usuario);
		response.sendRedirect("list");
	    
	   
	}
	

}
