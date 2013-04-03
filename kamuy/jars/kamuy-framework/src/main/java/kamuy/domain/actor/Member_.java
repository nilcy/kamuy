// ========================================================================
// Copyright (C) Kamuy Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package kamuy.domain.actor;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
/**
 * Reference object metadata.
 * @author nilcy
 */
// CHECKSTYLE:OFF
@StaticMetamodel(Member.class)
public class Member_ {
    /** ID */
    public static volatile SingularAttribute<Member, Long> id;
    /** Account. */
    public static volatile SingularAttribute<Member, String> account;
    /** Password. */
    public static volatile SingularAttribute<Member, String> password;
}
