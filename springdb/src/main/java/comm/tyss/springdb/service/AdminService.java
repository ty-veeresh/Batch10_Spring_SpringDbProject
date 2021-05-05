package comm.tyss.springdb.service;

import java.util.List;

import comm.tyss.springdb.beans.AdminInfoBean;
import comm.tyss.springdb.beans.ItemBean;

public interface AdminService {
	
	public AdminInfoBean authenticate(Integer aid, String aname);
	public boolean addItem(ItemBean infoBean);
	public ItemBean getItemData(Integer iid);

	public List<ItemBean> getAllItemDetails();
	

	public boolean deleteItem(Integer iid);
}
