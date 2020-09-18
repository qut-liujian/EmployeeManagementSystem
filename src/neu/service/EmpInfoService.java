package neu.service;

import neu.dao.EmpInfoDao;

import java.util.List;
import java.util.Map;

public class EmpInfoService {

	private EmpInfoDao empInfoDao;
	
	public EmpInfoService() {
		empInfoDao=new EmpInfoDao();
	}
	
	public Map<String, String> checkLogin(String no,String pwd){
		Map<String, String> emp=null;
		try {
			List<Map<String, String>> list=empInfoDao.checkLogin(no, pwd);
			if(list!=null && list.size()>0) {
				emp=list.get(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//???log4j??????
		}
		return emp;
	}
	public List<Map<String, String>> findAllLeader(){
		List<Map<String, String>> list=null;
		try {
			list=empInfoDao.findAllLeader();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean doSave(String name,String sex,String tel,String email,String leaderId) {
		boolean flag=false;
		try {
			int row=empInfoDao.save(name, sex, tel, email, leaderId);
			if(row>0) {
				flag=true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	public List<Map<String, String>> findAllEmps(){
		List<Map<String, String>> list=null;
		try {
			list=empInfoDao.findAllEmp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean doUpdate(String id,String name,String sex,String tel) {
		boolean flag=false;
		try {
			int row=empInfoDao.update(id, name, sex, tel);
			if(row>0) {
				flag=true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public boolean doDelete(String id) {
		boolean flag=false;
		try {
			int row=empInfoDao.delete(id);
			if(row>0) {
				flag=true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	public boolean checkEmail(String email) {
        boolean flag=false;
        List<Map<String, String>> list=empInfoDao.findByEmail(email);
        if(list!=null && list.size()>0) {
            if(list.get(0).get("email").equals("1")) {
                flag=true;
            }
        }
        return flag;
    }

    public boolean doUpdatePwd(String email,String pwd) {
        boolean flag=false;
        try {
            int row=empInfoDao.updatePwd(email, pwd);
            if(row>0) {
                flag=true;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }
}
