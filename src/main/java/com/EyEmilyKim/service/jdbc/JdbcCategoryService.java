package com.EyEmilyKim.service.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.EyEmilyKim.entity.Category;
import com.EyEmilyKim.service.CategoryService;

@Service
public class JdbcCategoryService implements CategoryService {

	/*
	 * @Autowired
	 * private DataSource dataSource;
	 */
	
	@Autowired
	private JdbcTemplate template;
	
	@Override
	public List<Category> getList(String id) {
		String sql = "select * from MAB_CATEGORIES"
				+ " where 1=1 "
				+ " and ID in (\'"+id+"\', \'system\')"
				+ " order by CATE_CODE"
//				+ " and RN between ? and ?"
				;
				/*
				 * --DataSource 물린 JdbcTemplate 자체를 Bean 지정하면서 생략가능해진 코드
				 * JdbcTemplate template = new JdbcTemplate();
				 * template.setDataSource(dataSource);
				 */
		List<Category> list = template.query(sql, new BeanPropertyRowMapper(Category.class));
		return list;
	}

	@Override
	public int getCount(String id) {
		String sql = "select count(*) from MAB_CATEGORIES"
				+ " where 1=1 "
				+ " and ID in (\'"+id+"\', \'system\')"
				;
		int cnt = template.queryForObject(sql, Integer.class);
		return cnt;
	}

	@Override
	public Integer getSeqno() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Category c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Category c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String cate_code) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Category select(String cate_code) {
		// TODO Auto-generated method stub
		return null;
	}

}
