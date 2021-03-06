package org.synyx.urlaubsverwaltung.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Service;

import org.springframework.ui.Model;

import org.synyx.urlaubsverwaltung.core.person.Person;
import org.synyx.urlaubsverwaltung.core.person.PersonService;
import org.synyx.urlaubsverwaltung.web.person.PersonConstants;


/**
 * @author  Aljona Murygina - murygina@synyx.de
 */
@Service
public class SessionService {

    private final PersonService personService;

    @Autowired
    public SessionService(PersonService personService) {

        this.personService = personService;
    }

    /**
     * This method allows to get a person by logged-in user.
     *
     * @return  Person that is logged in
     */
    public Person getLoggedUser() {

        String user = SecurityContextHolder.getContext().getAuthentication().getName();

        return personService.getPersonByLogin(user);
    }


    public boolean isOffice() {

        if (getLoggedUser().hasRole(Role.OFFICE)) {
            return true;
        }

        return false;
    }


    public boolean isBoss() {

        if (getLoggedUser().hasRole(Role.BOSS)) {
            return true;
        }

        return false;
    }


    public boolean isInactive() {

        if (getLoggedUser().hasRole(Role.INACTIVE)) {
            return true;
        }

        return false;
    }
}
