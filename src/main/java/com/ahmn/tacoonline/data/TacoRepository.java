package com.ahmn.tacoonline.data;

import com.ahmn.tacoonline.model.Taco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TacoRepository extends PagingAndSortingRepository<Taco,Long> {
}
