/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.compdevbooks.alphacosmetics.dao.mock.operacoes;

import br.com.compdevbooks.alphacosmetics.business.Fornecedor;
import br.com.compdevbooks.alphacosmetics.business.operacoes.Compra;
import br.com.compdevbooks.alphacosmetics.business.pagamento.Banco;
import br.com.compdevbooks.alphacosmetics.business.pagamento.Operadora;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.dao.ICompraDAO;
import br.com.compdevbooks.alphacosmetics.dao.IDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.cadastro.MockFornecedorDAO;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.BoletoBancarioEntity;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.CartaoCreditoEntity;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.ChequeEntity;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.PagamentoEntity;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.ParcelaPagamentoEntity;
import static br.com.compdevbooks.alphacosmetics.entity.pagamento.SituacaoPagamentoEnum.NORMAL;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.TipoPagamentoEnum;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.FornecedorEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.CompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemCompraEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemVendaEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.SituacaoCompraEnum;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MockCompraDAO implements ICompraDAO {
   private static List<CompraEntity> compras= new ArrayList();
   private static Set<ItemCompraEntity> lista= new HashSet();
   private static MockItemCompraDAO itemCompra = new MockItemCompraDAO();
   private static MockFornecedorDAO fornecedorDAO= new MockFornecedorDAO();
   private static Set<ParcelaPagamentoEntity> listaParcela = new HashSet();
   private static Operadora AOperadora = new Operadora(DAOFactory.getDAOFactory().getOperadoraDAO());
   private static Banco ABanco = new Banco(DAOFactory.getDAOFactory().getBancoDAO());
   private static Fornecedor fornecedor = new Fornecedor(DAOFactory.getDAOFactory().getFornecedorDAO());
   
   static {
       
        try {
            
             SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
             Date data = formato.parse("30/08/2017");
             lista.add(itemCompra.getById((long)1));
             lista.add(itemCompra.getById((long)2));
             CompraEntity temp;
             temp = new CompraEntity( (long) 1, data, fornecedor.getById(1l), null, SituacaoCompraEnum.LANCADA , lista);
            
             ParcelaPagamentoEntity parcela = new ParcelaPagamentoEntity();
             PagamentoEntity pagamento = new PagamentoEntity();
             parcela.setDataVencimento(data, 1);
             
             CartaoCreditoEntity cartaoCredito = new CartaoCreditoEntity();
             cartaoCredito.setId((long) 1);
             cartaoCredito.setNumero("4872568423658741");
             cartaoCredito.setValidade("30/12/2019");
             cartaoCredito.setOperadora(AOperadora.getOperadora("MasterCard"));
             parcela.setValorOriginal(256.85);
             parcela.setValorTotalPago(256.85);
             parcela.setDocumentoPagamento(cartaoCredito);
             listaParcela.add(parcela);
             
             parcela = new ParcelaPagamentoEntity();
             parcela.setDataVencimento(data, 2);
             BoletoBancarioEntity boleto = new BoletoBancarioEntity();
             
             boleto.setBancoEmissorVO(ABanco.getBancos("Banco Bradesco S.A."));
             boleto.setId((long) 1);
             boleto.setAgencia("0598-3");
             boleto.setCarteira("Registrada");
             boleto.setCodigoBarra("111252358844");

             parcela.setValorOriginal(600.00);
             parcela.setValorTotalPago(600.00);

             parcela.setDocumentoPagamento(boleto);
             listaParcela.add(parcela);

             
             parcela = new ParcelaPagamentoEntity();
             parcela.setDataVencimento(data, 3);
             boleto = new BoletoBancarioEntity();
             boleto.setBancoEmissorVO(ABanco.getBancos("Banco Bradesco S.A."));
             boleto.setId((long) 1);
             boleto.setAgencia("0598-3");
             boleto.setCarteira("Registrada");
             boleto.setCodigoBarra("235875585222555");
             parcela.setValorOriginal(620.00);
             parcela.setValorTotalPago(620.00);
             parcela.setDocumentoPagamento(boleto);
             listaParcela.add(parcela);
             
             pagamento.setListaParcelas(listaParcela);
             pagamento.setSituPagamento(NORMAL);
             pagamento.setTipoPagamento(TipoPagamentoEnum.PRAZO);
             pagamento.setId((long) 1);
             temp.setPagamentoVO(pagamento);
             compras.add(temp);
             
             
             formato = new SimpleDateFormat("dd/MM/yyyy");
             data = formato.parse("25/05/2016");
             lista= new HashSet();
             lista.add(itemCompra.getById((long)1));
             lista.add(itemCompra.getById((long)3));
             temp = new CompraEntity( (long) 2, data, fornecedor.getById(2l), null, SituacaoCompraEnum.LANCADA,lista );
             
             pagamento = new PagamentoEntity();
             listaParcela = new HashSet();
             parcela = new ParcelaPagamentoEntity();
             ChequeEntity cheque = new ChequeEntity();
             parcela.setDataVencimento(data, 1);
           
             cheque.setId((long) 1);
             cheque.setBancoVO(ABanco.getBancos("Banco do Brasil S.A."));
             cheque.setConta("65.4210-9");
             cheque.setAgencia("0032-7");
             parcela.setValorOriginal(150.00);
             parcela.setValorTotalPago(150.00);
             parcela.setDocumentoPagamento(cheque);
             listaParcela.add(parcela);
             
             
             parcela = new ParcelaPagamentoEntity();
             parcela.setDataVencimento(data, 2);
           
             cheque = new ChequeEntity();
             cheque.setId((long) 2);
             cheque.setBancoVO(ABanco.getBancos("Banco do Brasil S.A."));
             cheque.setConta("65.4210-9");
             cheque.setAgencia("0032-7");
             parcela.setValorOriginal(182.60);
             parcela.setValorTotalPago(182.60);
             parcela.setDocumentoPagamento(cheque);
             listaParcela.add(parcela);
             
             pagamento.setListaParcelas(listaParcela);
             pagamento.setSituPagamento(NORMAL);
             pagamento.setTipoPagamento(TipoPagamentoEnum.MIXTO);
             pagamento.setId((long) 1);
             temp.setPagamentoVO(pagamento);
             compras.add(temp);
            
             
             /*
             lista= new HashSet();
             
             lista.add(itemCompra.getById((long)2));
             lista.add(itemCompra.getById((long)3));
             compras.add(new CompraEntity( (long) 3, formato.parse("30/05/2016"), fornecedor.getById(3l), null, SituacaoCompraEnum.ENVIADA,lista ));
             
             parcela = new ParcelaPagamentoEntity();
             parcela.setDataVencimento(data, 1);
             boleto = new BoletoBancarioEntity();
             listaParcela = new HashSet();
             
             boleto.setBancoEmissorVO(ABanco.getBancos("Caixa Economica Federal"));
             boleto.setId((long) 1);
             boleto.setAgencia("0001-5");
             boleto.setCarteira("Não Registrada");
             boleto.setCodigoBarra("123654789");
             parcela.setValorOriginal(335.00);
             parcela.setValorTotalPago(335.00);
             parcela.setDocumentoPagamento(boleto);
             listaParcela.add(parcela);
             pagamento.setListaParcelas(listaParcela);
             pagamento.setSituPagamento(NORMAL);
             pagamento.setTipoPagamento(TipoPagamentoEnum.PRAZO);
             pagamento.setId((long) 1);
             temp.setPagamentoVO(pagamento);
             compras.add(temp);

             
             listaParcela.add(parcela);
             */
              
        } catch (ParseException ex) {
            Logger.getLogger(MockCompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

      
   }
    
    public MockCompraDAO(){  }
    
    private static MockCompraDAO singleton;
    
    public static MockCompraDAO getInstance(){
        if(singleton==null)
               singleton= new MockCompraDAO();
        return singleton;
    }

    @Override
    public void save(CompraEntity entity) {
        if(compras.indexOf(entity)<0)
            compras.add(entity);
    }

    @Override
    public void delete(CompraEntity entity) {
        compras.remove(entity);
    }

    @Override
    public CompraEntity getById(Long id) {
        for(CompraEntity vo:compras)
            if(vo.getId().equals(id))
                return vo;
        return null;
    }
    @Override
    public CompraEntity pegaCompra(ItemCompraEntity item){
        for(CompraEntity vo : compras){
            Iterator<ItemCompraEntity> i= vo.getListaItens().iterator();
            ItemCompraEntity it=null;
            while(i.hasNext()){
                it=i.next();
                if(it.getId().equals(item.getId()))
                    return vo;
            }
            
        }
        return null;
    }
    
    @Override
    public List<CompraEntity> buscarPedidoCompra(FornecedorEntity f, CompraEntity c){
        List<CompraEntity> res= new ArrayList();
        int x=0;
        for(CompraEntity vo: compras){
            x=0;
            if(vo.getFornecedorVO().getFantasia().toUpperCase().contains(f.getFantasia().toUpperCase()))
                x++;
            if(vo.getFornecedorVO().getInscricao().contains(f.getInscricao()))
                x++;
            if(vo.getFornecedorVO().getCNPJ().contains(f.getCNPJ()))
                x++;
            if(vo.getSituacao().equals(c.getSituacao()))
                x++;
            try {
                if(0!=c.getDataLancamento().compareTo(new SimpleDateFormat("dd/MM/yyyy").parse("11/11/1111"))){
                    if(vo.getDataLancamento().compareTo(c.getDataLancamento())==0)
                        x++;
                }else{
                    x++;
                }
            } catch (ParseException ex) {
                Logger.getLogger(MockCompraDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(x==5)
                res.add(vo);
        }
        return res;
    }

    @Override
    public List<CompraEntity> buscar(FornecedorEntity fornecedor, CompraEntity compra) {
        ArrayList<CompraEntity> resultado= new ArrayList<>();
        
        for(CompraEntity vo: compras)
            if(vo.getFornecedorVO().getCNPJ().toUpperCase().contains(fornecedor.getCNPJ().toUpperCase()) &&
               vo.getFornecedorVO().getInscricao().toUpperCase().contains(fornecedor.getInscricao().toUpperCase()) &&
               vo.getFornecedorVO().getFantasia().toUpperCase().contains(fornecedor.getFantasia().toUpperCase()) &&
               vo.getSituacao().equals(compra.getSituacao()) && 
                vo.getDataLancamento().equals(compra.getDataLancamento()))
                resultado.add(vo);
        return resultado;
    }

    @Override
    public List<CompraEntity> buscarTodasCompras() {
        return compras;
    }
    @Override
    public Set<ItemCompraEntity> pegarItemCompra(){
        return this.lista;
    }
    
    
    
}
