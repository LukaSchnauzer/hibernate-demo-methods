package es.demo.connection.relations;

import es.demo.connection.client.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveClientAndDetails {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Client.class)
                .addAnnotatedClass(ClientDetails.class).buildSessionFactory();
        Session session = sf.openSession();

        try {
            Client client = new Client("Ximena","Santiago","Medellin de Bravo");
            ClientDetails clientDetails = new ClientDetails("www.nienio.com","+52 (55)25084488",":OOOasdas");
            client.setClientDetails(clientDetails);

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
            e.printStackTrace();
        }finally {
            sf.close();
        }
    }
}
