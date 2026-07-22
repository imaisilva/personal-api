package com.project.personal.api.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.project.personal.api.entities.Client;
import com.project.personal.api.entities.Workout;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ClientWorkoutPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "workout_id")
	private Workout workout;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Workout getWorkout() {
		return workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
	}

	@Override
	public int hashCode() {
		return Objects.hash(client, workout);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientWorkoutPK other = (ClientWorkoutPK) obj;
		return Objects.equals(client, other.client) && Objects.equals(workout, other.workout);
	}
}
