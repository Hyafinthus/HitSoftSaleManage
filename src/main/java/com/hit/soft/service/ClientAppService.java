package com.hit.soft.service;

import java.util.List;

import com.hit.soft.domain.Client;
import com.hit.soft.domain.OrderProduct;

public interface ClientAppService {

	void saveMoney(Client client);

	Client searchClient(int clientId);

	boolean payOrder(OrderProduct orderProduct);

	void pointsForCash(int clientId);

	List<Client> searchPointsForCash();

}
