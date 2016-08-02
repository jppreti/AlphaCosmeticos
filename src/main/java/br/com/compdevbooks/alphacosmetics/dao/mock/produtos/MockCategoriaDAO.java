package br.com.compdevbooks.alphacosmetics.dao.mock.produtos;

import br.com.compdevbooks.alphacosmetics.dao.ICategoriaDAO;
import br.com.compdevbooks.alphacosmetics.entity.produto.CategoriaEntity;
import java.util.ArrayList;
import java.util.List;

public class MockCategoriaDAO implements ICategoriaDAO {
    private static List<CategoriaEntity> categorias= new ArrayList();
    static {
        categorias.add(new CategoriaEntity((long) 1 ,"Perfumaria",null));
        categorias.add(new CategoriaEntity((long) 2,"Maquiagem e Esmalte", null));
        categorias.add(new CategoriaEntity((long) 3,"Cabelos", null));
        categorias.add(new CategoriaEntity((long) 4,"Corpo e Banho", null));
        categorias.add(new CategoriaEntity((long) 5,"Rosto", null));
        
        
        
        
        //Categoria Perfumaria nivel 1
        //Nivel do vetor 0
        categorias.add(new CategoriaEntity((long) 6 ,"Homens",categorias.get(0)));
        categorias.add(new CategoriaEntity((long) 7 ,"Infantil",categorias.get(0)));
        categorias.add(new CategoriaEntity((long) 8 ,"Mulheres",categorias.get(0)));
        
        //Categoria Infantil nivel 2
        //nivel do vetor 3
        categorias.add(new CategoriaEntity((long) 9 ,"Bebês",categorias.get(6)));
        categorias.add(new CategoriaEntity((long) 10 ,"Meninos",categorias.get(6)));
        categorias.add(new CategoriaEntity((long) 11 ,"Meninas",categorias.get(6)));
        //Categoria Feminina nivel 2
        //nivel do vetor 4
        categorias.add(new CategoriaEntity((long) 12 ,"Perfume",categorias.get(7)));
        categorias.add(new CategoriaEntity((long) 13 ,"Loção Perfumada",categorias.get(7)));
        
        
        //Categoria Maquiagem nivel 1
        //Nivel do vetor 1
        categorias.add(new CategoriaEntity((long) 14 ,"Olhos",categorias.get(1)));
        categorias.add(new CategoriaEntity((long) 15 ,"Labios",categorias.get(1)));
        categorias.add(new CategoriaEntity((long) 16 ,"Esmaltes",categorias.get(1)));
        
        
        //Categoria Olhos nivel 2
        //Nivel do vetor 10
        categorias.add(new CategoriaEntity((long) 17 ,"Sombra",categorias.get(13)));
        categorias.add(new CategoriaEntity((long) 18 ,"Delineador",categorias.get(13)));
        categorias.add(new CategoriaEntity((long) 19 ,"Mascara",categorias.get(13)));
        categorias.add(new CategoriaEntity((long) 20 ,"Lapis para olhos",categorias.get(13)));
        categorias.add(new CategoriaEntity((long) 21 ,"Lapis para sombrancelhas",categorias.get(13)));
        categorias.add(new CategoriaEntity((long) 22 ,"Demaquilantes",categorias.get(13)));
        categorias.add(new CategoriaEntity((long) 23 ,"Pó Compacto",categorias.get(13)));
        
        //Categoria Labios Nivel 1
        //Nivel do vetor 11
        categorias.add(new CategoriaEntity((long) 24 ,"Batom",categorias.get(14)));
        categorias.add(new CategoriaEntity((long) 25 ,"Brilho Labial",categorias.get(14)));
        categorias.add(new CategoriaEntity((long) 26 ,"Condicionador Labial",categorias.get(14)));
        categorias.add(new CategoriaEntity((long) 27 ,"Contorno",categorias.get(14)));
        
        //Categoria Rosto Nivel 2
        //Nivel do vetor 12
        categorias.add(new CategoriaEntity((long) 28 ,"Esfoliante e Máscara",categorias.get(4)));
        categorias.add(new CategoriaEntity((long) 29 ,"Hidratante e Creme",categorias.get(4)));
        categorias.add(new CategoriaEntity((long) 30 ,"Limpeza de pele",categorias.get(4)));
        categorias.add(new CategoriaEntity((long) 31 ,"Pré-barba",categorias.get(4)));
        categorias.add(new CategoriaEntity((long) 32 ,"Pós-barba",categorias.get(4)));
                
        //Categoria cabelos Nivel 2
        //Nivel do vetor 13
        categorias.add(new CategoriaEntity((long) 33 ,"Gel Fixador",categorias.get(2)));
        categorias.add(new CategoriaEntity((long) 34 ,"Shampoo Masculino",categorias.get(2)));
        categorias.add(new CategoriaEntity((long) 35 ,"Shampoo Feminino",categorias.get(2)));
        categorias.add(new CategoriaEntity((long) 36 ,"Condicionador",categorias.get(2)));
        categorias.add(new CategoriaEntity((long) 37 ,"Creme sem enxague",categorias.get(2)));
        categorias.add(new CategoriaEntity((long) 38 ,"Finalizador",categorias.get(2)));
        categorias.add(new CategoriaEntity((long) 39 ,"Tratamento Capilar",categorias.get(2)));
        
        //Categoria Corpo e banho Nivel 2
        //Nivel do vetor 3
        categorias.add(new CategoriaEntity((long) 41 ,"Desodorantes Feminino",categorias.get(3)));
        categorias.add(new CategoriaEntity((long) 42 ,"Sabonetes Feminino",categorias.get(3)));
        categorias.add(new CategoriaEntity((long) 43 ,"Desodorantes Masculino",categorias.get(3)));
        categorias.add(new CategoriaEntity((long) 44 ,"Sabonetes Masculino",categorias.get(3)));
        categorias.add(new CategoriaEntity((long) 45 ,"Linha Solar",categorias.get(3)));
        categorias.add(new CategoriaEntity((long) 46 ,"Óleos",categorias.get(3)));
        categorias.add(new CategoriaEntity((long) 47 ,"Hidratantes",categorias.get(3)));
    }
            
    public MockCategoriaDAO(){  }
    
    private static MockCategoriaDAO singleton;
    
    public static MockCategoriaDAO getInstace(){
        if(singleton==null)
            singleton=new MockCategoriaDAO();
        return singleton;
    }
    
    @Override
    public void save(CategoriaEntity entity) {
        if(categorias.indexOf(entity)<0)
            categorias.add(entity);
    }

    @Override
    public void delete(CategoriaEntity entity) {
       categorias.remove(entity);
    }

    @Override
    public CategoriaEntity getById(Long id) {
       for(CategoriaEntity vo: categorias)
           if(vo.getId().equals(id))
               return vo;
       return null;
    }
    
    public CategoriaEntity getByNome(String nome){
        for (CategoriaEntity vo: categorias){
            if (vo.getNome().toUpperCase().contains(nome.toUpperCase())){
                return vo;
            }
        }
        return null;
    }
    
    public List<CategoriaEntity> buscarTodasCategorias() {
        return categorias;
    }

}