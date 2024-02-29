package HibernateDemo.Demo;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import HibernateDemo.Demo.pojo.empDemo;

public class namedApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory.getFactory().openSession();
//		TypedQuery query=session.getNamedQuery("getbyDeptno");
//		query.setParameter("dno",10);
//		List<empDemo>list=  query.getResultList();
//		System.out.println(list.size());
		TypedQuery query=session.getNamedQuery("getbyDname");
		query.setParameter("dn", "SALES");
//		empDemo e=(empDemo)query.getSingleResult();
		List<empDemo> list=query.getResultList();
		System.out.println(list.size());
		session.close();
	}

}
