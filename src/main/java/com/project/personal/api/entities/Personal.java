package com.project.personal.api.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Personal implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	private String name;
	private String specialty;
	private String profilePhoto;
	private String biography;
	
	@OneToMany(mappedBy = "personal")
	private List<Client> clients = new ArrayList<>();
	
	@OneToMany(mappedBy = "personal")
	private List<Workout> workouts = new ArrayList<>();
	
	public Personal() {
	}

	public Personal(Long id, User user, String name, String specialty, String profilePhoto, String biography) {
		this.id = id;
		this.user = user;
		this.name = name;
		this.specialty = specialty;
		this.profilePhoto = profilePhoto;
		this.biography = biography;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}
	
	public List<Client> getClients() {
		return clients;
	}
	
	public void addClient(Client client) {
		if(!clients.contains(client)) {
			clients.add(client);
			client.setPersonal(this);
		}		
	}
	
	public void removeClient(Client client) {
		if(clients.remove(client)) {
			client.setPersonal(null);
		}		
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personal other = (Personal) obj;
		return Objects.equals(id, other.id);
	}
}
