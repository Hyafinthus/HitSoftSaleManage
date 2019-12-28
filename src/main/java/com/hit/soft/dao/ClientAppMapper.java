package com.hit.soft.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hit.soft.domain.Client;

@Mapper
public interface ClientAppMapper {

	void saveMoney(Client client);

	Client searchClient(int clientId);

	void payment(Client client);

	List<Client> searchPointsForCash();

}
