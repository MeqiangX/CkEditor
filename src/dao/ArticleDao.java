package dao;

import java.util.List;

import bean.Article;

public interface ArticleDao {
    public boolean save(Article art);
    
    public Article get(int id);
    
    public List getAll();
}
