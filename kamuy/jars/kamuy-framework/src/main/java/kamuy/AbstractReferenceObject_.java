// ========================================================================
// Copyright (C) Kamuy Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package kamuy;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
/**
 * Reference object metadata.
 * @author nilcy
 */
// CHECKSTYLE:OFF
@StaticMetamodel(AbstractReferenceObject.class)
public class AbstractReferenceObject_ {
    /** ID */
    public static volatile SingularAttribute<AbstractReferenceObject<?>, Long> id;
}
