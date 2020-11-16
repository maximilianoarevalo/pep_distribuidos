package distribuidos.pep.repositories;

import java.util.ArrayList;

import distribuidos.pep.models.Pass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PassRepository extends JpaRepository<Pass, Long> {
    ArrayList<Pass> findAll();
}