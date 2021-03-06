package com.urlshortener.dao;


import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.urlshortener.hibernate.HibernateUtil;
import com.urlshortener.model.URL;





@Repository
public class URLDAO {
	
	 public int registerURL(URL lURLVO)
	    {
	    	System.out.println("Inside registerURL method of URLVO");
	    	URL newURL = lURLVO;
	    	int id= 1;
	        Transaction transaction = null;
	        try {
	        	Session session = HibernateUtil.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            
	            if(!checkURLExists(lURLVO))
	            {
	            // save the user objects
	            lURLVO.setCounter(1);
	            session.save(newURL);
	            transaction.commit();
	            
	            return 0;
	            }
	            else
	            {
	            	newURL = getURLCounter(lURLVO);
	            	updateURLCounter(newURL);
	 	            transaction.commit();
	            	
	            }
	            
	            
	           	// commit transaction
	           
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	       
	    	return id;
	    }
	 
	 public boolean checkURLExists(URL lURLVO)
	    {
	    	 System.out.println("Inside checkURLExists method of URLDAO");
	    	 try{ 
					
					Session session = HibernateUtil.getSessionFactory().openSession() ;
					

		            // get an student object
		            String hql = " FROM URL l WHERE l.originalURL = :originalURL";
		            
		            Query query = session.createQuery(hql);
		            query.setParameter("originalURL", lURLVO.getOriginalURL());
		            List<URL> results = query.getResultList();

		            if (results != null && !results.isEmpty())
		            	
		            	{
		            		System.out.println("URL exists.!!");
		            		return true;
		            	}
		            // commit transaction
		          
		        } catch (Exception e) {
		        	 e.printStackTrace();
		            }
				return false;
	    	
	    }
	 
	 public int getURLId(URL lURLVO) {
			// TODO Auto-generated method stub
			 System.out.println("Inside getURLId method of URLDAO");
			 int id = 0;
	    	 try{ 
					
					Session session = HibernateUtil.getSessionFactory().openSession() ;
					

		            // get an student object
		            String hql = "select id FROM URL l WHERE l.originalURL = :originalURL";
		            
		            Query query = session.createQuery(hql);
		            query.setParameter("originalURL", lURLVO.getOriginalURL());
		            id =(int) query.getResultList().get(0);

		           
		            // commit transaction
		          
		        } catch (Exception e) {
		        	 e.printStackTrace();
		            }
				return id;
			
		}
	 
	 public URL getURLCounter(URL lURLVO) {
			// TODO Auto-generated method stub
			 System.out.println("Inside getURLCounter method of URLDAO");
			
			 URL objURL = null;
	    	 try{ 
					
					Session session = HibernateUtil.getSessionFactory().openSession() ;
					
					
		            // get an student object
		            String hql = " FROM URL l WHERE l.originalURL = :originalURL";
		            
		            Query query = session.createQuery(hql);
		           
		            query.setParameter("originalURL", lURLVO.getOriginalURL());
		            objURL = (URL) query.getResultList().get(0);
		            
		            

		           
		            // commit transaction
		          
		        } catch (Exception e) {
		        	 e.printStackTrace();
		            }
				return objURL;
			
		}
	 
	 public String getOriginalURL(URL lURLVO) {
			// TODO Auto-generated method stub
			 System.out.println("Inside getOriginalURL method of URLDAO");
			 String originalURL = "";
	    	 try{ 
					
					Session session = HibernateUtil.getSessionFactory().openSession() ;
					

		            // get an student object
		            String hql = "select originalURL FROM URL l WHERE l.id = :id";
		            
		            Query query = session.createQuery(hql);
		            query.setParameter("id", lURLVO.getId());
		            originalURL =(String) query.getResultList().get(0);

		           
		            // commit transaction
		          
		        } catch (Exception e) {
		        	 e.printStackTrace();
		            }
				return originalURL;
			
		}
	 
	 public long getCountOfURL() {
			// TODO Auto-generated method stub
			 System.out.println("Inside getCountOfURL method of URLDAO");
			 long  count = 0;
	    	 try{ 
					
					Session session = HibernateUtil.getSessionFactory().openSession() ;
					

		            // get an student object
		            String hql = "select count(*) FROM URL";
		            
		            Query query = session.createQuery(hql);
		            
		            count =(Long) query.uniqueResult();

		           
		            // commit transaction
		          
		        } catch (Exception e) {
		        	 e.printStackTrace();
		            }
				return count;
			
		}
	 
	 public int updateURLCounter(URL objURL) {
			// TODO Auto-generated method stub
			
			System.out.println("Inside updateURLCounter method of URLDAO");
			int result = 0;
			
			 Transaction transaction = null;
				try{ 
				int id= objURL.getId();
				int counter = objURL.getCounter()+1;
				Session session = HibernateUtil.getSessionFactory().openSession() ;
				 transaction = session.beginTransaction();
	            String query = "update URL u set u.counter=:counter where u.id=:id";
	            Query query1 = session.createQuery(query);
	            query1.setParameter("counter", counter);
	            query1.setParameter("id", id);
	            result = query1.executeUpdate();
	          
	            transaction.commit();
	           
	        } catch (Exception e) {
	        	 if (transaction != null) {
		                transaction.rollback();
		            }
		            e.printStackTrace();
		            return 1;
	            }
	           
			return 0;
		}
	 
	 
	 public List<URL> fetchTop5URL() {
			// TODO Auto-generated method stub
			 System.out.println("Inside fetchTop5URL method of URLDAO");
			 List<URL> urlList  = new ArrayList<URL>();
	    	 try{ 
					
					Session session = HibernateUtil.getSessionFactory().openSession() ;
					

		            // get an student object
		            String hql = " FROM URL order by counter desc";
		            
		            Query query = session.createQuery(hql);
		            
		            query.setMaxResults(5);
		            
		            urlList = query.getResultList();

		           
		            // commit transaction
		          
		        } catch (Exception e) {
		        	 e.printStackTrace();
		            }
				return urlList;
			
		}

}
