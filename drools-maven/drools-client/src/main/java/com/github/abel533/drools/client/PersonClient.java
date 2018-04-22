package com.github.abel533.drools.client;

import com.github.abel533.drools.fact.Person;
import org.apache.maven.reporting.MavenReportException;
import org.appformer.maven.integration.MavenRepository;
import org.appformer.maven.integration.embedder.MavenSettings;
import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonClient {
    public static final Logger L = LoggerFactory.getLogger(PersonClient.class);

    public static final void main(final String[] args) {

        System.setProperty(MavenSettings.CUSTOM_SETTINGS_PROPERTY,
                "D:\\Program Files\\apache-maven-3.3.3\\conf\\settings.xml");

        KieServices kieServices = KieServices.Factory.get();
        ReleaseId releaseId = kieServices.newReleaseId( "com.github.abel533", "drools-rules", "1.0.0-SNAPSHOT" );
        KieContainer kieContainer = kieServices.newKieContainer( releaseId );

        KieSession ksession = kieContainer.newKieSession("PersonRules");

        ksession.addEventListener(new DebugAgendaEventListener());
        ksession.addEventListener(new DebugRuleRuntimeEventListener());

        Person zhangsan = new Person("张三", (byte) 30);
        ksession.insert(zhangsan);

        // and fire the rules
        int total = ksession.fireAllRules();
        ksession.dispose();

        L.info("执行了 {} 条规则", total);
        L.info("执行后的姓名:{}", zhangsan.getName());
    }

}
