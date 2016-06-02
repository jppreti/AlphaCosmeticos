package br.com.compdevbooks.alphacosmetics.dao;

public interface IDAO<VO> {

	void save(VO vo);
	void delete(VO vo);
	VO getById(Long id);
	
}
