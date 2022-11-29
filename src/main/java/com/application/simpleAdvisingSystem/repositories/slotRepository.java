package com.application.simpleAdvisingSystem.repositories;

import com.application.simpleAdvisingSystem.models.slot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface slotRepository extends JpaRepository<slot, String> {


    slot findBySlotID(String id);
}
