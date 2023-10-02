package ojs.blog.ojs_back.repository;

import ojs.blog.ojs_back.domain.UserMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public interface UserMasterRepository extends JpaRepository<UserMaster,String>, JpaSpecificationExecutor<UserMaster> {
}
