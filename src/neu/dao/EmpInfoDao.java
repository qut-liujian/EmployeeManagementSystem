package neu.dao;

import java.util.List;
import java.util.Map;

public class EmpInfoDao extends BaseDao {

	
	public List<Map<String, String>> checkLogin(String no,String pwd){
		List<Map<String, String>> list=null;
		String sql="select * from emp_info" + 
				" where (emp_name=? or emp_tel=? or emp_email=?) " + 
				"	and emp_pwd=?";
		list=super.exeucteQuery(sql, no,no,no,pwd);
		return list;
	}
	
	public List<Map<String, String>> findAllLeader(){
		List<Map<String, String>> list=null;
		//���мӿո�
		String sql="SELECT " + 
				"	DISTINCT a.id,a.emp_name" + 
				" from emp_info a " + 
				" INNER JOIN emp_info b on a.id=b.leader_id";
		list=super.exeucteQuery(sql);
		return list;
	}
	public int save(String name,String sex,String tel,String email,String leaderid) {
		int row=0;
		String sql="insert into emp_info(emp_name,emp_sex,emp_tel,emp_email,emp_pwd,leader_id)"
				+ " values(?,?,?,?,'123456',?)";
		row=super.executeUpdate(sql, name,sex,tel,email,leaderid);
		return row;
	}
	public List<Map<String, String>> findAllEmp(){
		List<Map<String, String>> emps=null;
		String sql="select " +
				"	a.id,a.emp_name,a.emp_sex,a.emp_tel,a.emp_email,b.emp_name leader_name" +
				"	from emp_info a" +
				"	INNER JOIN emp_info b on a.leader_id=b.id"
				+ " where a.emp_status=1";
		emps=super.exeucteQuery(sql);
		return emps;
	}
	public int update(String id,String name,String sex,String tel) {

		int row=0;
		String sql="update emp_info set emp_name=?,emp_sex=?,emp_tel=? where id=?";
		row=super.executeUpdate(sql, name,sex,tel,id);
		return row;
	}
	/**
	 * 实际开始删除是使用update 修改用户的状态完成删除操作
	 * @param id
	 * @return
	 */
	public int delete(String id) {
		int row=0;
		String sql="update emp_info set emp_status=0 "
				+ "	where id=?";
		row=super.executeUpdate(sql, id);
		return row;
	}
	public List<Map<String, String>> findByEmail(String email){
		List<Map<String, String>> list=null;
		String sql="select 1 email from emp_info where emp_email=?";
		list=super.exeucteQuery(sql, email);
		return list;
	}

	public int updatePwd(String email,String pwd) {
		int row=0;
		String sql="update emp_info set emp_pwd=? where emp_email=?";
		row=super.executeUpdate(sql, pwd,email);
		return row;
	}

}
