package com.alexside.module;

import com.alexside.config.AppConfig;
import com.alexside.proxy.IProxy;
import com.alexside.proxy.netty.NettyProxyImpl;
import com.alexside.proxy.netty.WialonHandler;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class BasicModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AppConfig.class)
                .asEagerSingleton();
        bind(IProxy.class)
                .to(NettyProxyImpl.class)
                .in(Scopes.SINGLETON);
        bind(WialonHandler.class)
                .in(Scopes.SINGLETON);
    }
}