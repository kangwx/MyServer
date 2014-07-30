package cn.kang.service.impl;

import java.io.Serializable;

import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.kang.bean.User;
import cn.kang.service.UserService;
import cn.kang.service.base.DaoSupport;
import cn.kang.utils.MD5;

@Service @Transactional
public class UserServiceBean extends DaoSupport<User> implements UserService {
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	 public boolean exsit(String name){
		long count =(Long)em.createQuery("select count(o) from User o where o.username=?1")
			.setParameter(1, name).getSingleResult();
		return count>0; 
	 }

	 public void updatePassword(String username, String newpassword){
			em.createQuery("update User o set o.password=?1 where o.username=?2")
			.setParameter(1, MD5.MD5Encode(newpassword)).setParameter(2, username).executeUpdate();
		}
		@Override
		public void save(User entity) {
			entity.setPassword(MD5.MD5Encode(entity.getPassword()));
			super.save(entity);
		}

		 
		
		public boolean checkUser(String username, String password){
			long count = (Long)em.createQuery("select count(o) from User o where o.username=?1 and o.password=?2")
			.setParameter(1, username).setParameter(2, MD5.MD5Encode(password)).getSingleResult();
			return count>0;
		}
		
		@Override
		public void delete(Serializable ... entityIds){
			visible(false, entityIds);
		}

		@Override
		public long getCount() {
			return (Long)em.createQuery("select count(o) from User o where o.visible=?1")
			.setParameter(1, true).getSingleResult();
		}

		private void visible(boolean visible, Serializable ... usernames){
			if(usernames!=null && usernames.length>0){
				StringBuffer jpql = new StringBuffer();
				for(int i=0; i<usernames.length;i++){
					jpql.append('?').append(i+2).append(',');
				}
				jpql.deleteCharAt(jpql.length()-1);
				Query query = em.createQuery("update User b set b.visible=?1 where b.username in("+ jpql.toString() +")");
				query.setParameter(1, visible);
				for(int i=0; i<usernames.length;i++){
					query.setParameter(i+2, usernames[i]);
				}
				query.executeUpdate();
			}
		}
		
		public void enable(Serializable ... usernames) {
			visible(true, usernames);
		}
	 
	 
	  
}
