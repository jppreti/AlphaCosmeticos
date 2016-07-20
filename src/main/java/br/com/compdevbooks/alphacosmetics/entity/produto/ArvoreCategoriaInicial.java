package br.com.compdevbooks.alphacosmetics.entity.produto;

import java.util.ArrayList;
import javafx.scene.control.TreeItem;

//Todos os dados fixo para montar as categorias
public class ArvoreCategoriaInicial {

    public ArvoreCategoriaInicial() {
    }

    //Raiz
    public ArrayList<TreeItem<String>> getCategoria() {
        
        ArrayList<TreeItem<String>> categoriaLista = new ArrayList<>();
        
        TreeItem perfumaria = new TreeItem("Perfumaria");
        perfumaria.getChildren().addAll(getPerfumaria());
        
        TreeItem maquiagem = new TreeItem("Maquiagem");
        maquiagem.getChildren().addAll(getMaquiagem());
        
        categoriaLista.add(maquiagem);
        categoriaLista.add(perfumaria);
        
        return categoriaLista;
    }
    
    //Nivel 1
    private ArrayList<TreeItem<String>> getPerfumaria() {
        
        ArrayList<TreeItem<String>> perfumariaLista = new ArrayList<>();
        
        TreeItem masculino = new TreeItem("Masculino");
        masculino.getChildren().addAll(getMasculino());
        
        TreeItem intanfil = new TreeItem("Infantil");
        intanfil.getChildren().addAll(getInfantil());
        
        TreeItem feminina = new TreeItem("Feminina");
        feminina.getChildren().addAll(getFeminina());
        
        perfumariaLista.add(masculino);
        perfumariaLista.add(intanfil);
        perfumariaLista.add(feminina);
        
        return perfumariaLista;
    }
    
    //Nivel 2
    private ArrayList<TreeItem<String>> getMasculino() {
        
        ArrayList<TreeItem<String>> masculinoLista = new ArrayList<>();
        
        TreeItem fragrancias = new TreeItem("Fragrancias");
        TreeItem barbear = new TreeItem ("Barbear");
        
        masculinoLista.add(fragrancias);
        masculinoLista.add(barbear);
        
        return masculinoLista;
    }
    
    //Nivel 2
    private ArrayList<TreeItem<String>> getInfantil() {
    
        ArrayList<TreeItem<String>> intantilLista = new ArrayList<>();
        
        TreeItem colonia = new TreeItem("Colonia");
        
        intantilLista.add(colonia);
        
        return intantilLista;
    }
    
    //Nivel 2
    private ArrayList<TreeItem<String>> getFeminina() {
        
        ArrayList<TreeItem<String>> femininaLista = new ArrayList<>();
        
        TreeItem fragrancias = new TreeItem("Fragrancias");
        TreeItem locaoPerfumada = new TreeItem("Locao Perfumada");
        
        femininaLista.add(fragrancias);
        femininaLista.add(locaoPerfumada);
        
        return femininaLista;
    }
    
    //Nivel 1
    private ArrayList<TreeItem<String>> getMaquiagem() {
    
        ArrayList<TreeItem<String>> maquiagemLista = new ArrayList<>();
        
        TreeItem olhos = new TreeItem("Olhos");
        olhos.getChildren().addAll(getOlhos());
        
        TreeItem labios = new TreeItem("Labios");
        labios.getChildren().addAll(getLabios());
        
        TreeItem rosto = new TreeItem("Rosto");
        rosto.getChildren().addAll(getRosto());
        
        TreeItem unhas = new TreeItem("Unhas");
        unhas.getChildren().addAll(getUnhas());
        
        TreeItem acessorios = new TreeItem("Acessorios");
        acessorios.getChildren().addAll(getAcessorios());
        
        maquiagemLista.add(olhos);
        maquiagemLista.add(labios);
        maquiagemLista.add(rosto);
        maquiagemLista.add(unhas);
        maquiagemLista.add(acessorios);
        
        return maquiagemLista;
    }
    
    //Nivel 2
    private ArrayList<TreeItem<String>> getOlhos() {
    
        ArrayList<TreeItem<String>> olhosLista = new ArrayList<>();
        
        TreeItem sombra = new TreeItem("Sombra");
        TreeItem delineador = new TreeItem("Delineador");
        TreeItem mascara = new TreeItem("Mascara");
        TreeItem outros = new TreeItem("Outros");

        
        olhosLista.add(sombra);
        olhosLista.add(delineador);
        olhosLista.add(mascara);
        olhosLista.add(outros);
        
        return olhosLista;
    }
    
    //Nivel 2
    private ArrayList<TreeItem<String>> getLabios() {
    
        ArrayList<TreeItem<String>> labiosLista = new ArrayList<>();
        
        TreeItem batom = new TreeItem("Batom");
        TreeItem brilhoLabial = new TreeItem("Brilho Labial");
        TreeItem condicionadorLabial = new TreeItem("Condicionador Labial");
        TreeItem contorno = new TreeItem("Contorno");

        
        labiosLista.add(batom);
        labiosLista.add(brilhoLabial);
        labiosLista.add(condicionadorLabial);
        labiosLista.add(contorno);
        
        return labiosLista;
    }
    
    //Nivel 2
    private ArrayList<TreeItem<String>> getRosto() {
    
        ArrayList<TreeItem<String>> rostoLista = new ArrayList<>();
        
        TreeItem base = new TreeItem("Base");
        TreeItem blush = new TreeItem("Blush");
        TreeItem corretivo = new TreeItem("Corretivo");
        TreeItem outros = new TreeItem("Outros");
        TreeItem poCompacto = new TreeItem("Po Compacto");

        
        rostoLista.add(base);
        rostoLista.add(blush);
        rostoLista.add(corretivo);
        rostoLista.add(outros);
        rostoLista.add(poCompacto);
        return rostoLista;
    }
    
    //Nivel 2
    private ArrayList<TreeItem<String>> getUnhas() {
        
        ArrayList<TreeItem<String>> unhasLista = new ArrayList<>();
        
        TreeItem esmalte = new TreeItem("Esmalte");
        TreeItem tratamento = new TreeItem("Tratamento");
        
        unhasLista.add(esmalte);
        unhasLista.add(tratamento);
        
        return unhasLista;    
    }
    
    //Nivel 1
    private ArrayList<TreeItem<String>> getAcessorios() {
        
        ArrayList<TreeItem<String>> acessoriosLista = new ArrayList<>();
        
        TreeItem acessorios = new TreeItem(); //Unico
        
        acessoriosLista.add(acessorios);
        
        return acessoriosLista;
    }
}
