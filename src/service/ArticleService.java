package service;

import java.util.List;

import bean.Article;
import dao.ArticleDaoImpl;

public class ArticleService {
   private static ArticleDaoImpl adi = new ArticleDaoImpl();
    public boolean save(Article art) {

    	return adi.save(art);
   }
    
    public Article get(int id) {
    	return adi.get(id);
    }
    
    public List getAll() {
    	return adi.getAll();
    }
    
}
