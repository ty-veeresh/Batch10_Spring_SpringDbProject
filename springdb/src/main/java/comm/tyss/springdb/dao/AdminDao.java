package comm.tyss.springdb.dao;

import java.util.List;

import comm.tyss.springdb.beans.AdminInfoBean;
import comm.tyss.springdb.beans.ItemBean;

public interface AdminDao {
	public AdminInfoBean authenticate(Integer id , String aname);

	public ItemBean getItemData(Integer iid);

	public boolean addItem(ItemBean infoBean);
	public List<ItemBean> getAllItemDetails();

	
	
	public boolean deleteItem(Integer iid);
}
