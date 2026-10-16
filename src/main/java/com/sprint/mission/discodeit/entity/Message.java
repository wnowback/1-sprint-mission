package com.sprint.mission.discodeit.entity;

import java.util.UUID; // 고유ID를 만들기 위한 UUID 생성

public class Message {

    private UUID id; // 메시지 고유ID
    private Long createdAt; // 메시지 생성시각
    private Long updatedAt; //마지막으로 수정된 시각

    private String content; // 메시지 내용
    private User user;       // 메시지를 작성한 사용자
    private Channel channel;  // 메시지가 등록된 채널

    public Message(String content, User user, Channel channel) {
        this.id = UUID.randomUUID();
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = this.createdAt;

        this.content = content;
        this.user = user;
        this.channel = channel;
    }

    // id 필드의 값을 반환하는 메소드 getter
    public UUID getId() {
        return id; // 현재 객체의 id 값을 돌려줌
    }

    // createdAt 값을 반환 메소드
    public Long getCreatedAt() {
        return createdAt; // 생성 시각을 돌려줌
    }

    // updatedAt 값을 반환 메소드
    public Long getUpdatedAt() {
        return updatedAt; // 마지막 수정 시각을 돌려줌
    }

    // content 값을 반환 메소드
    public String getContent() {
        return content; // 채널 이름을 돌려줌
    }
    // 메시지를 작성한 사용자 반환
    public User getUser() {
        return user;
    }

    // 메시지가 등록된 채널 반환
    public Channel getChannel() {
        return channel;
    }

    // 채널 정보를 수정하는 메소드 update
    public void update(String content) {
        this.content = content; // 기존 메세지 이름을 새 이름으로 변경
        this.updatedAt = System.currentTimeMillis(); // 수정 시각 갱신
    }
}

