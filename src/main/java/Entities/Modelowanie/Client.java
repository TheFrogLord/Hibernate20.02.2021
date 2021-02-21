package Entities.Modelowanie;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        Address address = new Address();

        UserDetails userDetails = new UserDetails();
        UserDetails userDetails1 = new UserDetails();
        UserDetails userDetails2= new UserDetails();
        UserDetails userDetails3 = new UserDetails();

        Vehicles vehicles1 = new Vehicles();
        Vehicles vehicles2 = new Vehicles();
        Vehicles vehicles3 = new Vehicles();
        Vehicles vehicles4 = new Vehicles();

        List<Phone> phoneList = new ArrayList<>();
        List<Vehicles> vehiclesList1 = new ArrayList<>();
        List<Vehicles> vehiclesList2 = new ArrayList<>();
        List<UserDetails> users1 = new ArrayList<>();
        List<UserDetails> users2 = new ArrayList<>();

        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        Phone phone3 = new Phone();

        phone1.setPhoneNumber(333333333);
        phone2.setPhoneNumber(444444444);
        phone3.setPhoneNumber(555555555);

        phoneList.add(phone1);
        phoneList.add(phone2);
        phoneList.add(phone3);

        address.setStreet("Lubartowska");
        address.setCity("Lublin");

        userDetails.setUsername("Zabson");
        userDetails.setAddress(address);
        userDetails.setPhoneList(phoneList);
        userDetails1.setUsername("lalala");
        userDetails2.setUsername("Ala");
        userDetails3.setUsername("Bronka");

        vehicles1.setName("Toyota");
        vehicles2.setName("Subaru");
        vehicles3.setName("Renault");
        vehicles4.setName("BMW");

        users1.add(userDetails1);
        users1.add(userDetails2);
        users2.add(userDetails3);
        users2.add(userDetails);

        vehiclesList1.add(vehicles1);
        vehiclesList1.add(vehicles2);
        vehiclesList2.add(vehicles3);
        vehiclesList2.add(vehicles4);

        phone1.setUserDetails(userDetails);
        phone2.setUserDetails(userDetails);
        phone3.setUserDetails(userDetails);

        userDetails.setVehicles(vehiclesList1);
        userDetails1.setVehicles(vehiclesList2);
        userDetails2.setVehicles(vehiclesList2);
        userDetails3.setVehicles(vehiclesList1);

        vehicles1.setUserDetailsList(users1);
        vehicles2.setUserDetailsList(users2);
        vehicles3.setUserDetailsList(users2);
        vehicles4.setUserDetailsList(users1);

        //address.setUserDetails(userDetails);

        final SessionFactory sessionFactory = HibernateUtilsNew.getSessionFactory();
        final Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.persist(address);
        session.persist(userDetails);
        session.persist(phone1);
        session.persist(phone2);
        session.persist(phone3);
        session.persist(userDetails1);
        session.persist(userDetails2);
        session.persist(userDetails3);
        session.persist(vehicles1);
        session.persist(vehicles2);
        session.persist(vehicles3);
        session.persist(vehicles4);

        Query from_userDetails = session.createQuery("from UserDetails");
        List<UserDetails> resultList = from_userDetails.getResultList();
        resultList.forEach(UserDetails -> System.out.println(userDetails.getUsername()));


        session.getTransaction().commit();

        session.refresh(address);
        session.close();
        HibernateUtilsNew.shutdownSessionFactory();
    }
}
