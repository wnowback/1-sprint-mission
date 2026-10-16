package com.sprint.mission.discodeit.service.jcf; // 구현 클래스가 속한 패키지

import com.sprint.mission.discodeit.entity.User; // 사용자 데이터 타입
import com.sprint.mission.discodeit.service.UserService; // 구현할 인터페이스
import java.util.*; // UUID, List, Map 등의 자료형 사용

public class JCFUserService implements UserService { // UserService 구현

    private final Map<UUID, User> data; // 사용자 데이터를 저장할 Map

    public JCFUserService() { // 생성자
        this.data = new HashMap<>(); // 빈 저장 공간 생성
    }

    @Override
    public User create(User user) { // 사용자 생성
        data.put(user.getId(), user); // ID를 키로, 사용자를 값으로 저장
        return user; // 생성한 사용자 반환
    }

    @Override
    public User findById(UUID id) { // ID로 사용자 조회
        return data.get(id); // 해당 ID의 사용자 반환 (없으면 null)
    }

    @Override
    public List<User> findAll() { // 모든 사용자 조회
        return new ArrayList<>(data.values()); // 저장된 사용자들을 목록으로 반환
    }

    @Override
    public User update(UUID id, User user) { // 사용자 수정
        if (!data.containsKey(id)) { // 해당 ID가 저장되어 있지 않다면
            return null; // 수정할 사용자가 없음을 표시
        }
        data.put(id, user); // 해당 ID의 사용자 정보를 교체
        return user; // 수정한 사용자 반환
    }

    @Override
    public void delete(UUID id) { // 사용자 삭제
        data.remove(id); // 해당 ID의 사용자 삭제
    }
}
