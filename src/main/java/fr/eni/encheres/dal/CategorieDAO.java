package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.exception.BusinessException;

public interface CategorieDAO {
	public Categorie getByID(int id) throws BusinessException ;
	public void delete(int id) throws BusinessException;
	public void insert(Categorie categorie) throws BusinessException;
	public List<Categorie> selectAll() throws BusinessException;
	public Categorie selectByLibelle(String categorie)throws BusinessException;
	public void update(Categorie categorie) throws BusinessException;
}










