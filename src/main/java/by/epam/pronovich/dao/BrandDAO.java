package by.epam.pronovich.dao;

import by.epam.pronovich.exception.DAOException;
import by.epam.pronovich.model.Brand;

import java.util.List;

public interface BrandDAO {

    List<Brand> getAll()throws DAOException;
}
