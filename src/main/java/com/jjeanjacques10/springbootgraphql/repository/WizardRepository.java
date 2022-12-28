package com.jjeanjacques10.springbootgraphql.repository;

import com.jjeanjacques10.springbootgraphql.entity.Wizard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WizardRepository extends JpaRepository<Wizard, Long> {
}
