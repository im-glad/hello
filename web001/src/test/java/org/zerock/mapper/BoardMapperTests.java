package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새글");
		board.setContent("새글");
		board.setWriter("new");
		
		mapper.insert(board);
		
		log.info(board);
	}
	@Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("새글 select key");
		board.setContent("새글 select key");
		board.setWriter("new");
		
		mapper.insertSelectKey(board);
		
		log.info(board);
	}
	@Test
	public void testRead() {
		BoardVO board = mapper.read(5L);
		
		log.info(board);
	}
	@Test
	public void testDelete() {
		log.info("delete count:"+mapper.delete(3L));
	}
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setNo(5L);
		board.setTitle("수정");
		board.setContent("수정");
		board.setWriter("user2");
		
		
		log.info("update count:"+mapper.update(board));
	}
	
}
