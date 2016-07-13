
package br.com.compdevbooks.alphacosmetics.dao;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.VendedorEntity;
import java.util.List;

public interface IVendedorDAO extends IDAO<VendedorEntity>{
    List<VendedorEntity> getByNome(String nome);
}
