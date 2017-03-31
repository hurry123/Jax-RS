package org.javabrains.hari.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.javabrains.hari.dto.Address;
import org.javabrains.hari.dto.FourWheeler;
import org.javabrains.hari.dto.TwoWheeler;
import org.javabrains.hari.dto.UserDetails;
import org.javabrains.hari.dto.Vehicle;
import org.hibernate.cache.*;



public class HibernateTest {

	public static void main(String[] args) {

		/*UserDetails user = new UserDetails();
		user.setUserId(67);
		user.setUserName("Second User");*/
		
		
		
		
		/*Vehicle veh = new Vehicle();
		//veh.setVehicleId(91);
		veh.setVehicleName("Car2");
		
		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Saffire");
		bike.setSteeringHandle("Bike Steering Handle");
		
		FourWheeler cars = new FourWheeler();
		cars.setVehicleName("Porshe");
		cars.setSteeringWheel("Car Steering");*/
		
		
		 
		/*Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleId(72);
		vehicle2.setVehicleName("Jeep");
		*/
		
		
	//	user.getVehicle().add(vehicle1);
	//	user.getVehicle().add(vehicle2);  //this is how you add into set. unlike setters
	//	//user.setVehicle(vehicle); //need to set this, after @OnetoOne
		
		//vehicle1.setUser(user);
		//vehicle2.setUser(user);
		
		//vehicle1.getUserList().add(user);
		//vehicle2.getUserList().add(user);
		
				
		/*Address addr1 = new Address();
		addr1.setStreet("10th");
		addr1.setCity("Long beach");
		addr1.setPincode("90804");
		addr1.setState("CA");
		
		Address addr2 = new Address();
		addr2.setStreet("Woodcreek Oaks");
		addr2.setCity("Roseville");
		addr2.setPincode("95747");
		addr2.setState("CA");
		
		user.getListOfAddresses().add(addr1);
		user.getListOfAddresses().add(addr2);*/
		
		//user.setAddress(addr1);
		//user.setAddress(addr2);

		
        //Hibernate API to save this objects to DB
		//Session factory is created only ONCE
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	    Session session = sessionFactory.openSession();
	    
	    //create transaction
	    session.beginTransaction();
	    
	    Query query = session.createQuery("from UserDetails user where user.userId=5");
	    query.setCacheable(true);
	    List users = query.list();
	    
	   //UserDetails user = (UserDetails) session.get(UserDetails.class, 5); //Select happens
	   // user.setUserName("Teja");   // update happends & the value for table is cached here. 
	   

	    
	    /*int minUserId = 9;
	    String someName = "User 5";
	   */
	   
	   /* UserDetails exampleUser = new UserDetails();
	    exampleUser.setUserId(5);
	    exampleUser.setUserName("Hari%");
	    
	    Example example = Example.create(exampleUser).enableLike().excludeProperty("userId");
	    
	    Criteria criteria = session.createCriteria(UserDetails.class)
	    						.add(example);*/
	    						//.setProjection(Projections.property("userId"));
	    						//.addOrder(Order.desc("userId"));
	   
	    
	    // criteria.add(Restrictions.eq("userName", "Hari"))
	    //	 		.add(Restrictions.between("userId", 3, 12));

	   // criteria.add(Restrictions.or(Restrictions.between("userId", 0, 3), Restrictions.between("userId", 3, 9)));
	   // Query query = session.getNamedQuery("UserDetails.byId");
	    //query.setInteger(0, minUserId);

	   /* Query query = session.getNamedNativeQuery("UserDetails.byName");
	    query.setString(0, "Hari");*/
	    //Query query = session.createQuery("from UserDetails where userId = :userId and userName = :userName" );
	   
	    //query.setInteger("userId", minUserId);
	    //query.setString("userName", "someName");
	    		
	    
	    /* for Pagination, Hibernate automatically adds offset params in query
	    * query.setFirstResult(5);
	    query.setMaxResults(4);
	    */
	    //List<UserDetails> users = (List<UserDetails>) query.list();
	    //List<UserDetails> users = (List<UserDetails>) criteria.list();
	    
	    
	    
	    //UserDetails user = (UserDetails) session.get(UserDetails.class, 7);
	    
	    //session.save(user);
	   // session.delete(user); //deletes that record
	   // session.persist(user);
	   /* session.save(veh);
	    session.save(cars);
	    session.save(bike);*/

	    //session.save(user2);
	    
	    //end transaction
	    session.getTransaction().commit();
	    
	    //to close
	    session.close();
	    
	    System.out.println("User Size: "+ users.size());
	    
	    Session session2 = sessionFactory.openSession();
	    session2.beginTransaction();
	    
	    //UserDetails user1 = (UserDetails) session2.get(UserDetails.class, 5); // select doesn't happen as it detects from cache there is no change after update is done
	    Query query2 = session2.createQuery("from UserDetails user where user.userId=5");
	    query2.setCacheable(true);
	    List users2 = query2.list();
	    
	    session2.getTransaction().commit();
	    session2.close();
	    
	    
	    /*for(UserDetails user : users) {
	    	System.out.println(user.getUserName());
	   }*/
	    
	    //System.out.println("Users List Size is: "+ list.size());
	   // System.out.println("User name pulled up is " + user.getUserName());
	    
	   /* user.setUserName("Hari");
	    
	    session = sessionFactory.openSession();
	    session.beginTransaction();
	    
	    session.update(user);
	    
	    session.getTransaction().commit();
	    
	    session.close();
	    */
	  /*  user = null;
	    session = sessionFactory.openSession();
	    session.beginTransaction();
	    user = (UserDetails) session.get(UserDetails.class, 1);
	    session.close(); */
	   // System.out.println("Size of Address is "+ user.getListOfAddresses().size());
 
	    /* to retrieve value fro table into the object 
	    user = null;
	    session = sessionFactory.openSession();
	    session.beginTransaction();
	    user = (UserDetails) session.get(UserDetails.class, 1);
	    System.out.println("User Name retrieved is "+ user.getUserName());
	  	*/
	    
	}
}
