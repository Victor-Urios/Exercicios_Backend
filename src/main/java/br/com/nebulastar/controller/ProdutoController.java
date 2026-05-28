/**
 * 
 */
package br.com.nebulastar.controller;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.nebulastar.domain.Produto;
import br.com.nebulastar.service.IProdutoService;



/**
 * @author Nebula Stardust
 * Feito na aula e usado no exercicio!
 */
@Named
@ViewScoped
public class ProdutoController implements Serializable {

	private static final long serialVersionUID = 8030245985235567808L;
	
	private Produto produto;
	
	private Collection<Produto> produtos;
	
	@Inject
	private IProdutoService produtoService;
	
	private Boolean isUpdate;
	
	@PostConstruct
	public void init() {
		try {
			this.isUpdate = false;
			this.produto = new Produto();
			this.produtos = produtoService.buscarTodos();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao listar produtos"));
		}
	}
	
	// cancelar
	public void cancel() {
		try {
			this.isUpdate = false;
			this.produto = new Produto();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar cancelar ação"));
		}
		
    } 
	
	//editar o produto dentro do banco
	public void edit(Produto cliente) {
		try {
			this.isUpdate = true;
			this.produto = cliente;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o produto"));
		}
		
    } 
	
	// deletar o produto!
	public void delete(Produto cliente) {
		try {
			produtoService.excluir(cliente);
			produtos.remove(cliente);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o produto"));
		}
		
    } 
	
	//adicionar o produto!
	public void add() {
		try {
			produtoService.cadastrar(produto);
			this.produtos = produtoService.buscarTodos();
			this.produto = new Produto();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar criar o produto"));
		}
		   
    }
	
	//atualizar cliente! ( tem que ter se for editar! )
	public void update() {
    	try {
    		produtoService.alterar(this.produto);
			cancel();
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Produto Atualiado com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar atualizar o produto"));
		} 
    }

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Collection<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Collection<Produto> produtos) {
		this.produtos = produtos;
	}

	public Boolean getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
	
	
	
	
}
