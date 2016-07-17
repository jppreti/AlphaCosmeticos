/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.dao.mock.pagamento;

import br.com.compdevbooks.alphacosmetics.dao.IBancoDAO;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.BancoEntity;
import java.util.ArrayList;
import java.util.List;

public class MockBancoDAO implements IBancoDAO{
    
    private static  List<BancoEntity> bancos= new ArrayList<>();
    
    
    static {
        
        BancoEntity banco = new BancoEntity();
        
        banco.setId((long)1);
        banco.setCodigo("001");
        banco.setNome("Banco do Brasil S.A.");        
        bancos.add(banco);
        
        banco.setId((long)2);
        banco.setCodigo("237");
        banco.setNome("Banco Bradesco S.A.");        
        bancos.add(banco);
        
        banco.setId((long)3);
        banco.setCodigo("104");
        banco.setNome("Caixa Economica Federal");        
        bancos.add(banco);     
        
    }
    
     private static MockBancoDAO singleton = null;
   
    public static MockBancoDAO getInstance() {
		if (singleton == null)
			singleton = new MockBancoDAO();
		
		return singleton;
	}

    @Override
    public List<BancoEntity> buscarTodosBancos() {
        return bancos;    
    }

    @Override
    public void save(BancoEntity entity) {
    if(bancos.indexOf(entity)<0)
           bancos.add(entity); 
    }

    @Override
    public void delete(BancoEntity entity) {
      bancos.remove(entity);
    }

    @Override
    public BancoEntity getById(Long id) {
         for(BancoEntity vo: bancos)
           if(vo.getId().equals(id))
               return vo;
       return null;
    
    }

    @Override
    public BancoEntity getByNome(String nome) {
         for (BancoEntity vo : bancos) {
            if (vo.getNome().equals(nome)) {
                return vo;
            }
        }

        return null;
    
    }
    
}
