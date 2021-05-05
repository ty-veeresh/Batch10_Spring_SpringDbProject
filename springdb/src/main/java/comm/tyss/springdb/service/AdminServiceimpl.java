package comm.tyss.springdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comm.tyss.springdb.beans.AdminInfoBean;
import comm.tyss.springdb.beans.ItemBean;
import comm.tyss.springdb.dao.AdminDao;

@Service
public class AdminServiceimpl implements AdminService {

	@Autowired
	private AdminDao dao;
	@Override
	public AdminInfoBean authenticate(Integer aid, String aname) {
		
		return dao.authenticate(aid, aname);
	}
	@Override
	public boolean addItem(ItemBean infoBean) {
		// TODO Auto-generated method stub
		return dao.addItem(infoBean);
	}
	@Override
	public ItemBean getItemData(Integer iid) {
		return dao.getItemData(iid);
	}


	@Override
	public List<ItemBean> getAllItemDetails() {
		// TODO Auto-generated method stub
		return dao.getAllItemDetails();
		}
	
	@Override
	public boolean deleteItem(Integer iid) {
		// TODO Auto-generated method stub
		return dao.deleteItem(iid);
	}
	
	}

