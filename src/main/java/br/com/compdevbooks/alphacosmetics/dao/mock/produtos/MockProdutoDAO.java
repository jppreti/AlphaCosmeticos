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
        produtos.add(new ProdutoEntity((long) 4, "Colônia Desodorante 015","100ml","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 6), 50,12,30, fornecedor.getById((long) 3)));
        produtos.add(new ProdutoEntity((long) 5, "Portinari Des.Colônia","100ml","Boticário", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 6), 50,12,30, fornecedor.getById((long) 3)));
        
        
        //(Perfumaria)Infantil->Colonia
        produtos.add(new ProdutoEntity((long) 6, "Kit de colonias para meninas","Cinderela, Bela e Branca de Neve. 15ml cada.","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 11), 50,12,30, fornecedor.getById((long) 3)));
        produtos.add(new ProdutoEntity((long) 7, "Colonia Baby sem Álcool","Calming, 100 ml cada.","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 9), 50,12,30, fornecedor.getById((long) 3)));
        produtos.add(new ProdutoEntity((long) 8, "Kit de colonias para meninas","Spider Man, 100 ml cada.","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 10), 50,12,30, fornecedor.getById((long) 3)));
        
        //(Perfumaria)Feminina->Fragrancias
        produtos.add(new ProdutoEntity((long) 9, "Coffe Woman Seduction Des. Colônia","100 ml","Boticário", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 12), 50,12,30, fornecedor.getById((long) 3)));
        //(Perfumaria)Feminina->Locao Perfumada
        produtos.add(new ProdutoEntity((long) 10, "Loção Perfumada para o corpo Instinct for Women","200ml","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 13), 50,12,30, fornecedor.getById((long) 3)));
        
        /*Olhos*/
        //(Maquiagem)Olhos->Sombra
        produtos.add(new ProdutoEntity((long) 11, "Sombra Make B ","2.8 g","Boticário", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 17), 50,12,30, fornecedor.getById((long) 3)));
        //(Maquiagem)Olhos->Delineador
        produtos.add(new ProdutoEntity((long) 12, "Color Trend Delineador Colorido para Olhos","3ml","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 18), 50,12,30, fornecedor.getById((long) 3)));
        //(Maquiagem)Olhos->Mascara
        produtos.add(new ProdutoEntity((long) 13, "Big & Impact Máscara Extra Volume à prova d`àgua","10g","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 19), 50,12,30, fornecedor.getById((long) 3)));
        //(Maquiagem)Olhos->Lapis para olhos
        produtos.add(new ProdutoEntity((long) 14, "MAKE B. LÁPIS RETRÁTIL PARA OLHOS À PROVA D'ÁGUA PRETO"," 1un","Boticário", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 20), 50,12,30, fornecedor.getById((long) 3)));
        //(Maquiagem)Olhos->Lapis para sombrancelha
        produtos.add(new ProdutoEntity((long) 15, "MAKE B. CANETA PARA SOBRANCELHA"," 1un","Boticário", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 21), 50,12,30, fornecedor.getById((long) 3)));
        //(Maquiagem)Olhos->Demaquilantes
        produtos.add(new ProdutoEntity((long) 16, "INTENSE DEMAQUILANTE CREMOSO"," 150ml","Boticário", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 22), 50,12,30, fornecedor.getById((long) 3)));
        //(Maquiagem)Olhos->Pó Compacto
        produtos.add(new ProdutoEntity((long) 17, "Avon Luxe Pó Compacto Facial Aveludado"," 10g","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 23), 50,12,30, fornecedor.getById((long) 3)));
        
        /*Labios*/
        //(Maquiagem)Labios->Batom
        produtos.add(new ProdutoEntity((long) 18, "Batom Color Trend","3.6 g","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 24), 50,12,30, fornecedor.getById((long) 3)));
        //(Maquiagem)Labios->Brilho Labial
        produtos.add(new ProdutoEntity((long) 19, "Moranguinho","10 g","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 25), 50,12,30, fornecedor.getById((long) 3)));
        //(Maquiagem)Labios->Condicionador Labial
        produtos.add(new ProdutoEntity((long) 20, "Condicionador Labial com Retinol FPS 15","3.6 g","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 26), 50,12,30, fornecedor.getById((long) 3)));
        //(Maquiagem)Labios->Contorno
        produtos.add(new ProdutoEntity((long) 21, "Ultra Color Delineador Retrátil para Lábios","0.25 g","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 27), 50,12,30, fornecedor.getById((long) 3)));
        
        //(Maquiagem)->Esmalte
        produtos.add(new ProdutoEntity((long) 22, "Esmalte Brilho e Longa Duração","8 ml","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 16), 50,12,30, fornecedor.getById((long) 3)));
        
        /*Rosto*/
        //(Rosto)->Esfoliante e Máscara
        produtos.add(new ProdutoEntity((long) 23, "MAKE B. PEELING DE CRISTAL NUTRIESFOLIANTE","60g","Boticário", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 28), 50,12,30, fornecedor.getById((long) 3)));
        //(Rosto)Rosto->Hidratante e Creme
        produtos.add(new ProdutoEntity((long) 24, "CUIDE-SE BEM CREME HIDRATANTE PARA PELE NORMAL A SECA FPS 15","50 g","Boticário", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 29), 50,12,30, fornecedor.getById((long) 3)));
        //(Rosto)Rosto->Limpeza de pele
        produtos.add(new ProdutoEntity((long) 25, "MAKE B. MOUSSE DE LIMPEZA TONIFICANTE 2 EM 1","150 ml","Boticário", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 30), 50,12,30, fornecedor.getById((long) 3)));
        //(Rosto)Rosto->Pré-barba
        produtos.add(new ProdutoEntity((long) 26, "MALBEC ESPUMA DE BARBEAR","200 ml","Boticário", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 31), 50,12,30, fornecedor.getById((long) 3)));
        //(Rosto)Rosto->Pós-barba
        produtos.add(new ProdutoEntity((long) 27, "MALBEC BALM APÓS BARBA","150 g","Boticário", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 32), 50,12,30, fornecedor.getById((long) 3)));
        
        /*Corpo e Banho*/
        //(Corpo e Banho)->Desodorantes Feminino
        produtos.add(new ProdutoEntity((long) 28, "MYRIAD DESODORANTE ANTITRANSPIRANTE AEROSOL","75g","Boticário", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 33), 50,12,30, fornecedor.getById((long) 3)));
        //(Corpo e Banho)->Sabonetes Feminino
        produtos.add(new ProdutoEntity((long) 29, "CUIDE-SE BEM SABONETE PERFUMADO ROSA E ALCAÇUS, 5 UNIDADES DE 80G"," 1un","Boticário", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 34), 50,12,30, fornecedor.getById((long) 3)));
        //(Corpo e Banho)->Desodorantes masculino
        produtos.add(new ProdutoEntity((long) 30, "EGEO MAN DESODORANTE ANTITRANSPIRANTE AEROSOL","75g","Boticário", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 35), 50,12,30, fornecedor.getById((long) 3)));
        //(Corpo e Banho)->Sabonetes Masculino
        produtos.add(new ProdutoEntity((long) 31, "MEN SABONETES PERFUMADOS, 2 UNIDADES DE 90G CADA","1un","Boticário", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 36), 50,12,30, fornecedor.getById((long) 3)));
        //(Corpo e Banho)->Linha Solar
        produtos.add(new ProdutoEntity((long) 32, "CUIDE-SE BEM PROTETOR SOLAR FACIAL FPS30","50 g","Boticário", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 37), 50,12,30, fornecedor.getById((long) 3)));
        //(Corpo e Banho)->Óleos
        produtos.add(new ProdutoEntity((long) 33, "EGEO DOLCE ÓLEO PERFUMADO DES. CORPORAL","150 ml","Boticário", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 38), 50,12,30, fornecedor.getById((long) 3)));
        //(Corpo e Banho)->Hidratantes
        produtos.add(new ProdutoEntity((long) 34, "CUIDE-SE BEM LOÇÃO HIDRATANTE CORPORAL ROSA E ALCAÇUZ"," 400 ml ","Boticário", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 39), 50,12,30, fornecedor.getById((long) 3)));
        
        /*Cabelos*/
        //(Cabelos)->Gel Fixador
        produtos.add(new ProdutoEntity((long) 35, "SPULÓKIS FIXADOR EM GEL PARA CABELOS","90g","Boticário", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 33), 50,12,30, fornecedor.getById((long) 3)));
        //(Cabelos)->Shampoo Masculino
        produtos.add(new ProdutoEntity((long) 36, "MALBEC NOIR SHOWER GEL CABELO E CORPO"," 205g","Boticário", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 34), 50,12,30, fornecedor.getById((long) 3)));
        //(Cabelos)->Shampoo Feminino
        produtos.add(new ProdutoEntity((long) 37, "CAPRICHO SHAMPOO ANTIFRIZZ ","200 ml","Boticário", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 35), 50,12,30, fornecedor.getById((long) 3)));
        //(Cabelos)->Condicionador
        produtos.add(new ProdutoEntity((long) 38, "Condicionador Hidratação Intensiva e Brilho","250 ml","Avon", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 36), 50,12,30, fornecedor.getById((long) 3)));
        //(Cabelos)->Creme sem enxague
        produtos.add(new ProdutoEntity((long) 39, "NATIVA SPA CREME SEM ENXÁGUE EXÓTICO RESTAURAÇÃO DOS FIOS AMEIXA","150 g","Boticário", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 37), 50,12,30, fornecedor.getById((long) 3)));
        //(Cabelos)->Finalizador
        produtos.add(new ProdutoEntity((long) 40, "CUIDE-SE BEM ATIVADOR DE CACHOS","100 ml","Boticário", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 38), 50,12,30, fornecedor.getById((long) 3)));
        //(Cabelos)->Tratamento Capilar
        produtos.add(new ProdutoEntity((long) 41, "NATIVA SPA ÓLEO TRATAMENTO CAPILAR NUTRIÇÃO DOS FIOS TERAPIA DOS ÓLEOS INDIANOS"," 110 ml ","Boticário", (float) 10.0, (float) 5.0, (float) 2.0, (float) 4.0, (float) 8.0, cat.getById((long) 39), 50,12,30, fornecedor.getById((long) 3)));
        
        
        

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
