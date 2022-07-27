/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author DELL
 */
public class CategoryDAO extends DBContext {

    //lay het du lieu tu bang Categories
    //select * from Categories
    public List<Category> getAll() {
        List<Category> list = new ArrayList<>();
        String sql = "select * from Categories";
        try{
            PreparedStatement st=connection.prepareStatement(sql);
            ResultSet re=st.executeQuery();
            while(re.next()){
                Category c=new Category();
                c.setId(re.getInt("id"));
                c.setName(re.getString("name"));
                c.setDescribe(re.getString("describe"));
                list.add(c);
            }
        }catch(SQLException e){
            System.out.println(e);
        }

        return list;
    }
    
    //delete from Categories where id=3
    public void delete(int id){
        String sql="delete from Categories where id=?";
        try{
            PreparedStatement st=connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
   
    //check -- Category/null
    public Category getCategoryByID(int id){
        String sql = "select * from Categories where id=?";
        
        try{
            PreparedStatement st=connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet re=st.executeQuery();
            if(re.next()){
                Category c=new Category();
                c.setId(re.getInt("id"));
                c.setName(re.getString("name"));
                c.setDescribe(re.getString("describe"));
                return c;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    
    //insert into Categories values (7, 'kkkkk', 'long lanh')
    public void insert(Category c){
        String sql="insert into Categories values (?,?,?)";
        try{
            PreparedStatement st=connection.prepareStatement(sql);
            st.setInt(1, c.getId());
            st.setString(2, c.getName());
            st.setString(3, c.getDescribe());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    //update
    public void update(Category c){
        String sql="update Categories set name=?, describe=? where id=?";
        try{
            PreparedStatement st=connection.prepareStatement(sql);
            st.setString(1, c.getName());
            st.setString(2, c.getDescribe());
            st.setInt(3, c.getId());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    //test co ket noi duoc voi database ko
    public static void main(String[] args) {
        CategoryDAO c=new CategoryDAO();
        List<Category> list=c.getAll();
        System.out.println(list.get(0).getName());
    }
}
