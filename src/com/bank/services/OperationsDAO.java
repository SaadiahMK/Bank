package com.bank.services;

import java.util.List;
import java.util.Optional;

public interface OperationsDAO<T> {
	
	public boolean save(T t);
	
	public boolean update(T t);
	
	public boolean delete(T t);
	
    public  List<T> getAll();  
    
    public Optional<T> getRecord(long userId);
    
    
	

}
