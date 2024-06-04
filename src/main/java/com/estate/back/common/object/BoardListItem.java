package com.estate.back.common.object;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import com.estate.back.common.util.ChangeDateFormatUtil;
import com.estate.back.entity.BoardEntity;

import lombok.Getter;

@Getter
public class BoardListItem {
    private Integer receptionNumber;
    private Boolean status;
    private String title;
    private String writerId;
    private String writeDatetime;
    private Integer viewCount;

    private BoardListItem(BoardEntity boardEntity) throws Exception {
        
        //* this.writeDatetime = `writeDatetime`; 작업
        String writeDatetime = ChangeDateFormatUtil.changeYYMMDD(boardEntity.getWriteDatetime());

        //* this.writerId = `writerId`; 작업
        String writerId = boardEntity.getWriterId();
        writerId = 
            writerId.substring(0, 1) +  
            "*".repeat(writerId.length() -1);
            // writerId 에서 1번째 글자만 뽑고, 나머지는 *로 작업

        this.receptionNumber = boardEntity.getReceptionNumber();
        this.status = boardEntity.getStatus();
        this.title = boardEntity.getTitle();
        this.writerId = writerId;
        this.writeDatetime = writeDatetime;
        this.viewCount = boardEntity.getViewCount();
    }

    //* List<BoardEntity> -> List<BoardListItem> 하는 작업
    public static List<BoardListItem> getList(List<BoardEntity> boardEntities) throws Exception {
        List<BoardListItem> boardList = new ArrayList<>();
        // 빈 배열 만들기

        // 꺼내오기
        for (BoardEntity boardEntity: boardEntities) {
            // 만들기 (35~40 번 라인) : 다른 것은 전부 복사하고, (this.writerId / this.writeDatetime) 는 따로
            BoardListItem boardListItem = new BoardListItem(boardEntity);
            boardList.add(boardListItem);
        }
        return boardList;
    }
}
