package comm.tyss.springdb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import comm.tyss.springdb.beans.AdminInfoBean;
import comm.tyss.springdb.beans.ItemBean;



@Repository
public class AdminDaoImpl implements AdminDao {

	
	AdminInfoBean adminInfoBean=null;
	@Override
	public AdminInfoBean authenticate(Integer id, String aname) {
		try {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory.createEntityManager();

			String getData = "from AdminInfoBean where id=:id and aname=:aname";

			Query query = manager.createQuery(getData);
			query.setParameter("id", id);
			query.setParameter("aname", aname);

			adminInfoBean = (AdminInfoBean) query.getSingleResult();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return 	adminInfoBean;
	}
	@Override
	public boolean addItem(ItemBean infoBean) {
		try {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(infoBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
	}
	}
	@Override
	public ItemBean getItemData(Integer iid) {
		
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
		EntityManager manager = factory.createEntityManager();
		ItemBean bean = manager.find(ItemBean.class, iid);
		return bean;
	}
	@Override
	public List<ItemBean> getAllItemDetails() {
		List<ItemBean> InfoBeans = null;

		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory.createEntityManager();

			Query query = manager.createQuery("from ItemBean");

			InfoBeans = query.getResultList();
			
			
		} catch (Exception e) {
			InfoBeans = null;
			e.printStackTrace();
		}

		return InfoBeans;
	}
	
	@Override
	public boolean deleteItem(Integer iid) {
		try {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			ItemBean infoBean = manager.find(ItemBean.class, iid);
			manager.remove(infoBean);
			transaction.commit();
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false; 

			//throw new EmployeeException("The Data is not present");
		}
	}
}

	
	
	


