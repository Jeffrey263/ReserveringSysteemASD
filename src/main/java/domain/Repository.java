package domain;

import java.util.List;

public interface Repository<T> {
    public void add(Object o);
    public void remove(Object o);
    public List<T> getAll();
    public Object getById(int id);
}
