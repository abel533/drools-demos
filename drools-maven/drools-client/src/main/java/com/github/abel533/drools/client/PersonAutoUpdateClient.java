package com.github.abel533.drools.client;

import com.github.abel533.drools.fact.Person;
import org.appformer.maven.integration.embedder.MavenSettings;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.event.kiescanner.KieScannerEventListener;
import org.kie.api.event.kiescanner.KieScannerStatusChangeEvent;
import org.kie.api.event.kiescanner.KieScannerUpdateResultsEvent;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Scanner;

public class PersonAutoUpdateClient {
    public static final Logger L = LoggerFactory.getLogger(PersonAutoUpdateClient.class);

    public static final void main(final String[] args) {
        System.setProperty(MavenSettings.CUSTOM_SETTINGS_PROPERTY,
                "D:\\Program Files\\apache-maven-3.3.3\\conf\\settings.xml");

        KieServices kieServices = KieServices.Factory.get();
        //版本号介绍: https://docs.jboss.org/drools/release/7.7.0.Final/drools-docs/html_single/index.html#_maven_versions_and_dependencies
        ReleaseId releaseId = kieServices.newReleaseId(
                "com.github.abel533",
                "drools-rules",
                "[1.0.0-SNAPSHOT,)" );
        KieContainer kieContainer = kieServices.newKieContainer( releaseId );

        //监控更新
        KieScanner kieScanner = kieServices.newKieScanner(kieContainer);
        kieScanner.addListener(new KieScannerEventListener() {
            @Override
            public void onKieScannerStatusChangeEvent(KieScannerStatusChangeEvent statusChange) {
                //固定间隔时间反复触发
            }

            @Override
            public void onKieScannerUpdateResultsEvent(KieScannerUpdateResultsEvent updateResults) {
                L.info("状态发生变化, 执行一次规则");
                runRule(kieContainer.newKieSession("PersonRules"));
                L.info("按下任何键退出!");
            }
        });
        kieScanner.start(10000L);

        L.info("第一次主动执行:");
        runRule(kieContainer.newKieSession("PersonRules"));
        L.info("测试时，你可以修改 drools-rules 项目，然后 mvn install 到本地仓库来查看变化");
        L.info("按下任何键退出！");
        try {
            System.in.read();
            L.info("退出！");
        } catch (IOException e) {
        }
    }

    public static void runRule(KieSession ksession){
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
