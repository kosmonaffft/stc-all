package university.innopolis.stc.javaee;

import lombok.Cleanup;
import lombok.val;
import university.innopolis.stc.javaee.entity.User;
import university.innopolis.stc.javaee.entity.User_;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainCriteria {

    public static void main(String[] args) {
        val entityManagerFactory = Persistence.createEntityManagerFactory("PU");
        @Cleanup val entityManager = entityManagerFactory.createEntityManager();

        val criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<User> selectAllQuery = criteriaBuilder.createQuery(User.class);
        Root<User> selectAllUserRoot = selectAllQuery.from(User.class);
        selectAllQuery.select(selectAllUserRoot);
        selectAllQuery.orderBy(criteriaBuilder.asc(selectAllUserRoot.get("id")));
        TypedQuery<User> selectAllUsers = entityManager.createQuery(selectAllQuery);
        List<User> allUsers = selectAllUsers.getResultList();
        System.out.printf("All users: %s%n", allUsers);


        String login = null; //"login2";
        LocalDate registeredAfter = LocalDate.of(2021, 1, 1);

        CriteriaQuery<User> filterQuery = criteriaBuilder.createQuery(User.class);
        Root<User> filterUserRoot = filterQuery.from(User.class);
        filterQuery.select(filterUserRoot);

        List<Predicate> predicates = new ArrayList<>();

        if (login != null) {
            predicates.add(criteriaBuilder.equal(filterUserRoot.get(User_.login), login));
        }

        if (registeredAfter != null) {
            predicates.add(criteriaBuilder.greaterThan(filterUserRoot.get(User_.date), registeredAfter));
        }

        filterQuery.where(predicates.toArray(new Predicate[0]));

        List<User> singleResult = entityManager.createQuery(filterQuery).getResultList();

        System.out.printf("By login user: %s%n", singleResult);
    }
}
