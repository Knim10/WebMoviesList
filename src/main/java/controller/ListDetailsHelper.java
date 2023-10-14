package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListDetails;

/**
 * @author Kenneth Nimmo - Knimmo CIS175 - Fall 2021 Oct 14, 2023
 */
public class ListDetailsHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebMoviesList");

	public void insertNewListDetails(ListDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}

	public List<ListDetails> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<ListDetails> allDetails = em.createQuery("SELECT d From ListDetails d").getResultList();
		return allDetails;
	}

	public void deleteList(ListDetails toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListDetails> typedQuery = em
				.createQuery("select detail from ListDetails detail where detail.id = :selectedId", ListDetails.class);

		// substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", toDelete.getId());

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		ListDetails result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public ListDetails searchForListDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListDetails found = em.find(ListDetails.class, tempId);
		em.close();
		return found;
	}

	public void updateList(ListDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
