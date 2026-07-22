package com.project.personal.api.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.project.personal.api.entities.enums.WorkoutLevel;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Workout implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String description;
	
	@Enumerated(EnumType.STRING)
	private WorkoutLevel level;
	
	@ManyToOne
	@JoinColumn(name = "personal_id")
	private Personal personal;
	
	@OneToMany(mappedBy = "id.workout")
    private List<ClientWorkout> clientWorkouts = new ArrayList<>();

	public Workout () {
	}

	public Workout(Long id, String name, String description, WorkoutLevel level, Personal personal) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.level = level;
		this.personal = personal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public WorkoutLevel getLevel() {
		return level;
	}

	public void setLevel(WorkoutLevel level) {
		this.level = level;
	}

	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}
	
	public List<ClientWorkout> getClientWorkouts() {
		return clientWorkouts;
	}
	
	public void addClientWorkout(ClientWorkout clientWorkout) {
	    clientWorkouts.add(clientWorkout);
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
		Workout other = (Workout) obj;
		return Objects.equals(id, other.id);
	}
}
