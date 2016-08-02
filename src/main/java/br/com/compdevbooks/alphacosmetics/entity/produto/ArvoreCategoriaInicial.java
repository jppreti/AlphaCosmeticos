package br.com.compdevbooks.alphacosmetics.entity.produto;

import br.com.compdevbooks.alphacosmetics.dao.mock.produtos.MockCategoriaDAO;
import java.util.ArrayList;
import javafx.scene.control.TreeItem;

//Todos os dados fixo para montar as categorias
public class ArvoreCategoriaInicial {
    
    private static MockCategoriaDAO categorias = new MockCategoriaDAO();
    
    public ArvoreCategoriaInicial() {
    }

    //Raiz
    public ArrayList<TreeItem> getCategoria() {
        ArrayList<TreeItem> categoriaLista = new ArrayList<>();
        
        TreeItem perfumaria = new TreeItem(categorias.getByNome("Perfumaria").getNome());
        perfumaria.getChildren().addAll(getPerfumaria());
        
        TreeItem maquiagem = new TreeItem(categorias.getByNome("Maquiagem e Esmalte").getNome());
        maquiagem.getChildren().addAll(getMaquiagem());
        
        TreeItem cabelos = new TreeItem(categorias.getByNome("Cabelos").getNome());
        cabelos.getChildren().addAll(getCabelos());
        
        TreeItem corpo = new TreeItem(categorias.getByNome("Corpo e Banho").getNome());
        corpo.getChildren().addAll(getCorpoBanho());
        
        TreeItem rosto = new TreeItem(categorias.getByNome("Rosto").getNome());
        rosto.getChildren().addAll(getRosto());
        
        categoriaLista.add(maquiagem);
        categoriaLista.add(perfumaria);
        categoriaLista.add(cabelos);
        categoriaLista.add(corpo);
        categoriaLista.add(rosto);
        
        return categoriaLista;
    }
    
    //Nivel 1
    private ArrayList<TreeItem> getPerfumaria() {
        
        ArrayList<TreeItem> perfumariaLista = new ArrayList<>();
        
        TreeItem homens = new TreeItem(categorias.getByNome("Homens").getNome());
        
        
        TreeItem intanfil = new TreeItem(categorias.getByNome("Infantil").getNome());
        intanfil.getChildren().addAll(getInfantil());
        
        TreeItem mulheres = new TreeItem(categorias.getByNome("Mulheres").getNome());
        mulheres.getChildren().addAll(getMulheres());
        
        perfumariaLista.add(homens);
        perfumariaLista.add(intanfil);
        perfumariaLista.add(mulheres);
        
        return perfumariaLista;
    }
    
   
    
    
    //Nivel 2
    private ArrayList<TreeItem> getInfantil() {
    
        ArrayList<TreeItem> infantilLista = new ArrayList<>();
        
        TreeItem bebe = new TreeItem(categorias.getByNome("Bebês").getNome());
        TreeItem menino = new TreeItem(categorias.getByNome("Meninos").getNome());
        TreeItem menina = new TreeItem(categorias.getByNome("Meninas").getNome());
        
        infantilLista.add(bebe);
        infantilLista.add(menino);
        infantilLista.add(menina);
        
        return infantilLista;
    }
    
    //Nivel 2
    private ArrayList<TreeItem> getMulheres() {
        
        ArrayList<TreeItem> mulheresLista = new ArrayList<>();
        
        TreeItem fragrancias = new TreeItem(categorias.getByNome("Perfume").getNome());
        TreeItem locaoPerfumada = new TreeItem(categorias.getByNome("Loção Perfumada").getNome());
        
        mulheresLista.add(fragrancias);
        mulheresLista.add(locaoPerfumada);
        
        return mulheresLista;
    }
    
    //Nivel 1
    private ArrayList<TreeItem> getMaquiagem() {
    
        ArrayList<TreeItem> maquiagemLista = new ArrayList<>();
        
        TreeItem olhos = new TreeItem(categorias.getByNome("Olhos").getNome());
        olhos.getChildren().addAll(getOlhos());
        
        TreeItem labios = new TreeItem(categorias.getByNome("Labios").getNome());
        labios.getChildren().addAll(getLabios());
        
        TreeItem esmaltes = new TreeItem(categorias.getByNome("Esmaltes").getNome());
        
        
                
        maquiagemLista.add(olhos);
        maquiagemLista.add(labios);
        maquiagemLista.add(esmaltes);
        
        
        
        return maquiagemLista;
    }
    
    //Nivel 2
    private ArrayList<TreeItem> getOlhos() {
    
        ArrayList<TreeItem> olhosLista = new ArrayList<>();
        
        TreeItem sombra = new TreeItem(categorias.getByNome("Sombra").getNome());
        TreeItem delineador = new TreeItem(categorias.getByNome("Delineador").getNome());
        TreeItem mascara = new TreeItem(categorias.getByNome("Mascara").getNome());
        TreeItem lapisOlhos = new TreeItem(categorias.getByNome("Lapis para olhos").getNome());
        TreeItem lapisSombra = new TreeItem(categorias.getByNome("Lapis para sombrancelhas").getNome());
        TreeItem demaquilante = new TreeItem(categorias.getByNome("Demaquilantes").getNome());
        TreeItem poCompacto = new TreeItem(categorias.getByNome("Pó Compacto").getNome());
        

        
        olhosLista.add(sombra);
        olhosLista.add(delineador);
        olhosLista.add(mascara);
        olhosLista.add(lapisOlhos);
        olhosLista.add(lapisSombra);
        olhosLista.add(demaquilante);
        olhosLista.add(poCompacto);
        
        
        return olhosLista;
    }
    
    //Nivel 2
    private ArrayList<TreeItem> getLabios() {
    
        ArrayList<TreeItem> labiosLista = new ArrayList<>();
        
        TreeItem batom = new TreeItem(categorias.getByNome("Batom").getNome());
        TreeItem brilhoLabial = new TreeItem(categorias.getByNome("Brilho Labial").getNome());
        TreeItem condicionadorLabial = new TreeItem(categorias.getByNome("Condicionador Labial").getNome());
        TreeItem contorno = new TreeItem(categorias.getByNome("Contorno").getNome());

        
        labiosLista.add(batom);
        labiosLista.add(brilhoLabial);
        labiosLista.add(condicionadorLabial);
        labiosLista.add(contorno);
        
        return labiosLista;
    }
    
    //Nivel 2
    private ArrayList<TreeItem> getRosto() {
    
        ArrayList<TreeItem> rostoLista = new ArrayList<>();
        
        TreeItem base = new TreeItem(categorias.getByNome("Esfoliante e Máscara").getNome());
        TreeItem blush = new TreeItem(categorias.getByNome("Hidratante e Creme").getNome());
        TreeItem corretivo = new TreeItem(categorias.getByNome("Limpeza de pele").getNome());
        
        TreeItem preBarba = new TreeItem(categorias.getByNome("Pré-barba").getNome());
        TreeItem posBarba = new TreeItem(categorias.getByNome("Pós-barba").getNome());

        
        rostoLista.add(base);
        rostoLista.add(blush);
        rostoLista.add(corretivo);
        rostoLista.add(preBarba);
        rostoLista.add(posBarba);
        return rostoLista;
    }
    
    //Nivel 2
    private ArrayList<TreeItem> getCabelos() {
        
        ArrayList<TreeItem> cabeloLista = new ArrayList<>();
        
        TreeItem gel = new TreeItem(categorias.getByNome("Gel Fixador").getNome());
        TreeItem shampooM = new TreeItem(categorias.getByNome("Shampoo Masculino").getNome());
        TreeItem shampooF = new TreeItem(categorias.getByNome("Shampoo Feminino").getNome());
        TreeItem condicionador = new TreeItem(categorias.getByNome("Condicionador").getNome());
        TreeItem creme = new TreeItem(categorias.getByNome("Creme sem enxague").getNome());
        TreeItem finalizador = new TreeItem(categorias.getByNome("Finalizador").getNome());
        TreeItem tratamento = new TreeItem(categorias.getByNome("Tratamento Capilar").getNome());
        
        cabeloLista.add(gel);
        cabeloLista.add(tratamento);
        cabeloLista.add(condicionador);
        cabeloLista.add(creme);
        cabeloLista.add(finalizador);
        cabeloLista.add(shampooM);
        cabeloLista.add(shampooF);
        
        return cabeloLista;    
    }
    
    private ArrayList<TreeItem> getCorpoBanho() {
        
        ArrayList<TreeItem> corpoBanhoLista = new ArrayList<>();
        
        TreeItem desodoranteF = new TreeItem(categorias.getByNome("Desodorantes Feminino").getNome());
        TreeItem sabonteF = new TreeItem(categorias.getByNome("Sabonetes Feminino").getNome());
        TreeItem sabonteM = new TreeItem(categorias.getByNome("Desodorantes Masculino").getNome());
        TreeItem desodoranteM = new TreeItem(categorias.getByNome("Sabonetes Masculino").getNome());
        TreeItem linhaSolar = new TreeItem(categorias.getByNome("Linha Solar").getNome());
        TreeItem oleos = new TreeItem(categorias.getByNome("Óleos").getNome());
        TreeItem hidratante = new TreeItem(categorias.getByNome("Hidratantes").getNome());
        
        corpoBanhoLista.add(desodoranteF);
        corpoBanhoLista.add(sabonteF);
        corpoBanhoLista.add(sabonteM);
        corpoBanhoLista.add(desodoranteM);
        corpoBanhoLista.add(linhaSolar);
        corpoBanhoLista.add(oleos);
        corpoBanhoLista.add(hidratante);
        
        return corpoBanhoLista;
    }
    
    
    
    
}
