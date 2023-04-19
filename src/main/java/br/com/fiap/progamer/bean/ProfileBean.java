package br.com.fiap.progamer.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.progamer.dao.ProfileDao;
import br.com.fiap.progamer.model.ProfileModel;

@ManagedBean
@RequestScoped
public class ProfileBean {

	private ProfileModel profileModel = new ProfileModel();

	public ProfileModel getProfileModel() {
		return profileModel;
	}

	public void setProfileModel(ProfileModel profileModel) {
		this.profileModel = profileModel;
	}

	public void save() {
		
		try {
			ProfileDao dao = new ProfileDao();
			dao.create(profileModel);

			// Exemplo de mensagem de sucesso
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Dados salvos com sucesso!", ""));
		} catch (Exception e) {
			// Exemplo de mensagem de erro
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar dados!", ""));
			e.printStackTrace();
		}
	}

	public String getName() {
		return profileModel.getName();
	}

	public String getEmail() {
		return profileModel.getEmail();
	}

	public String getProfile() {
		return profileModel.getProfile();
	}

	public String getPassword() {
		return profileModel.getPassword();
	}
}

