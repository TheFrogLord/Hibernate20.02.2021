
import Entities.Address;
import Entities.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {

    public static void main(String[] args) {
        //Session Factory za pomocą klasy HibernateUtils

        Person person = new Person();
        Address address = new Address();

        person.setFirstName("Łukasz");
        person.setLastName("Bułka");
        person.setAge(28);
        person.setPesel(942133654224L);
        address.setStreet("Lubartowska");
        address.setHouseNumber(48);
        address.setApartmentNumber(4);
        address.setFloorNumber(9);
        person.setAddress(address);

        final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        final Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(person);

        //dla wyciagniecia z tabeli dane osoby
        Person myPerson = session.get(Person.class, 1L);
        myPerson.setFirstName("Wiesiek");
        myPerson.setLastName("Wiśnia");


        session.getTransaction().commit();

        session.close();
        HibernateUtils.shutdownSessionFactory();
    }
}
