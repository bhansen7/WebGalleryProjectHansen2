package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Artwork;

/**
 * Servlet implementation class editArtworkItemServlet
 */
@WebServlet("/editArtworkItemServlet")
public class editArtworkItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editArtworkItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArtworkHelper dao = new ArtworkHelper();
		
		String artistName = request.getParameter("artistName");
		String title = request.getParameter("title");
		String media = request.getParameter("media");
		String year = request.getParameter("year");
		Double value = Double.parseDouble(request.getParameter("value"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Artwork itemToUpdate = dao.searchForItemById(tempId);
		itemToUpdate.setArtistName(artistName);
		itemToUpdate.setMedia(media);
		itemToUpdate.setTitle(title);
		itemToUpdate.setValue(value);
		itemToUpdate.setYear(year);
		
		dao.updateItem(itemToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllArtworkServlet").forward(request, response);
	}

}
