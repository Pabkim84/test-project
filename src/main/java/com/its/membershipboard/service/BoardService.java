package com.its.membershipboard.service;

import com.its.membershipboard.dto.BoardDTO;
import com.its.membershipboard.entity.BoardEntity;
import com.its.membershipboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Long save(BoardDTO boardDTO){
        BoardEntity boardEntity = BoardEntity.toSaveBoardEntity(boardDTO);
        Long id = boardRepository.save(boardEntity).getBoardId();
        return id;
    }
    public List<BoardDTO> findAll() {
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();
        for(BoardEntity boardEntity: boardEntityList) {
            boardDTOList.add(BoardDTO.toBoardDTO(boardEntity));
        }
        return boardDTOList;
    }

    public BoardDTO findById(Long id) {
        Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(id);
        BoardEntity boardEntity = optionalBoardEntity.get();
        return BoardDTO.toBoardDTO(boardEntity);
    }
}
