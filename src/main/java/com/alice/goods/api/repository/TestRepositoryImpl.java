package com.alice.goods.api.repository;


import com.alice.goods.api.dto.TestDto;
//import com.alice.goods.api.entity.QMember;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author Alice
 *
 */



@Repository
public class TestRepositoryImpl extends QuerydslRepositorySupport implements TestRepository{

    @PersistenceContext
    private EntityManager em;

    public TestRepositoryImpl() {
        super(TestDto.class);
    }



    public TestDto selectGetUserInfo(Integer uid){
        JPAQueryFactory query = new JPAQueryFactory(em);
       /* QMember member = QMember.member;

        TestDto test =
                query.from(member)
                .select(Projections.constructor(TestDto.class,member.uid, member.name, member.nickname, member.phone, member.sex))
                .where(member.uid.eq(uid))
                .fetchOne();

        return test;*/
        return null;
    }


}


