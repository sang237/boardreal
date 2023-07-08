package com.studysec.boardsec.service;

import com.studysec.boardsec.entity.Board;
import com.studysec.boardsec.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    //글작성 처리
    public void write(Board board) {

        boardRepository.save(board);
    }

    //게시물 리스트 처리
    public Page<Board> boardList(Pageable pageable) {

        return boardRepository.findAll(pageable);
    }

    //특정 게시글 불러오기
    public Board boardView(Integer id) {

        return boardRepository.findById(id).get();
    }

    //특정 게시물 삭제
    public void boardDelete(Integer id) {

        boardRepository.deleteById(id);
    }
}
