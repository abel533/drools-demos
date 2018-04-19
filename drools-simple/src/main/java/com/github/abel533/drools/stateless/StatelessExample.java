package com.github.abel533.drools.stateless;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

import java.util.Arrays;

/**
 * https://docs.jboss.org/drools/release/7.7.0.Final/drools-docs/html_single/index.html#_stateless_knowledge_session
 */
public class StatelessExample {
    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kContainer = kieServices.getKieClasspathContainer();
        StatelessKieSession kSession = kContainer.newStatelessKieSession();
        Applicant applicant = new Applicant( "Mr John Smith", 16 );
        Application application = new Application();
        assertTrue( application.isValid() );
        kSession.execute( Arrays.asList( new Object[] { application, applicant } ) );
        assertFalse( application.isValid() );
    }

    private static void assertFalse(boolean valid) {
        if(valid){
            throw new RuntimeException("预期为 false, 但值为 true");
        }
    }

    private static void assertTrue(boolean valid) {
        if(!valid){
            throw new RuntimeException("预期为 true, 但值为 false");
        }
    }
}
