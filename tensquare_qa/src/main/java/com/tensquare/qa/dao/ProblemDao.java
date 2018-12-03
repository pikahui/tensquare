package com.tensquare.qa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{
	@Query(value = "select * from tb_problem a INNER JOIN tb_pl b ON a.id=b.problemid" +
            " where b.labelid=? ORDER BY replytime DESC ",nativeQuery = true)
    public Page<Problem> newList(String labelid,Pageable pageable);
    @Query(value = "select * from tb_problem a INNER JOIN tb_pl b ON a.id=b.problemid" +
            " where b.labelid=? ORDER BY reply DESC ",nativeQuery = true)
	public Page<Problem> hotList(String labelid,Pageable pageable);
    @Query(value = "select * from tb_problem a INNER JOIN tb_pl b ON a.id=b.problemid" +
            "where b.labelid='1' AND reply=0 ORDER BY createtime DESC",nativeQuery = true)
	public Page<Problem> waitlist(String labelid,Pageable pageable);
}
