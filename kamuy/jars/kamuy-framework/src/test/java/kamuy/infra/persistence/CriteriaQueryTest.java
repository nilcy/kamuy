// ========================================================================
// Copyright (C) Kamuy Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package kamuy.infra.persistence;
import static kamuy.domain.actor.Member_.*;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.googlecode.jeeunit.JeeunitRunner;
import com.googlecode.jeeunit.Transactional;
import kamuy.domain.actor.Member;
/**
 * Test for {@link TypedEntityController}.
 * @author nilcy
 */
@RunWith(JeeunitRunner.class)
@Transactional
@SuppressWarnings("all")
public class CriteriaQueryTest {
    @Inject
    @PrimaryEntityManager
    private EntityManager entityManager;
    @Inject
    private Logger log;
    @Before
    public void before() {
        this.entityManager.persist(createMember("foo", "fooz"));
        this.entityManager.persist(createMember("bar", "barz"));
    }
    @Test
    public void test() {
        final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<Member> query = builder.createQuery(Member.class);
        final Root<Member> root = query.from(Member.class);
        final TypedQuery<Member> typedQuery = this.entityManager.createQuery(query.select(root)
            .orderBy(builder.asc(root.get(account))).groupBy(root.get(account)));
        for (final Member member : typedQuery.getResultList()) {
            this.log.info(member.toString());
        }
    }
    @Test
    public void testWhere() {
        final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<Member> query = builder.createQuery(Member.class);
        final Root<Member> root = query.from(Member.class);
        final TypedQuery<Member> typedQuery = this.entityManager.createQuery(query
            .select(root)
            .where(
                builder.and(builder.equal(root.get(account), "foo"),
                    builder.equal(root.get(password), "fooz")))
            .orderBy(builder.asc(root.get(account))).groupBy(root.get(account)));
        for (final Member member : typedQuery.getResultList()) {
            this.log.info(member.toString());
        }
    }
    private Member createMember(final String aAccount, final String aPassword) {
        final Member member = new Member();
        member.setAccount(aAccount);
        member.setPassword(aPassword);
        return member;
    }
}
