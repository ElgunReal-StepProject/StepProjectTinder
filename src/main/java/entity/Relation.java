package entity;

public class Relation {
  User from;
  User to;
  boolean relation;

  public Relation(User from, User to, boolean relation) {
    this.from = from;
    this.to = to;
    this.relation = relation;
  }
}
