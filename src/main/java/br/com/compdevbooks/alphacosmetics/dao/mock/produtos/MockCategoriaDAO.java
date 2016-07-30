package br.com.compdevbooks.alphacosmetics.dao.mock.produtos;

import br.com.compdevbooks.alphacosmetics.dao.ICategoriaDAO;
import br.com.compdevbooks.alphacosmetics.entity.produto.CategoriaEntity;
import java.util.ArrayList;
import java.util.List;

public class MockCategoriaDAO implements ICategoriaDAO {
    private static List<CategoriaEntity> categorias= new ArrayList();
    static {
        categorias.add(new CategoriaEntity((long) 1 ,"Perfumaria",null));
        categorias.add(new CategoriaEntity((long) 2,"Maquiagem", null));
        
        //Categoria Perfumaria nivel 1
        //Nivel do vetor 0
        categorias.add(new CategoriaEntity((long) 3 ,"Masculino",categorias.get(0)));
        categorias.add(new CategoriaEntity((long) 4 ,"Infantil",categorias.get(0)));
        categorias.add(new CategoriaEntity((long) 5 ,"Feminina",categorias.get(0)));
        
        //Categoria Masculino nivel 2
        //nivel do vetor 2
        categorias.add(new CategoriaEntity((long) 6 ,"Fragrancias",categorias.get(2)));
        categorias.add(new CategoriaEntity((long) 7 ,"Barbear",categorias.get(2)));
        //Categoria Infantil nivel 2
        //nivel do vetor 3
        categorias.add(new CategoriaEntity((long) 8 ,"Colonia",categorias.get(3)));
        //Categoria Feminina nivel 2
        //nivel do vetor 4
        categorias.add(new CategoriaEntity((long) 9 ,"Fragrancias",categorias.get(4)));
        categorias.add(new CategoriaEntity((long) 10 ,"Locao Perfumada",categorias.get(4)));
        
        
        //Categoria Maquiagem nivel 1
        //Nivel do vetor 1
        categorias.add(new CategoriaEntity((long) 11 ,"Olhos",categorias.get(1)));
        categorias.add(new CategoriaEntity((long) 12 ,"Labios",categorias.get(1)));
        categorias.add(new CategoriaEntity((long) 13 ,"Rosto",categorias.get(1)));
        categorias.add(new CategoriaEntity((long) 14 ,"Unhas",categorias.get(1)));
        categorias.add(new CategoriaEntity((long) 15 ,"Acessorios",categorias.get(1)));
        
        //Categoria Olhos nivel 2
        //Nivel do vetor 10
        categorias.add(new CategoriaEntity((long) 16 ,"Sombra",categorias.get(10)));
        categorias.add(new CategoriaEntity((long) 17 ,"Delineador",categorias.get(10)));
        categorias.add(new CategoriaEntity((long) 18 ,"Mascara",categorias.get(10)));
        categorias.add(new CategoriaEntity((long) 19 ,"Outros",categorias.get(10)));
        
        //Categoria Labios Nivel 2
        //Nivel do vetor 11
        categorias.add(new CategoriaEntity((long) 20 ,"Batom",categorias.get(11)));
        categorias.add(new CategoriaEntity((long) 21 ,"Brilho Labial",categorias.get(11)));
        categorias.add(new CategoriaEntity((long) 22 ,"Condicionador Labial",categorias.get(11)));
        categorias.add(new CategoriaEntity((long) 23 ,"Contorno",categorias.get(11)));
        
        //Categoria Rosto Nivel 2
        //Nivel do vetor 12
        categorias.add(new CategoriaEntity((long) 24 ,"Base",categorias.get(12)));
        categorias.add(new CategoriaEntity((long) 25 ,"Blush",categorias.get(12)));
        categorias.add(new CategoriaEntity((long) 26 ,"Corretivo",categorias.get(12)));
        categorias.add(new CategoriaEntity((long) 27 ,"Outros",categorias.get(12)));
        categorias.add(new CategoriaEntity((long) 28 ,"Po Compacto",categorias.get(12)));
        
        //Categoria Unhas Nivel 2
        //Nivel do vetor 13
        categorias.add(new CategoriaEntity((long) 29 ,"Esmalte",categorias.get(13)));
        categorias.add(new CategoriaEntity((long) 30 ,"Tratamento",categorias.get(13)));
        
        //Categoria Unhas Nivel 2
        //Nivel do vetor 13
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
