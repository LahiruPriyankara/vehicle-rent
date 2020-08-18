package com.lhu.vehicle_rent_backend.config;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class DbConfig {
    public static Session sessionBulder(){
        //Configuration con = new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(Vehicle.class).addAnnotatedClass(Book.class);
        Configuration con = DbConnection.getInstance().getConnection();
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		return session;
    }

}
