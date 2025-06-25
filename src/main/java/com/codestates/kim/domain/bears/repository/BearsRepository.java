package com.codestates.kim.domain.bears.repository;

import com.codestates.kim.domain.bears.Bears;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BearsRepository extends JpaRepository<Bears, Integer> {

}
