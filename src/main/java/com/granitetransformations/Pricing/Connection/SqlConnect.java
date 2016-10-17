package com.granitetransformations.Pricing.Connection;

import com.granitetransformations.Pricing.Model.CountertopDetails;
import com.granitetransformations.Pricing.Model.CustomerDetails;

import javafx.collections.ObservableList;

public interface SqlConnect {
	//Find customer data
	public long insertCustomer(CustomerDetails customer);
	public boolean updateCustomer(CustomerDetails customer);
	public boolean deleteCustomer(CustomerDetails customer);
	public ObservableList<CustomerDetails> findCustomerById(CustomerSearchType customerSearchType, Object value);
	
	//Find countertop data
	public boolean updateCountertop(CountertopDetails countertop);
	public long insertCountertop(CountertopDetails countertop);
	public boolean deleteCountertop(CountertopDetails countertop);
	public ObservableList<CountertopDetails> findCountertopByOrderId(SearchType searchType, Object value);
	
	//
}
