package com.training.ifaces;

import java.sql.SQLException;
import java.util.*;

public interface GenericDAO<T> {

	  public int add(T t) throws SQLException;
	  public T find(long key) throws SQLException;
	  public List<T> findAll() throws SQLException;
	  public int remove(long key) throws SQLException;
	  
	  
}
