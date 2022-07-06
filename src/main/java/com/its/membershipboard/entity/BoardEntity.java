package com.its.membershipboard.entity;

import com.its.membershipboard.dto.BoardDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Entity
@Getter @Setter
@Table(name = "boardTestTable")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long boardId;

    @Column (length = 30, unique = true)
    private String boardWriter;

    @Column (length = 50, nullable = false)
    private String boardTitle;

    @Column (length = 500)
    private String boardContents;

    @Column
    private int boardHits;

    @Column
    private LocalDateTime boardCreatedTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;

    public static BoardEntity toSaveBoardEntity(BoardDTO boardDTO) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardContents(boardDTO.getBoardContents());
        boardEntity.setBoardCreatedTime(now());
        return boardEntity;
    }
}
