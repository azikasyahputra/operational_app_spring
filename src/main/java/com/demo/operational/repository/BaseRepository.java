package com.demo.operational.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID>,FilterRepository<T> {
    @Query("SELECT t FROM #{#entityName} t WHERE t.deleted = :deleted")
    Page<T> findAllByDeleted(String deleted, Pageable pageable, List<String> fields);

//    @Query("SELECT t FROM #{#entityName} t WHERE t.deleted = 'Tidak' " +
//            "AND (:filters IS NULL OR " +
//            "(KEY(:filters) IN :whereFields AND VALUE(:filters) = t))")
//    @Query("SELECT t FROM #{#entityName} t WHERE t.deleted = :deleted")
//    Page<T> search(@Param("filters") Map<String, Object> filters, Pageable pageable,
//                   @Param("fields") List<String> selectableFields,
//                   @Param("whereFields") List<String> whereFields);
}
