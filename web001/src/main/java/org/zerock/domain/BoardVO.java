package org.zerock.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardVO {
	private long no;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updatedate;
}
