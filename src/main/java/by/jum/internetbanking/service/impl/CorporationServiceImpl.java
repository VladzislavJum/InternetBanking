package by.jum.internetbanking.service.impl;

import by.jum.internetbanking.dao.CorporationDAO;
import by.jum.internetbanking.entity.Corporation;
import by.jum.internetbanking.service.CorporationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CorporationServiceImpl implements CorporationService {

    @Autowired
    private CorporationDAO corporationDAO;

    @Override
    @Transactional
    public Corporation getByID(Long id) {
        return corporationDAO.getByID(id);
    }

    @Override
    @Transactional
    public Corporation getByName(String name) {
        return corporationDAO.getByName(name);
    }
}
