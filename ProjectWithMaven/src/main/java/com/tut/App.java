package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    @SuppressWarnings("resource")
	public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Student st = new Student(101, "John", "Delhi");
        System.out.println(st);
        
        Address ad = new Address();
        ad.setStreet("street1 ");
        ad.setCity("DELHI");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(123.45);
        
        //Reading image
        FileInputStream fis = new FileInputStream("src/main/java/computer.png");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
        
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        session.save(st);
        session.save(ad);
        tx.commit();
        
        session.close();
        
        System.out.println("Done...");
        
    }
}
