package br.com.compdevbooks.alphacosmetics.dao.mock.produtos;

import br.com.compdevbooks.alphacosmetics.dao.IProdutoDAO;
import br.com.compdevbooks.alphacosmetics.dao.mock.cadastro.MockFornecedorDAO;
import br.com.compdevbooks.alphacosmetics.entity.produto.ProdutoEntity;
import java.util.ArrayList;
import java.util.List;


public class MockProdutoDAO implements IProdutoDAO {

    private static List<ProdutoEntity> produtos = new ArrayList<>();
    private static MockCategoriaDAO cat = new MockCategoriaDAO();
    private static MockFornecedorDAO fornecedor = new MockFornecedorDAO();

    static {
        produtos.add(new ProdutoEntity((long) 1, "One Million","","", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 1), 30,11,50, fornecedor.getById((long) 1)));
        produtos.add(new ProdutoEntity((long) 2, "Vermelho","", "", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 2), 40,11, 40, fornecedor.getById((long) 2)));
        produtos.add(new ProdutoEntity((long) 3, "head shoulder","","", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 3), 50,12,30, fornecedor.getById((long) 3)));
        
        //(Perfumaria)Masculino->Fragrancias 
        produtos.add(new ProdutoEntity((long) 4, "Colônia Desodorante 015","100 ml","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 6), 50,12,30, fornecedor.getById((long) 3)));
        //(Perfumaria)Masculino->Barbear
        produtos.add(new ProdutoEntity((long) 5, "Loção pós barba","100 ml","Alpha", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 7), 50,12,30, fornecedor.getById((long) 3)));
        
        //(Perfumaria)Infantil->Colonia
        produtos.add(new ProdutoEntity((long) 6, "Kit de colonias para meninas","Cinderela, Bela e Branca de Neve. 15 ml cada.","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 8), 50,12,30, fornecedor.getById((long) 3)));
        
        //(Perfumaria)Feminina->Fragrancias
        produtos.add(new ProdutoEntity((long) 7, "Refrescantes Alfazema","300 ml","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 9), 50,12,30, fornecedor.getById((long) 3)));
        //(Perfumaria)Feminina->Locao Perfumada
        produtos.add(new ProdutoEntity((long) 8, "Creme Hidratante para o Corpo","200 g","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 10), 50,12,30, fornecedor.getById((long) 3)));
        
        /*Olhos*/
        //(Maquiagem)Olhos->Sombra
        produtos.add(new ProdutoEntity((long) 9, "Lápis Sombra","2.8 g","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 16), 50,12,30, fornecedor.getById((long) 3)));
        //(Maquiagem)Olhos->Delineador
        produtos.add(new ProdutoEntity((long) 10, "Lápis para Esfumar Olhos","1.08 g","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 17), 50,12,30, fornecedor.getById((long) 3)));
        //(Maquiagem)Olhos->Mascara
        produtos.add(new ProdutoEntity((long) 11, "Máscara Incolor para Cílios","8 g","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 18), 50,12,30, fornecedor.getById((long) 3)));
        //(Maquiagem)Olhos->Outro
        produtos.add(new ProdutoEntity((long) 12, "Loção para Remover Maquiagem dos Olhos","60 ml","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 19), 50,12,30, fornecedor.getById((long) 3)));
        
        /*Labios*/
        //(Maquiagem)Labios->Batom
        produtos.add(new ProdutoEntity((long) 13, "Batom Color Trend","3.6 g","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 20), 50,12,30, fornecedor.getById((long) 3)));
        //(Maquiagem)Labios->Brilho Labial
        produtos.add(new ProdutoEntity((long) 14, "Moranguinho","10 g","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 21), 50,12,30, fornecedor.getById((long) 3)));
        //(Maquiagem)Labios->Condicionador Labial
        produtos.add(new ProdutoEntity((long) 15, "Condicionador Labial com Retinol FPS 15","3.6 g","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 22), 50,12,30, fornecedor.getById((long) 3)));
        //(Maquiagem)Labios->Contorno
        produtos.add(new ProdutoEntity((long) 16, "Ultra Color Delineador Retrátil para Lábios","0.25 g","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 23), 50,12,30, fornecedor.getById((long) 3)));
        /*Rosto*/
        //(Maquiagem)Rosto->Base
        produtos.add(new ProdutoEntity((long) 17, "Base Líquida FPS 15","30 ml","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 24), 50,12,30, fornecedor.getById((long) 3)));
        //(Maquiagem)Rosto->Blush
        produtos.add(new ProdutoEntity((long) 18, "Blush em Pó","2 g","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 25), 50,12,30, fornecedor.getById((long) 3)));
        //(Maquiagem)Rosto->Corretivo
        produtos.add(new ProdutoEntity((long) 19, "Corretivo Líquido","10 g","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 26), 50,12,30, fornecedor.getById((long) 3)));
        //(Maquiagem)Rosto->Outros
        produtos.add(new ProdutoEntity((long) 20, "Primer Transformador da Pele","28 ml","Renew", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 27), 50,12,30, fornecedor.getById((long) 3)));
        //(Maquiagem)Rosto->Po Compacto
        produtos.add(new ProdutoEntity((long) 21, "Pó Compacto FPS 10","14 g","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 28), 50,12,30, fornecedor.getById((long) 3)));
        /*Unhas*/
        //(Maquiagem)Unhas->Esmalte
        produtos.add(new ProdutoEntity((long) 22, "Esmalte Brilho e Longa Duração","8 ml","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 29), 50,12,30, fornecedor.getById((long) 3)));
        //(Maquiagem)Unhas->Tratamento
        produtos.add(new ProdutoEntity((long) 23, "Base Niveladora para Unhas","8 ml","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 30), 50,12,30, fornecedor.getById((long) 3)));

    }

    public MockProdutoDAO() {
    }
    private static MockProdutoDAO singleton;

    public static MockProdutoDAO getInstace() {
        if (singleton == null) {
            singleton = new MockProdutoDAO();
        }
        return singleton;
    }

    @Override
    public void save(ProdutoEntity entity) {
        if (produtos.indexOf(entity) < 0) {
            produtos.add(entity);
        }
    }

    @Override
    public void delete(ProdutoEntity entity) {
        produtos.remove(entity);
    }

    @Override
    public ProdutoEntity getById(Long id) {
        for (ProdutoEntity vo : produtos) {
            if (vo.getId().equals(id)) {
                return vo;
            }
        }
        return null;
    }

    public List<ProdutoEntity> buscarTodosProdutos() {
        return produtos;
    }

    public List<ProdutoEntity> buscarProdutos(ProdutoEntity pro) {
        ArrayList<ProdutoEntity> buscado = new ArrayList<>();
        int x;

        for (ProdutoEntity vo : produtos) {
            x = 0;
            if (pro.getNome().equals("") || vo.getNome().toUpperCase().contains(pro.getNome().toUpperCase())) {
                x++;
            }
            if (pro.getCategoria() == null || pro.getCategoria().getId().equals(vo.getCategoria().getId())) {
                x++;
            }
            if (pro.getFornecedor().getFantasia().equals("") || vo.getFornecedor().getFantasia().toUpperCase().contains(pro.getFornecedor().getFantasia().toUpperCase())) {
                x++;
            }
            if (pro.getQuantidade() == 0 || pro.getQuantidade() <= vo.getQuantidade()) {
                x++;
            }

            if (x == 4) {
                buscado.add(vo);
            }
        }
        return buscado;
    }
    
    @Override
	public List<ProdutoEntity> getByNome(String nome) {
		ArrayList<ProdutoEntity> resultado = new ArrayList<>();
		for (ProdutoEntity vo : produtos)
			if (vo.getNome().toUpperCase().contains(nome.toUpperCase()))
				resultado.add(vo);		
		return resultado;
	}
}
