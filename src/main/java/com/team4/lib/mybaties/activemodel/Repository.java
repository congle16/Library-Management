package com.team4.lib.mybaties.activemodel;

import java.util.function.Consumer;
import java.util.function.Function;
import org.apache.ibatis.session.SqlSession;

public abstract class Repository<M> {
  protected abstract M repositoryMapper(SqlSession session);

  protected <R> R execute(Function<M, R> func) {
    try (SqlSession session = getSessionFactory().openSession()) {
      M mapper = repositoryMapper(session);
      R result = func.apply(mapper);
      session.commit();
      return result;
    }
  }

  protected void execute(Consumer<M> func) {
    try (SqlSession session = getSessionFactory().openSession()) {
      M mapper = repositoryMapper(session);
      func.accept(mapper);
      session.commit();
    }
  }

  protected SessionFactory getSessionFactory() {
    return DefaultSessionFactory.getInstance();
  }
}
