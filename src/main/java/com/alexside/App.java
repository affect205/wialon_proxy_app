package com.alexside;

import com.alexside.module.BasicModule;
import com.alexside.proxy.IProxy;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger log = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        log.info("Start app..");
        Injector injector = Guice.createInjector(new BasicModule());
        IProxy proxy = injector.getInstance(IProxy.class);
        try {
            log.info("Start proxy..");
            proxy.start();
        } catch (Throwable ex) {
            log.error("Error occurred during proxy starting: ", ex);
        }
    }
}