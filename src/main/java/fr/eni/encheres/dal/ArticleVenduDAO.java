package fr.eni.encheres.dal;

import java.util.List;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.exception.BusinessException;

public interface ArticleVenduDAO {
	
	public void insert(ArticleVendu articleVendu) throws BusinessException;
	public List<ArticleVendu> selectAll() throws BusinessException;
	public void delete (int id) throws BusinessException;
	public void update(ArticleVendu articleVendu) throws BusinessException;
	public List<ArticleVendu> selectByUser(int id) throws BusinessException;
	
}
