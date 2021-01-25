package lk.ijse.hibernate.dao;

import lk.ijse.hibernate.entity.SuperEntity;

import java.io.Serializable;
import java.util.List;

public interface CrudDAO<T extends SuperEntity, ID extends Serializable> extends SuperDAO {
    boolean add(T t) throws Exception;

    boolean delete(ID id);

    boolean update(T t);

    T search(ID id);

    List<T> getAll();
}
