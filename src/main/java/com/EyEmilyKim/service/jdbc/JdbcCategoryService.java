package com.EyEmilyKim.service.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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
		System.out.println("CateService > getList() called");
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
		System.out.println("CateService > getCount() called");
		String sql = "select count(*) from MAB_CATEGORIES"
				+ " where 1=1 "
				+ " and ID in (\'"+id+"\', \'system\')"
				;
		int cnt = template.queryForObject(sql, Integer.class);
		return cnt;
	}

	@Override
	public Integer getSeqno() {
		System.out.println("CateService > getSeqno() called");
		String sql = "select max(SEQNO) from MAB_CATEGORIES"
				;
		int seqno = template.queryForObject(sql, Integer.class);
		return seqno;
	}

	@Override
	public int insert(Category c) {
		System.out.println("CateService > insert() called");
		String sql = "insert into MAB_CATEGORIES values(?,?,?,?,?)";
		try {
			int flag = template.update(sql, c.getSeqno(),c.getInex(),c.getCate_name(),c.getCate_code(),c.getId());
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(Category c) {
		System.out.println("CateService > upd() called");
		String sql = "update MAB_CATEGORIES"
				+ " set CATE_NAME = ?"
				+ " where 1=1 "
				+ " and CATE_CODE = ?"
				;
		try {
			int flag = template.update(sql, c.getCate_name(), c.getCate_code());
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(String cate_code) {
		System.out.println("CateService > del() called");
		String sql = "delete from MAB_CATEGORIES"
				+ " where 1=1 "
				+ " and CATE_CODE = \'"+cate_code+"\'"
				;
		try {
			int flag = template.queryForObject(sql, Integer.class);
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Category select(String cate_code) {
		String sql = "select * from MAB_CATEGORIES"
				+ " where 1=1 "
				+ " and CATE_CODE = \'"+cate_code+"\'"
				;
		Category cate = template.queryForObject(sql, new BeanPropertyRowMapper<Category>(Category.class));
		return cate;
	}

}
