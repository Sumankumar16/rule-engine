package com.en.rule.engine.dao;
@FunctionalInterface
public interface IdGenerator<T> {

	T generate();
	
}