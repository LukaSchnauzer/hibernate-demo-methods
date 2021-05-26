package es.demo.connection.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveClientTest {

    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Client.class).buildSessionFactory();
        Session session = sf.openSession();

        try {
            Client client = new Client("Juan Carlos","Montero","Vicenta Maza de Marure #13");

            // CREATE
            //Begin transaction
            session.beginTransaction();
            //Save client
            session.save(client);
            //Commit transaction
            session.getTransaction().commit();
            System.out.println("Client Saved");

            // READ
            //Begin transaction
            session.beginTransaction();
            System.out.println("Reading register with ID: "+client.getId());
            //Reading client
            Client readClient = session.get(Client.class,client.getId());
            System.out.println(readClient.toString());
            //Commit transaction
            session.getTransaction().commit();
            System.out.println("Finish read");

            //End session
            session.close();
        }catch (Exception e){

        }finally {
            sf.close();
        }
    }
}
