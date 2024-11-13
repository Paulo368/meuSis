/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;

/**
 *
 * @author 1547816
 */
public class ClienteDAO {

    public void inserir(Cliente cli)  {
        
        
    }
    
    
    public void alterar(Cliente cli )  {
        
        
        
    }
    
    

    public void excluir(Cliente cli)  {
               
    }

    public List<Cliente> listar()  {
        return pesquisar(null,0);
    }
    
    private List<Cliente> pesquisar(String pesq, int tipo)  {
                List<Cliente> lista = new ArrayList();
        
      
        
        return null; 
                 
    }
    
    
    public List<Cliente> pesquisarPorNome(String pesq)  {
        return pesquisar(pesq, 1);
    }
    
    public List<Cliente> pesquisarPorBairro(String pesq)  {
        return pesquisar(pesq, 2);
    }
    
    public List<Cliente> pesquisarPorMes(String pesq)  {
        return pesquisar(pesq, 3);
    }
    
}
