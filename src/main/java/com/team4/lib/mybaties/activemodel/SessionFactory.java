package com.team4.lib.mybaties.activemodel;

import org.apache.ibatis.session.SqlSession;

public interface SessionFactory {
  SqlSession openSession();
}