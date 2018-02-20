package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Artwork;

/**
 * Servlet implementation class addArtworkServlet
 */
@WebServlet("/addArtworkServlet")
public class addArtworkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addArtworkServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// protected void doGet(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException, IOException {
	// // TODO Auto-generated method stub
	// response.getWriter().append("Served at: ").append(request.getContextPath());
	// }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String artistName = request.getParameter("artist name");
		String media = request.getParameter("media");
		String year = request.getParameter("year");
		String stringValue = request.getParameter("value");
		double value = Double.valueOf(stringValue);

		Artwork li = new Artwork(title, artistName, media, year, value);
		ArtworkHelper dao = new ArtworkHelper();
		dao.insertItem(li);

		getServletContext().getRequestDispatcher("/addArtwork.html").forward(request, response);

	}

}
