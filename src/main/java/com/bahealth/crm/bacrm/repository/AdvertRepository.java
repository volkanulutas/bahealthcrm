package com.bahealth.crm.bacrm.repository;

import com.bahealth.crm.bacrm.data.entity.Agency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertRepository extends JpaRepository<Agency, Long> {}