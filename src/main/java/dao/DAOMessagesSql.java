package dao;

import entity.Message;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public class DAOMessagesSql implements DAO<Message> {
  @Override
  public Collection<Message> getAll() {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public Collection<Message> getAllBy(Predicate<Message> predicate) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public Collection<Message> getBySQLQuery(String query) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public int getID(String query) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public boolean check(String query) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public Optional<Message> get(int id) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public void save(Message message) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public void remove(Message message) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public boolean executeSQL(String sb) {
    throw new RuntimeException("Not implemented");
  }
}
