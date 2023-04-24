package com.EyEmilyKim.service;

import java.util.List;

import com.EyEmilyKim.entity.Category;

public interface CategoryService {
	
	List<Category> getList(String id); //해당회원의 전체 카테고리 검색
	int getCount(String id);//해당회원의 전체 카테고리 건수 조회
	Integer getSeqno(); //카테고리 테이블의 최신 일련번호 검색
	int insert(Category c); //카테고리 삽입
	int update(Category c); //cate_code로 카테고리 수정
	int delete(String cate_code); //cate_code로 카테고리 삭제
	Category select(String cate_code); //cate_code로 카테고리 검색

}
