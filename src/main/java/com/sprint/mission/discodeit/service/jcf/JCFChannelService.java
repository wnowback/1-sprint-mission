package com.sprint.mission.discodeit.service.jcf;  // 패키지 지정

import com.sprint.mission.discodeit.entity.Channel; // Channel 클래스 사용
import com.sprint.mission.discodeit.service.ChannelService; // 구현할 인터페이스
import java.util.*; // UUID, Map, List, HashMap 등 사용

public class JCFChannelService implements ChannelService {

    private final Map<UUID, Channel> data; // 채널 데이터를 저장할 공간

    public JCFChannelService() { // 생성자
        this.data = new HashMap<>(); // 빈 저장 공간 초기화
    }

    @Override
    public Channel create(Channel channel) { // 채널 생성
        data.put(channel.getId(), channel); // ID와 채널 객체 저장
        return channel; // 생성한 채널 반환
    }

    @Override
    public Channel findById(UUID id) { // ID로 채널 조회
        return data.get(id); // 해당 채널 반환, 없으면 null
    }

    @Override
    public List<Channel> findAll() { // 모든 채널 조회
        return new ArrayList<>(data.values()); // 모든 채널을 목록으로 반환
    }

    @Override
    public Channel update(UUID id, Channel channel) { // 채널 수정
        if (!data.containsKey(id)) { // 해당 ID가 없다면
            return null; // 수정할 채널이 없음
        }
        data.put(id, channel); // 기존 채널을 새 객체로 교체
        return channel; // 수정한 채널 반환
    }

    @Override
    public void delete(UUID id) { // 채널 삭제
        data.remove(id); // 해당 ID의 채널 삭제
    }
}
