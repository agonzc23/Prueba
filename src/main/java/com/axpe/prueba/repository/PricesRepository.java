package com.axpe.prueba.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.axpe.prueba.model.Prices;

public interface PricesRepository extends CrudRepository<Prices, Long> {

	@Query("select p from Prices p where p.startDate <= :date AND p.endDate >= :date AND p.productId = :product AND brandId = :brand AND priority = :maxPriority")
	List<Prices> findByProductANDbrandANDdateBetween(Date date, Long product, Long brand, Long maxPriority);

	@Query("select max(p.priority) from Prices p where p.startDate <= :date AND p.endDate >= :date AND p.productId = :product AND brandId = :brand")
	Long getMaxPriority(Date date, Long product, Long brand);
}
