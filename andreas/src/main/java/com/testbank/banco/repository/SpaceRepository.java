package com.testbank.banco.repository;

import com.testbank.banco.model.Space;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpaceRepository extends JpaRepository<Space, Long> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Space s SET s.enabled = false WHERE s.id =:id")
    void disableSpace(@Param("id") Long id);
}
