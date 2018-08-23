package domain;

import bl.HibernateUtil;
import entity.Address;
import entity.Employee;
import entity.Project;
import org.hibernate.Session;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class TestHibernate {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Address address = new Address();
        address.setCountry("Usa");
        address.setCity("New-York");
        address.setStreet("Washington 1");
        address.setPostcode("00998");

        Employee employee = new Employee();
        employee.setName("Garry");
        employee.setLastName("Riddik");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1968, Calendar.APRIL, 2);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);

        Project project = new Project();
        project.setTitle("11237");

        Set<Project> projectSet = new HashSet<Project>();
        projectSet.add(project);
        employee.setProjects(projectSet);

        session.save(address);
        session.save(employee);
        session.save(project);
        session.beginTransaction().commit();
        HibernateUtil.showdown();

    }
}
