package com.team4.lib.mybaties.activemodel;


public class DefaultSessionFactory extends SessionFactorySupoort implements SessionFactory {

  private static class SingletonHolder {
    private static final DefaultSessionFactory INSTANCE = new DefaultSessionFactory();
  }

  public static DefaultSessionFactory getInstance() {
    return SingletonHolder.INSTANCE;
  }

  private DefaultSessionFactory() {
    super();
  }
}
