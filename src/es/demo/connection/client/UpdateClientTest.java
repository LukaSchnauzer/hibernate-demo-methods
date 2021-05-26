package es.demo.connection.client;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateClientTest {

    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Client.class).buildSessionFactory();
        Session session = sf.openSession();

        try {
            //
            //Begin transaction
            session.beginTransaction();

            // UPDATE
            // get Client to update
            /*int clientId = 1;
            Client client = session.get(Client.class, clientId);
            // update last name
            client.setLastName("Montero Santiago");*/

            // More complex UPDATE
            session.createQuery("UPDATE Client SET address = 'Col. Las Ninfas' WHERE last_name LIKE 'S%' ").executeUpdate();

            //Commit transaction
            session.getTransaction().commit();
            System.out.println("Client Updated");

            //End session
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sf.close();
        }
    }
}
