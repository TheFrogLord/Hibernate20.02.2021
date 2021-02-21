import Entities.Dane;
import Entities.Pracownik;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;

public class MainPracownik {

    public static void main(String[] args) {

        Pracownik pracownik = new Pracownik();
        Pracownik pracownik2 = new Pracownik();
        Dane dane = new Dane();

        pracownik.setFirstName("Grzegorz");
        pracownik.setLastName("Harnol");
        dane.setExperience(12);
        dane.setSalary(BigDecimal.valueOf(12000.2454567));
        pracownik.setDane(dane);

        final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        final Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(pracownik);

        Pracownik worker = session.find(Pracownik.class, 1L);
        worker.getDane().setSalary(BigDecimal.valueOf(14200.2454567)); //pierwsze rozwiazanie

        session.getTransaction().commit();
        session.close();
        HibernateUtils.shutdownSessionFactory();
    }
}
