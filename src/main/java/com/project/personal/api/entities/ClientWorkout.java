package com.project.personal.api.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.project.personal.api.entities.enums.ClientWorkoutStatus;
import com.project.personal.api.entities.pk.ClientWorkoutPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class ClientWorkout implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
    private ClientWorkoutPK id = new ClientWorkoutPK();
	
	private LocalDate startDate;
	private LocalDate endDate;
	
	@Enumerated(EnumType.STRING)
    private ClientWorkoutStatus status;
	
	public ClientWorkout() {
	}

	public ClientWorkout(Client client, Workout workout , LocalDate startDate, LocalDate endDate, ClientWorkoutStatus status) {
		super();
		id.setClient(client);
		id.setWorkout(workout);
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}
	
	public Client getClient() {
		return id.getClient();
	}
	
	public void setClient(Client client) {
		id.setClient(client);
	}
	
	public Workout getWorkout() {
		return id.getWorkout();
	}
	
	public void setWorkout(Workout workout) {
		id.setWorkout(workout);
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public ClientWorkoutStatus getStatus() {
		return status;
	}

	public void setStatus(ClientWorkoutStatus status) {
		this.status = status;
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
		ClientWorkout other = (ClientWorkout) obj;
		return Objects.equals(id, other.id);
	}
}
