package regression.test;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.Assert;
import org.junit.Test;
import regression.domain.Foo;

public class QueryTest extends Assert {
    @Test
    public void query() {
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("domain");
        final EntityManager em = entityManagerFactory.createEntityManager();
        final EntityTransaction tx = em.getTransaction();

        tx.begin();
        final Foo foo = new Foo();
        foo.setCategory(1);
        foo.setCategoryName("One");
        foo.setValue1(BigDecimal.ONE);
        foo.setValue2(2);
        em.persist(foo);
        em.flush();

        List<Object[]> data = em.createQuery("select f.category, f.categoryName, sum(f.value1) as sum1, sum(f.value2) from Foo f group by f.category, f.categoryName order by sum1 desc").getResultList();
        assertEquals(1, data.size());
        assertEquals(4, data.get(0).length);
        tx.commit();
    }
}
