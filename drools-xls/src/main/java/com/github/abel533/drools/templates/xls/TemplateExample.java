package com.github.abel533.drools.templates.xls;

import com.github.abel533.drools.xls.Ticket;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

public class TemplateExample {

    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kContainer = kieServices.getKieClasspathContainer();
        StatelessKieSession ksession = kContainer.newStatelessKieSession("templateTicket");

        Ticket ticket = new Ticket("欧美");
        System.out.printf("Before: %s\n", ticket);
        ksession.execute(ticket);
        System.out.printf("After : %s\n", ticket);

        ticket = new Ticket("非欧美", "商务舱");
        System.out.printf("Before: %s\n", ticket);
        ksession.execute(ticket);
        System.out.printf("After : %s\n", ticket);

        ticket = new Ticket("非欧美", "经济舱");
        System.out.printf("Before: %s\n", ticket);
        ksession.execute(ticket);
        System.out.printf("After : %s\n", ticket);

        ticket = new Ticket("国内", "经济舱", 1);
        System.out.printf("Before: %s\n", ticket);
        ksession.execute(ticket);
        System.out.printf("After : %s\n", ticket);

        ticket = new Ticket("国内", "经济舱", 3);
        System.out.printf("Before: %s\n", ticket);
        ksession.execute(ticket);
        System.out.printf("After : %s\n", ticket);

        ticket = new Ticket("国内", "商务舱");
        System.out.printf("Before: %s\n", ticket);
        ksession.execute(ticket);
        System.out.printf("After : %s\n", ticket);
    }

}
