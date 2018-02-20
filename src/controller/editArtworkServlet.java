package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Artwork;

/**
 * Servlet implementation class editArtwork
 */
@WebServlet("/editArtworkServlet")
public class editArtworkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editArtworkServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String act = request.getParameter("doThisToArtwork");
		ArtworkHelper dao = new ArtworkHelper(); 
		
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllArtworkServlet").forward(request, response);
		}else if (act.equals("Edit Selected Artwork")) {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Artwork artworkToEdit = dao.searchForItemById(tempId);
				request.setAttribute("artworkToEdit", artworkToEdit);
				getServletContext().getRequestDispatcher("/edit-artwork.jsp").forward(request,response);
		} else if (act.equals("Delete Selected Artwork")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Artwork itemToDelete = dao.searchForItemById(tempId);
			
			dao.deleteItem(itemToDelete);

			getServletContext().getRequestDispatcher("/viewAllArtworkServlet").forward(request, response);
			
		} else if (act.equals("Add New Artwork")) {
			getServletContext().getRequestDispatcher("/addArtwork.html").forward(request, response);
		}
	}

}
