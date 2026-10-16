package com.sprint.mission.discodeit.entity;

import java.util.UUID; // 고유ID를 만들기 위한 UUID 생성

public class User {

    private UUID id; // 사용자 고유ID
    private Long createdAt; // 생성시각
    private Long updatedAt; //마지막으로 수정된 시각

    private String username; // 메시지 내용

    public User(String username) { //객체를 만들 때 실행되는 생성자
        this.id = UUID.randomUUID(); // 고유 ID생성
        this.createdAt = System.currentTimeMillis(); // 현재 시각 저장
        this.updatedAt = this.createdAt; //처음 생성과 수정 시각이 같도록 설정
        this.username = username; // 필드에 저장
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

    // username 값을 반환 메소드
    public String getUsername() {
        return username; // 유저 이름을 돌려줌
    }

    // 채널 정보를 수정하는 메소드 update
    public void update(String username) {
        this.username = username; // 기존 유저 이름을 새 이름으로 변경
        this.updatedAt = System.currentTimeMillis(); // 수정 시각 갱신
    }
}