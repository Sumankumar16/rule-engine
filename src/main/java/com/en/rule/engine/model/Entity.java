package com.en.rule.engine.model;

import java.io.Serializable;

/**
 * <P>
 * This is the generic class to be extanded for all the models.
 * </P>
 * @author Suman Kumar
 */

public abstract class Entity<T extends Serializable> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	protected T id;
	
	public T getId() {
		return id;
	}
	public void setId(T id) {
		this.id = id;
	}
	
	public Entity(T id) {
		super();
		this.id = id;
	}
	
	public Entity() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity other = (Entity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}