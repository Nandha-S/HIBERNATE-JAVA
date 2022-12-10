package com.java.DemoHiber;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
public class App 
{
    public static void main( String[] args )
    {
       Demo demo=new Demo();
       demo.setId(103);
       demo.setName("sathish");
       demo.setDept("cse");
       
       Configuration con = new Configuration().configure().addAnnotatedClass(Demo.class); 
       
       ServiceRegistry reg =new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
       
       SessionFactory sf=con.buildSessionFactory(reg);
       
       Session session =sf.openSession();
       
       Transaction tx =session.beginTransaction();
       
       session.save(demo);
       
       tx.commit();
       
    }
}
