// ========================================================================
// Copyright (C) Kamuy Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package kamuy.infra;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.googlecode.jeeunit.JeeunitRunner;
import com.googlecode.jeeunit.Transactional;
import kamuy.infra.persistence.PrimaryEntityManager;
/**
 * Test for {@link AbstractPersistenceController}.
 * @author nilcy
 */
@RunWith(JeeunitRunner.class)
@Transactional
@SuppressWarnings("all")
public class AbstractPersistenceControllerTest {
    private final AbstractPersistenceController<EntityManager> testee = new AbstractPersistenceController<EntityManager>() {
        @Override
        protected String getPersitenceContextName() {
            return "entityManager";
        }
    };
    @Inject
    @PrimaryEntityManager
    private EntityManager entityManager;
    @Test
    public void testAbstractPersistenceController() {
        assertThat(this.testee, is(not(nullValue())));
    }
    @Test
    public void testGetPersistenceContext() {
        assertThat(this.testee.getPersistenceContext(), is(nullValue()));
    }
    @Test
    public void testSetPersistenceContext() {
        this.testee.setPersistenceContext(this.entityManager);
        assertThat(this.testee.getPersistenceContext(), is(this.entityManager));
    }
    @Test
    public void testGetPersitenceContextName() {
        assertThat(this.testee.getPersitenceContextName(), is("entityManager"));
    }
}
