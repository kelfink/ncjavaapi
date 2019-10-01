import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");


        Organization org = new Organization();
        org.setName("Kevin Test");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(org);

        //Set<Priority> prioritySet = new HashSet<Priority>();
        //org.setPriorities(prioritySet);
        Priority priority1 = new Priority();
        Priority priority2 = new Priority();

        priority1.setName("Dumping and litter");
        priority1.setOrganization(org);
        priority2.setName("Graffiti and vandalism");
        priority2.setOrganization(org);

        entityManager.persist(priority1);
        entityManager.persist(priority2);
        entityManager.getTransaction().commit();
        System.out.println("ORG ID: " + org.getId());
        System.out.println("priority id: " + priority1.getId());
        //System.out.printf("Get back the priority %d", getPriority(100, entityManager).getId());
        Organization orgReturned = getOrganization(org.getId(), entityManager);
        if (orgReturned == null) {
            System.err.println("no org returned");
        } else {
            System.out.printf("Get back organization %s\n", orgReturned.getName());
            if (orgReturned.getPriorities() == null) {
                System.out.println("No priorities\n");
            } else {
                System.out.printf("Get back org has priority count: %d\n", orgReturned.getPriorities().size());
            }
        }
        entityManager.close();
        entityManagerFactory.close();
    }

    public static Priority getPriority(Integer priority_id, EntityManager em) {
        return em.find(Priority.class, priority_id);
    }

    public static Organization getOrganization(int id, EntityManager em) {
        return em.find(Organization.class, id);
    }

    private Map getProperties() {
        HashMap result = new HashMap();

        // Read the properties from a file instead of hard-coding it here.
        // Or pass the password in from the command-line.
        result.put( "javax.persistence.jdbc.password", System.getenv("DBPASS") );
        result.put( "javax.persistence.jdbc.user", System.getenv("DBUSER") );
        result.put( "javax.persistence.jdbc.url", System.getenv("DBHOST") );

        return result;
    }
}
