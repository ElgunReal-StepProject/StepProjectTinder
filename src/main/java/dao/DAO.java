package dao;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public interface DAO<T> {
  Collection<T> getAll();

  Collection<T> getAllBy(Predicate<T> predicate);

  Collection<T> getBySQLQuery(String query);

  int getID(String query);

  boolean check(String query);

  Optional<T> get(int id);

  void save(T t);

  void remove(T t);

  boolean executeSQL(String sb);
}