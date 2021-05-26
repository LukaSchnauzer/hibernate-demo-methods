package es.demo.connection.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteClientTest {

    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Client.class).buildSessionFactory();
        Session session = sf.openSession();

        try {
            //
            //Begin transaction
            session.beginTransaction();

            // More complex DELETE
            session.createQuery("DELETE Client WHERE name = 'Juan Carlos' AND lastName = 'Santiago' ").executeUpdate();

            //Commit transaction
            session.getTransaction().commit();
            System.out.println("Client Deleted");

            //End session
            session.close();
        }catch (Exception e){

        }finally {
            sf.close();
        }
    }
}
