package br.com.compdevbooks.alphacosmetics.entity.produto;

import java.util.ArrayList;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class ArvoreCategoria {

    private TreeView treeCategoria;
    private int cont;
    
    public ArvoreCategoria(){       }
            
    public ArvoreCategoria(TreeView treeCategoria, TreeItem root) {
        //Formacao da arvore estatica de categorias
        ArvoreCategoriaInicial arvoreInicial = new ArvoreCategoriaInicial();
        ArrayList<TreeItem> categoriaLista = arvoreInicial.getCategoria();
                
        //Apontamento do da raiz e criacao da arvore apartir da raiz
//        root = new TreeItem<>();
        
        root.getChildren().addAll(categoriaLista);
        treeCategoria.setShowRoot(false); //ocultar raiz
        treeCategoria.setRoot(root);
        this.treeCategoria = treeCategoria;
    }

    public TreeView<String> getTreeCategoria() {
        return treeCategoria;
    }

    public void setTreeCategoria(TreeView<String> treeCategoria) {
        this.treeCategoria = treeCategoria;
    }    
    
    public void carregarTreeView() {
        //Raiz
        TreeItem<String> root;
        //Filho nivel 1,    nivel 2
        TreeItem<String> perfumaria, masculino, infantil, feminina;
        //Filho nivel 1,    nivel 2
        TreeItem<String> maquiagem, olhos, labios, rosto, unhas, acessorios;

        root = new TreeItem<>(); //Criacao do item da arvore "Categoria"
        root.setExpanded(true); //Permite ter itens filhos (Expandir)

        //Perfumaria (nivel 1)
        perfumaria = criarRamo("Perfumaria", root); //nivel 1

        masculino = criarRamo("Masculino", perfumaria); //nivel 2
        criarRamo("Fragrancias", masculino);//folha
        criarRamo("Barbear", masculino);//folha

        infantil = criarRamo("Infantil", perfumaria);//nivel 2
        criarRamo("Colonia", infantil);//folha

        feminina = criarRamo("Feminina", perfumaria);//nivel 2
        criarRamo("Fragr�ncias", feminina);//folha
        criarRamo("Locao Perfumada", feminina);//folha
        //fim Perfumaria

        //Maquiagem
        maquiagem = criarRamo("Maquiagem", root);//nivel 1

        olhos = criarRamo("Olhos", maquiagem);//nivel 2
        criarRamo("Sombra", olhos);//folha
        criarRamo("Delineador", olhos);//folha
        criarRamo("Mascara", olhos);//folha
        criarRamo("Outros", olhos);//folha

        labios = criarRamo("Labios", maquiagem);//nivel 2
        criarRamo("Batom", labios);//folha
        criarRamo("Brilho Labial", labios);//folha
        criarRamo("Condicionador Labial", labios);//folha
        criarRamo("Contorno", labios);//folha

        rosto = criarRamo("Rosto", maquiagem);//nivel 2
        criarRamo("Base", rosto);//folha
        criarRamo("Blush", rosto);//folha
        criarRamo("Corretivo", rosto);//folha
        criarRamo("Outros", rosto);//folha
        criarRamo("Po Compacto", rosto);//folha

        unhas = criarRamo("Unhas", maquiagem);//nivel 2
        criarRamo("Esmalte", unhas);//folha
        criarRamo("Tratamento", unhas);//folha

        acessorios = criarRamo("Acessorios", maquiagem);//nivel 2
        criarRamo(null, acessorios);//so para aparecer a flexa
        //fim Maquiagem

        /* O mesmo que o metodo treeCategoria_onMouseClicked
        //Selecao dos itens na arvore
        treeCategoria.getSelectionModel().selectedItemProperty()
                .addListener((v, oldValue, newValue) -> {
                    if(newValue != null){
                        //Captura da categoria selecionada
                        categoriaSelecionada = newValue.getValue();
                        System.out.println(categoriaSelecionada);
                    }    
                });
         */
        //Associar os itens de uma arvore com a estrutura da arvore
        getTreeCategoria().setShowRoot(false);//true: Raiz vista, false: Raiz escondida
        getTreeCategoria().setRoot(root);
    }

    //Cria os ramos da para a arvore (filhos)
    public final TreeItem<String> criarRamo(String nome, TreeItem<String> pai) {
        /*if(cont != 3){
            TreeItem<String> item = new TreeItem<>(nome);
            item.setExpanded(true);
            pai.getChildren().add(item);
            cont++;
            System.out.println(" "+ cont);
            return item;
        }else {
            CheckBoxTreeItem<String> item = new CheckBoxTreeItem<>(nome);
//            treeCategoria.setEditable(true);
//            treeCategoria.setCellFactory(CheckBoxTreeCell.forTreeView());
            pai.getChildren().add(item);
            cont=0;
            System.out.println(" "+ cont);
//            treeCategoria.setEditable(false);
            return item;
        }*/

        TreeItem<String> item = new TreeItem<>(nome);
        item.setExpanded(true);
        pai.getChildren().add(item);
        return item;
    }
}
