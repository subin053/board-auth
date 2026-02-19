package com.green.boardauth.application.board;

import com.green.boardauth.application.board.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    public long postBoard(BoardPostReq req) {
        boardMapper.save(req);
        return req.getId();
    }

    public List<BoardGetRes> getBoardList(BoardGetReq req) {
        return boardMapper.findAll(req);
    }

    public int getBoardMaxPage(BoardGetMaxPageReq req) {
        return boardMapper.findMaxPage(req);
    }

    public BoardDetailReq detailReq(long id){
    return boardMapper.detail(id);
    }

    public int deleteBoard(long id){
        return boardMapper.delBoard(id);
    }

    public int modify(BoardPutReq req){
        return boardMapper.updated(req);
    }

    public List<String> relatedText(String req){
        return boardMapper.relatedText(req);
    }
}
