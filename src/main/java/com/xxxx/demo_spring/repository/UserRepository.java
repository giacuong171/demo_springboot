package com.xxxx.demo_spring.repository;

import com.xxxx.demo_spring.entity.user.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//Annotation
//@RepositoryDefinition(domainClass = UserEntity.class, idClass = Long.class)
public interface UserRepository extends JpaRepository<UserEntity,Long>, JpaSpecificationExecutor<UserEntity> {
    //pageable
    Page<UserEntity> findByUserName(String username, Pageable pageable);

    UserEntity findByUserNameAndUserEmail(String userName, String userEmail);

    List<UserEntity> findByUserNameStartingWith(String userEmail);

    /**
     * Where id <1
     */
    List<UserEntity> findByIdLessThan(Long id);

    // RAW JPQL

//    @Query("SELECT u FROM UserEntity u WHERE u.id = (select MAX(p.id))")
//    UserEntity findMaxIdUser();

    @Query("SELECT u FROM UserEntity u WHERE u.userName = ?1 AND u.userEmail= ?2")
    List<UserEntity> getUserByUserName(String userName,String userEmail);

    @Query("SELECT u FROM UserEntity u WHERE u.userName = :userName AND u.userEmail= :userEmail")
    List<UserEntity> getUserEntityByTwo(@Param("userName") String userName,@Param("userEmail") String userEmail);

    /**
     * UPDATE DELETE
     */
    @Modifying
    @Query("UPDATE UserEntity u SET u.userEmail = :userName")
    @Transactional
    int updateUserName(@Param("userName") String userName);

    // native query
    /**
     * get count user
     */
    @Query(value = "SELECT COUNT(id) FROM java_user_001", nativeQuery = true)
    long getTotalUser();
}
