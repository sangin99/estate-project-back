package com.estate.back.service;

import org.springframework.http.ResponseEntity;

import com.estate.back.dto.request.board.PostBoardRequestDto;
import com.estate.back.dto.request.board.PostCommentRequestDto;
import com.estate.back.dto.request.board.PutBoardRequestDto;
import com.estate.back.dto.response.ResponseDto;
import com.estate.back.dto.response.board.GetBoardListResponseDto;
import com.estate.back.dto.response.board.GetBoardResponseDto;
import com.estate.back.dto.response.board.GetSearchBoardListResponseDto;

public interface BoardService {
    
    // C
    ResponseEntity<ResponseDto> postBoard(PostBoardRequestDto dto, String userId);
    ResponseEntity<ResponseDto> postComment(PostCommentRequestDto dto, int receptionNumber);
    // R
    ResponseEntity<? super GetBoardListResponseDto> getBoardList();
    ResponseEntity<? super GetSearchBoardListResponseDto> getSearchBoardList(String searchWord);
    ResponseEntity<? super GetBoardResponseDto> getBoard(int receptionNumber);
    // U
    ResponseEntity<ResponseDto> PutBoard(PutBoardRequestDto dto, int receptionNumber, String userId);
    ResponseEntity<ResponseDto> increaseViewCount(int receptionNumber);    
    // D
    ResponseEntity<ResponseDto> deleteBoard(int receptionNumber, String userId);
}
