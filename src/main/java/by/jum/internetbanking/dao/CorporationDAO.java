package by.jum.internetbanking.dao;

import by.jum.internetbanking.entity.Corporation;

public interface CorporationDAO {
    void save(Corporation corporation);

    void update(Corporation corporation);

    void delete(Corporation corporation);

    void deleteByID(long id);

    Corporation getByID(Long id);

    Corporation getByName(String name);
}
