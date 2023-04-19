package br.com.fiap.progamer.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class ProfileBean {
	
	private String name;
	private String email;
	private String profile;
	private String password;

	public void save() {
		// Aqui você pode implementar a lógica para salvar os dados do usuário.
		// Por exemplo, você pode utilizar um DAO para persistir o objeto criado a partir dos dados do formulário.
		
		// Exemplo de validação simples: os campos "name", "email" e "password" são obrigatórios
		if (name == null || name.isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "O campo Nome é obrigatório.", ""));
			return;
		}
		if (email == null || email.isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "O campo Email é obrigatório.", ""));
			return;
		}
		if (password == null || password.isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "O campo Senha é obrigatório.", ""));
			return;
		}
		
		// Exemplo de mensagem de sucesso
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Dados salvos com sucesso!", ""));
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getProfile() {
		return profile;
	}
	
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

}
