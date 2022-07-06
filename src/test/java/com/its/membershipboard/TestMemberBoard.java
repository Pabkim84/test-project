package com.its.membershipboard;

import com.its.membershipboard.dto.BoardDTO;
import com.its.membershipboard.entity.BoardEntity;
import com.its.membershipboard.repository.BoardRepository;
import com.its.membershipboard.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import java.util.stream.IntStream;
import javax.transaction.Transactional;
import static org.assertj.core.api.Assertions.*;


@SpringBootTest
public class TestMemberBoard {

    @Autowired
    private BoardService boardService;
    public BoardDTO newBoardData(int i) {
        BoardDTO boardDTO =new BoardDTO("testTitle"+i, "testWriter"+i, "testContents"+i);
        return boardDTO;
    }
    @Test
    @Transactional
    @Rollback(value = true)
    public void boardSaveTest() {
        Long id = boardService.save(newBoardData(1));
        BoardDTO boardDTO = boardService.findById(id);
        assertThat(newBoardData(1).getBoardWriter()).isEqualTo(boardDTO.getBoardWriter());
    }
}
