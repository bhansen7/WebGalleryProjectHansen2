package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Artwork;

public class ArtworkHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GalleryProjectHansen");
	
	public void insertItem(Artwork toAdd) {
		// TODO Auto-generated method stub

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}

	public List<Artwork> showAllItems() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Artwork> allResults = em.createQuery("select li from Artwork li", Artwork.class);
		List<Artwork> allItems = allResults.getResultList();
		em.close();
		return allItems;
	}

	public void deleteItem(Artwork toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Artwork> typedQuery = em.createQuery(
				"select li from Artwork li where li.id = :selectedId",
				Artwork.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		Artwork result = typedQuery.getSingleResult(); 
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	//used before adding web
	//public void deleteItem(Artwork toDelete) {
	//	// TODO Auto-generated method stub
	//	EntityManager em = emfactory.createEntityManager();
	//	em.getTransaction().begin();
	//	TypedQuery<Artwork> typedQuery = em.createQuery(
	//			"select li from Artwork li where li.artistName = :selectedArtist and li.title = :selectedTitle",
	//			Artwork.class);
	//	typedQuery.setParameter("selectedArtist", toDelete.getArtistName());
	//	typedQuery.setParameter("selectedTitle", toDelete.getTitle());
	//	typedQuery.setMaxResults(1);
	//	Artwork result = typedQuery.getSingleResult(); 
	//	em.remove(result);
	//	em.getTransaction().commit();
	//	em.close();
	//}

	public Artwork searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Artwork foundItem =  em.find(Artwork.class, idToEdit);
		em.close();
		return foundItem; 
	}

	public void updateItem(Artwork toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin(); 
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	 
	}

	
	
}
