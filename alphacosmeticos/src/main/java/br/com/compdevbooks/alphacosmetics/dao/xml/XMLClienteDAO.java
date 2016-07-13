package br.com.compdevbooks.alphacosmetics.dao.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import br.com.compdevbooks.alphacosmetics.dao.DAOFactory;
import br.com.compdevbooks.alphacosmetics.dao.DAOFactoryEnum;
import br.com.compdevbooks.alphacosmetics.dao.IClienteDAO;
import br.com.compdevbooks.alphacosmetics.entity.pessoa.ClienteEntity;
import br.com.compdevbooks.alphacosmetics.gui.javafx.controller.FrmPrincipal;

public class XMLClienteDAO implements IClienteDAO {

	//private File xml = new File("gui/xml/entity/ClienteEntity.xml");
	private File xml = new File(XMLClienteDAO.class.getClassLoader().getResource("xml/entity/ClienteEntity.xml").getFile());
	
	Document doc;

	private static XMLClienteDAO singleton = null;

	private XMLClienteDAO() {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(xml);

			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static XMLClienteDAO getInstance() {
		if (singleton == null)
			singleton = new XMLClienteDAO();

		return singleton;
	}

	@Override
	public void save(ClienteEntity entity) {
		if (entity.getId()==null || entity.getId()<0) {
			
		} else {
			NodeList nList = doc.getElementsByTagName("ent:ClienteEntity");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					/*if (eElement.getAttribute("id").equals(entity.getId())) {
						eElement.getElementsByTagName("dev:nome").item(0).getChildNodes().item(0).setNodeValue(entity.getNome());
						eElement.getElementsByTagName("dev:email").item(0).getChildNodes().item(0).setNodeValue(entity.getEmail());
						eElement.getElementsByTagName("dev:telefone").item(0).getChildNodes().item(0).setNodeValue(entity.getTelefone());
					}*/
				}
			}			
		}
	}

	@Override
	public void delete(ClienteEntity entity) {

	}

	@Override
	public ClienteEntity getById(Long id) {
		NodeList nList = doc.getElementsByTagName("ent:ClienteEntity");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
                                /*
				if (eElement.getAttribute("id").equals(id.toString())) {
					ClienteEntity c = new ClienteEntity();
					c.setId(Long.parseLong(eElement.getAttribute("id")));
					c.setNome((eElement.getElementsByTagName("dev:nome").item(0).getChildNodes().item(0).getNodeValue()));
					c.setEmail(eElement.getElementsByTagName("dev:email").item(0).getChildNodes().item(0).getNodeValue());
					c.setTelefone(eElement.getElementsByTagName("dev:telefone").item(0).getChildNodes().item(0).getNodeValue());
					return c;
				}*/
			}
		}

		return null;
	}

	@Override
	public List<ClienteEntity> getByNome(String nome) {
		ArrayList<ClienteEntity> resultado = new ArrayList<>();

		NodeList nList = doc.getElementsByTagName("ent:ClienteEntity");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				/*if ((eElement.getElementsByTagName("dev:nome").item(0).getChildNodes().item(0).getNodeValue()).toUpperCase().indexOf(nome.toUpperCase()) >= 0) {
					ClienteEntity c = new ClienteEntity();
					c.setId(Long.parseLong(eElement.getAttribute("id")));
					c.setNome((eElement.getElementsByTagName("dev:nome").item(0).getChildNodes().item(0).getNodeValue()));
					c.setEmail(eElement.getElementsByTagName("dev:email").item(0).getChildNodes().item(0).getNodeValue());
					c.setTelefone(eElement.getElementsByTagName("dev:telefone").item(0).getChildNodes().item(0).getNodeValue());
					resultado.add(c);
				}*/
			}
		}

		return resultado;
	}

	public static void main(String[] args) {
		//System.out.println(XMLClienteDAO.class.getClassLoader().getResource("xml/entity/ClienteEntity.xml").getFile());
		System.out.println(DAOFactory.getDAOFactory().getClienteDAO().getById(2L).getNome());
	}
}
