package com.application.simpleAdvisingSystem.repositories;

import com.application.simpleAdvisingSystem.models.slotRegisteredStudents;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface slotRegisteredStudentRepository extends JpaRepository<slotRegisteredStudents, String> {


    public slotRegisteredStudents findByEmail(String email);


    // eikhane slot_registered_user theke findall diye data niye return kore dibo.



}
