package org.synyx.urlaubsverwaltung.core.application.domain;

import org.junit.Assert;
import org.junit.Test;

import org.synyx.urlaubsverwaltung.core.person.Person;


/**
 * Unit test for {@link org.synyx.urlaubsverwaltung.core.application.domain.Comment}.
 *
 * @author  Aljona Murygina - murygina@synyx.de
 */
public class CommentTest {

    @Test
    public void ensureCanBeInitializedWithPerson() {

        Person commentingPerson = new Person();
        commentingPerson.setFirstName("Aljona");
        commentingPerson.setLastName("Mu");

        Comment comment = new Comment(commentingPerson);

        Assert.assertNotNull("Commenting person should be set", comment.getPerson());
        Assert.assertEquals("Wrong commenting person", commentingPerson, comment.getPerson());
    }
}
