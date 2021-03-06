package br.com.compdevbooks.alphacosmetics.dao.mock.operacoes;

import br.com.compdevbooks.alphacosmetics.business.operacoes.Venda;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.dao.IComissaoDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.cadastro.MockVendedorDAO;
import br.com.compdevbooks.alphacosmetics.entity.pagamento.ParcelaPagamentoEntity;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.ClienteEntity;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.VendedorEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ComissaoEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ItemVendaEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.ParcelaComissaoEntity;
import br.com.compdevbooks.alphacosmetics.entity.produto.VendaEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MockComissaoDAO implements IComissaoDAO {

    private static List<ComissaoEntity> ListaComissao = new ArrayList();
    private static Venda venda = new Venda(DAOFactory.getDAOFactory().getVendaDAO());
    private static VendaEntity vendaEntity;

    private static MockComissaoDAO singlenton;
    long a;
    int i;

    /*
    static {
        try {
            float total = 0;
            int tamanho = 0;
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date dataVenda = formato.parse("16/07/2016");
            ComissaoEntity temp = new ComissaoEntity((long) 1, dataVenda);
            vendaEntity = venda.getById(1l);
            temp.setVenda(vendaEntity);
            temp.setVendedor(vendaEntity.getClienteVO().getVendedorVO());
            VendedorEntity vendedorVO = null;

            System.out.println(vendaEntity.getClienteVO().getNome());
            System.out.println(vendaEntity.getId());
            System.out.println("---------------------------------------");

    
    
    
            for (VendedorEntity vendedor : MockVendedorDAO.getLista()) {

                System.out.println(vendedor.getNome());

                for (ClienteEntity cli : vendedor.getListaClientes()) {

                    System.out.println(cli.getId() + " " + cli.getNome());

                    if (cli.equals(vendaEntity.getClienteVO())) {

                        vendedorVO = vendedor;
                    }
                }

            }
    
    
    

            if (vendedorVO == null) {
                System.out.println("Não encontrou o cliente, classe MockCOmissaoDAO");
            } else {
                temp.setVendedor(vendedorVO);

            }

            for (ItemVendaEntity itensVenda : vendaEntity.getListaItens()) {
                total += (itensVenda.getPercComissao() / 100) * itensVenda.getQuantidade()
                        * itensVenda.getProdutoVO().getValorVenda();
            }
            tamanho = vendaEntity.getPagamentoVO().getListaParcelas().size();
            total = total / tamanho;

            for (int i = 0; i < tamanho; i++) {
                long a;
                a = (long) i + 1;
                ParcelaComissaoEntity parcelaComissao = new ParcelaComissaoEntity();
                parcelaComissao.setValorParcela(total);
                parcelaComissao.setId(a);
                System.out.println(a);
                parcelaComissao.setDataVencimento(vendaEntity.getDataVencimento().get(i));
                listaParcelaComissoes.add(parcelaComissao);
            }
            temp.setListaParcelaComissao(listaParcelaComissoes);
            ListaComissao.add(temp);

        } catch (ParseException ex) {
            Logger.getLogger(MockComissaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }*/
    public static MockComissaoDAO getInstace() {
        if (singlenton == null) {
            return singlenton = new MockComissaoDAO();
        }
        return singlenton;
    }

    @Override
    public List<ComissaoEntity> BuscarTodasComissoes() {
        return ListaComissao;
    }

    @Override
    public void carregar() {
        List<VendaEntity> ListaVenda = venda.buscarTodasVendas();

        if (ListaComissao.isEmpty()) {
            for (VendaEntity vo : ListaVenda) {
                adicionarComissao(vo);
            }

        } else {
          
            boolean gerada = false;

            for (VendaEntity vo : ListaVenda) {
                for (ComissaoEntity comi : ListaComissao) {
                    if (vo.equals(comi.getVenda())) {
                        gerada = true;

                    } else {
                        System.out.println("MOCKCOMISSAO");
                        System.out.println(comi.getVenda().getNomeCliente());
                        System.out.println(comi.getVendedor().getNome());
                        System.out.println("FIM MOCK");
                      
                    }

                }

                if (!gerada) {
                    adicionarComissao(vo);
                }
            }

        }

    }

    public void adicionarComissao(VendaEntity vo) {

        List<ComissaoEntity> aux = new ArrayList();
        float total = 0;
        int tamanho = 0;

        Set<ParcelaComissaoEntity> listaParcelaComissoes = new HashSet();
        i++;
        ComissaoEntity temp;
        temp = new ComissaoEntity((long) ListaComissao.size() + i, vo.getDataAprovacao());
        temp.setVenda(vo);
        temp.setVendedor(vo.getClienteVO().getVendedorVO());
        VendedorEntity vendedorVO = null;

        for (VendedorEntity vendedor : MockVendedorDAO.getLista()) {

            System.out.println(vendedor.getNome());

            for (ClienteEntity cli : vendedor.getListaClientes()) {

                System.out.println(cli.getId() + " " + cli.getNome());

                if (cli.equals(vo.getClienteVO())) {

                    vendedorVO = vendedor;
                }
            }

        }
        if (vendedorVO == null) {
            System.out.println("Não encontrou o cliente, classe MockCOmissaoDAO");
        } else {
            temp.setVendedor(vendedorVO);

        }
        total = 0;
        tamanho = 0;
        for (ItemVendaEntity itensVenda : vo.getListaItens()) {
            total += (itensVenda.getPercComissao() / 100) * itensVenda.getQuantidade()
                    * itensVenda.getProdutoVO().getValorVenda();
        }
        tamanho = vo.getPagamentoVO().getListaParcelas().size();
        total = total / tamanho;

        for (i = 0; i < tamanho; i++) {

            a++;

            ParcelaComissaoEntity parcelaComissao = new ParcelaComissaoEntity();
            parcelaComissao.setValorParcela(total);
            parcelaComissao.setId(a);
            System.out.println(a);
            parcelaComissao.setDataVencimento(vo.getDataVencimento().get(i));
            listaParcelaComissoes.add(parcelaComissao);
        }
        temp.setListaParcelaComissao(listaParcelaComissoes);
        aux.add(temp);

        for (ComissaoEntity comi : aux) {
            ListaComissao.add(comi);
        }
        aux.clear();
    }

    @Override
    public void save(ComissaoEntity entity) {
        if (ListaComissao.indexOf(entity) < 0) {
            ListaComissao.add(entity);
        }
    }

    @Override
    public void delete(ComissaoEntity entity) {
        ListaComissao.remove(entity);
    }

    @Override
    public ComissaoEntity getById(Long id) {
        for (ComissaoEntity vo : ListaComissao) {
            if (vo.getId().equals(id)) {
                return vo;
            }
        }
        return null;
    }

}
