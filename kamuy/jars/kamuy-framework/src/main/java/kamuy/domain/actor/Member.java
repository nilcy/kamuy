// ========================================================================
// Copyright (C) Kamuy Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package kamuy.domain.actor;
import javax.persistence.Entity;
import kamuy.AbstractReferenceObject;
/**
 * Member.
 * @author nilcy
 */
@Entity
public class Member extends AbstractReferenceObject<Member> {
    /** S/N. */
    private static final long serialVersionUID = -380304895857169591L;
    /** Account. */
    private String account;
    /** Password. */
    private String password;
    /** Constructor. */
    public Member() {
        super();
    }
    /**
     * Get {@link #account}.
     * @return {@link #account}
     */
    public String getAccount() {
        return this.account;
    }
    /**
     * Set {@link #account}.
     * @param aAccount {@link #account}
     */
    public void setAccount(final String aAccount) {
        this.account = aAccount;
    }
    /**
     * Get {@link #password}.
     * @return {@link #password}
     */
    public String getPassword() {
        return this.password;
    }
    /**
     * Set {@link #password}.
     * @param aPassword {@link #password}
     */
    public void setPassword(final String aPassword) {
        this.password = aPassword;
    }
}
