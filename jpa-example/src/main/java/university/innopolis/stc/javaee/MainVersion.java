package university.innopolis.stc.javaee;

import lombok.Cleanup;
import lombok.val;
import university.innopolis.stc.javaee.entity.Section;

import javax.persistence.LockModeType;
import javax.persistence.Persistence;

public class MainVersion {

    public static void main(String[] args) {
        val entityManagerFactory = Persistence.createEntityManagerFactory("PU");
        @Cleanup val entityManager = entityManagerFactory.createEntityManager();

        val section = entityManager.find(Section.class, 1L);
        System.out.printf("Section with id=1: %s%n", section);

        entityManager.getTransaction().begin();

        entityManager.lock(section, LockModeType.PESSIMISTIC_WRITE);
        section.setName(section.getName() + "1");

        entityManager.getTransaction().commit();
    }
}
