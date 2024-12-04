package com.axpe.prueba.service;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axpe.prueba.exception.PricesException;
import com.axpe.prueba.model.Prices;
import com.axpe.prueba.model.dto.PricesDto;
import com.axpe.prueba.repository.PricesRepository;

@Service
public class PricesService {

	@Autowired
	private PricesRepository repository;

	public PricesDto getPrice(String dateS, Long product_id, Long brand_id) throws PricesException, ParseException {
		Long maxPriority = repository.getMaxPriority(parseDate(dateS), product_id, brand_id);
		List<Prices> prices = repository.findByProductANDbrandANDdateBetween(parseDate(dateS), product_id, brand_id, maxPriority);
		if(prices.size() < 1) {
			return null;
		} else if (prices.size() > 1) {
			throw new PricesException(MessageFormat.format("Datos inconsistentes: el producto {0} en la fecha {1} tiene dos o mas tarifas a aplicar con la maxima prioridad", product_id, dateS));
		} else {
			return new PricesDto(prices.get(0).getProductId(), prices.get(0).getBrandId(), prices.get(0).getPriceList(), prices.get(0).getPrice(), prices.get(0).getStartDate(), prices.get(0).getEndDate());
		}
	}

	private Date parseDate(String dateS) throws ParseException {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
			return formatter.parse(dateS);
		} catch (ParseException e) {
			throw e;
		}
	}
}
