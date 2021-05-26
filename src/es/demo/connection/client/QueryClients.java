package es.demo.connection.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class QueryClients {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Client.class).buildSessionFactory();
        Session session = sf.openSession();

        try{
            //Begin transaction
            session.beginTransaction();
            //Query Client
            Query query = session.createQuery("FROM Client");
            List<Client> clients = query.getResultList();
            //Printing clients
            printClients(clients);

            //Query 'Montero' Last name
            // In HQL we write the the names of the tables and columns as they are in their Java Classes, not like they are in DB
            clients = session.createQuery("FROM Client cl WHERE cl.lastName = 'Montero'").getResultList();
            //Printing clients
            printClients(clients);

            //Commit transaction
            session.getTransaction().commit();
            //End session
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sf.close();
        }
    }

    private static void printClients(List<Client> clients) {
        for (Client client : clients) {
            System.out.println(client);
        }
    }
}
