package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;


import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;


@Log4j
@Service
@ToString
public class BoardServiceImpl implements BoardService{
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {
		log.info("register...."+board);
		
		mapper.insertSelectKey(board);
		
	}

	@Override
	public BoardVO get(Long no) {
		log.info("get......"+no);
		
		return mapper.read(no);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify......"+board);
		
		return mapper.update(board) ==1;
	}

	@Override
	public boolean remove(Long no) {
		log.info("remove......"+no);
		
		return mapper.delete(no)==1;
	}

	@Override
	public List<BoardVO> getList() {
		log.info("getList.......");
		
		return mapper.getList();
	}
	
}
