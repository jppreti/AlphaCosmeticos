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
        
        TreeItem maquiagem = new TreeItem(categorias.getByNome("Maquiagem").getNome());
        maquiagem.getChildren().addAll(getMaquiagem());
        
        categoriaLista.add(maquiagem);
        categoriaLista.add(perfumaria);
        
        return categoriaLista;
    }
    
    //Nivel 1
    private ArrayList<TreeItem> getPerfumaria() {
        
        ArrayList<TreeItem> perfumariaLista = new ArrayList<>();
        
        TreeItem masculino = new TreeItem(categorias.getByNome("Masculino").getNome());
        masculino.getChildren().addAll(getMasculino());
        
        TreeItem intanfil = new TreeItem(categorias.getByNome("Infantil").getNome());
        intanfil.getChildren().addAll(getInfantil());
        
        TreeItem feminina = new TreeItem(categorias.getByNome("Feminina").getNome());
        feminina.getChildren().addAll(getFeminina());
        
        perfumariaLista.add(masculino);
        perfumariaLista.add(intanfil);
        perfumariaLista.add(feminina);
        
        return perfumariaLista;
    }
    
    //Nivel 2
    private ArrayList<TreeItem> getMasculino() {
        
        ArrayList<TreeItem> masculinoLista = new ArrayList<>();
        
        TreeItem fragrancias = new TreeItem(categorias.getByNome("Fragrancias").getNome());
        TreeItem barbear = new TreeItem (categorias.getByNome("Barbear").getNome());
        
        masculinoLista.add(fragrancias);
        masculinoLista.add(barbear);
        
        return masculinoLista;
    }
    
    //Nivel 2
    private ArrayList<TreeItem> getInfantil() {
    
        ArrayList<TreeItem> intantilLista = new ArrayList<>();
        
        TreeItem colonia = new TreeItem(categorias.getByNome("Colonia").getNome());
        
        intantilLista.add(colonia);
        
        return intantilLista;
    }
    
    //Nivel 2
    private ArrayList<TreeItem> getFeminina() {
        
        ArrayList<TreeItem> femininaLista = new ArrayList<>();
        
        TreeItem fragrancias = new TreeItem(categorias.getByNome("Fragrancias").getNome());
        TreeItem locaoPerfumada = new TreeItem(categorias.getByNome("Locao Perfumada").getNome());
        
        femininaLista.add(fragrancias);
        femininaLista.add(locaoPerfumada);
        
        return femininaLista;
    }
    
    //Nivel 1
    private ArrayList<TreeItem> getMaquiagem() {
    
        ArrayList<TreeItem> maquiagemLista = new ArrayList<>();
        
        TreeItem olhos = new TreeItem(categorias.getByNome("Olhos").getNome());
        olhos.getChildren().addAll(getOlhos());
        
        TreeItem labios = new TreeItem(categorias.getByNome("Labios").getNome());
        labios.getChildren().addAll(getLabios());
        
        TreeItem rosto = new TreeItem(categorias.getByNome("Rosto").getNome());
        rosto.getChildren().addAll(getRosto());
        
        TreeItem unhas = new TreeItem(categorias.getByNome("Unhas").getNome());
        unhas.getChildren().addAll(getUnhas());
        
        TreeItem acessorios = new TreeItem(categorias.getByNome("Acessorios").getNome());
        acessorios.getChildren().addAll(getAcessorios());
        
        maquiagemLista.add(olhos);
        maquiagemLista.add(labios);
        maquiagemLista.add(rosto);
        maquiagemLista.add(unhas);
        maquiagemLista.add(acessorios);
        
        return maquiagemLista;
    }
    
    //Nivel 2
    private ArrayList<TreeItem> getOlhos() {
    
        ArrayList<TreeItem> olhosLista = new ArrayList<>();
        
        TreeItem sombra = new TreeItem(categorias.getByNome("Sombra").getNome());
        TreeItem delineador = new TreeItem(categorias.getByNome("Delineador").getNome());
        TreeItem mascara = new TreeItem(categorias.getByNome("Mascara").getNome());
        TreeItem outros = new TreeItem(categorias.getByNome("Outros").getNome());

        
        olhosLista.add(sombra);
        olhosLista.add(delineador);
        olhosLista.add(mascara);
        olhosLista.add(outros);
        
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
        
        TreeItem base = new TreeItem(categorias.getByNome("Base").getNome());
        TreeItem blush = new TreeItem(categorias.getByNome("Blush").getNome());
        TreeItem corretivo = new TreeItem(categorias.getByNome("Corretivo").getNome());
        TreeItem outros = new TreeItem(categorias.getByNome("Outros").getNome());
        TreeItem poCompacto = new TreeItem(categorias.getByNome("Po Compacto").getNome());

        
        rostoLista.add(base);
        rostoLista.add(blush);
        rostoLista.add(corretivo);
        rostoLista.add(outros);
        rostoLista.add(poCompacto);
        return rostoLista;
    }
    
    //Nivel 2
    private ArrayList<TreeItem> getUnhas() {
        
        ArrayList<TreeItem> unhasLista = new ArrayList<>();
        
        TreeItem esmalte = new TreeItem(categorias.getByNome("Esmalte").getNome());
        TreeItem tratamento = new TreeItem(categorias.getByNome("Tratamento").getNome());
        
        unhasLista.add(esmalte);
        unhasLista.add(tratamento);
        
        return unhasLista;    
    }
    
    //Nivel 1
    private ArrayList<TreeItem> getAcessorios() {
        
        ArrayList<TreeItem> acessoriosLista = new ArrayList<>();
        
        TreeItem acessorios = new TreeItem(); //Unico
        
        acessoriosLista.add(acessorios);
        
        return acessoriosLista;
    }
}
