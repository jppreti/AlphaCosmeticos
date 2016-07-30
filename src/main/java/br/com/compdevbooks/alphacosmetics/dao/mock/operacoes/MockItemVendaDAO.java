/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.dao.mock.operacoes;

import br.com.compdevbooks.alphacosmetics.dao.IItemVendaDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.produtos.MockProdutoDAO;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemVendaEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Josiel
 */
public class MockItemVendaDAO implements IItemVendaDAO {
    private static List<ItemVendaEntity> itens= new ArrayList();
    private static MockProdutoDAO produto = new MockProdutoDAO();
    private Date dataVenda;
    private Date dataPagamento;
    private float ValorVenda;
    
    private static MockItemVendaDAO singlenton;
    
    public MockItemVendaDAO(){ }
    
    public static MockItemVendaDAO getInstace(){
        if(singlenton==null)
            return singlenton =new MockItemVendaDAO();
        return singlenton;
    }
    static {
        itens.add(new ItemVendaEntity((long) 1, 10, (float) 5.0,(float) 5.0, produto.getById((long) 1)));
        itens.add(new ItemVendaEntity((long) 2, 25, (float) 5.0,(float) 5.0, produto.getById((long) 2)));
        itens.add(new ItemVendaEntity((long) 3, 15, (float) 5.0,(float) 5.0, produto.getById((long) 3)));
        
        
    }
    
    @Override
    public void save(ItemVendaEntity entity) {
        if(itens.indexOf(entity)<0)
            itens.add(entity);
    }

    @Override
    public void delete(ItemVendaEntity entity) {
        itens.remove(entity);
    }

    @Override
    public ItemVendaEntity getById(Long id) {
       for(ItemVendaEntity vo: itens)
           if(vo.getId().equals(id))
               return vo;
       return null;
    }
    
    public List<ItemVendaEntity> buscarTodosItemVendas() {
        return itens;
    }
    
    public List<ItemVendaEntity> buscarPorProduto(Long id){
        List<ItemVendaEntity> temp= new ArrayList();
        for(ItemVendaEntity vo: itens)
            if(vo.getProdutoVO().getId().equals(id))
                temp.add(vo);
        return temp;
    }

    public List<ItemVendaEntity> buscarItensVenda(ItemVendaEntity ic) {

        ArrayList<ItemVendaEntity> buscado = new ArrayList<>();
        int x;

        for (ItemVendaEntity vo : itens) {
            x = 0;
            if (ic.getProdutoVO().getNome().equals("") || vo.getProdutoVO().getNome().toUpperCase().contains(ic.getProdutoVO().getNome().toUpperCase())) {
                x++;
            }
            if (ic.getProdutoVO().getCategoria() == null || ic.getProdutoVO().getCategoria().getId().equals(vo.getProdutoVO().getCategoria().getId())) {
                x++;
            }
            if (ic.getProdutoVO().getFornecedor().getFantasia().equals("") || vo.getProdutoVO().getFornecedor().getFantasia().toUpperCase().contains(ic.getProdutoVO().getFornecedor().getFantasia().toUpperCase())) {
                x++;
            }
            if (ic.getQuantidade() == 0 || ic.getQuantidade() <= vo.getQuantidade()) {
                x++;
            }
            if (x == 4) {
                buscado.add(vo);
            }
        }
        return buscado;
    }
}
