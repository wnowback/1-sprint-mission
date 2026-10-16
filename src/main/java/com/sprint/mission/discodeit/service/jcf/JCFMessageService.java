package com.sprint.mission.discodeit.service.jcf; // 패키지 지정

import com.sprint.mission.discodeit.entity.Message; // Message 클래스 사용
import com.sprint.mission.discodeit.service.MessageService; // 구현할 인터페이스
import com.sprint.mission.discodeit.service.UserService;
import com.sprint.mission.discodeit.service.ChannelService;
import java.util.*; // UUID, Map, List, HashMap 등 사용

public class JCFMessageService implements MessageService {

    private final Map<UUID, Message> data; // 메시지 데이터를 저장할 공간
    private final UserService userService;
    private final ChannelService channelService;

    public JCFMessageService(UserService userService, ChannelService channelService) {
        this.data = new HashMap<>();
        this.userService = userService;
        this.channelService = channelService;
    }

    @Override
    public Message create(Message message) {

        // 작성자가 실제로 등록된 사용자인지 확인
        if (userService.findById(message.getUser().getId()) == null) {
            throw new IllegalArgumentException("존재하지 않는 사용자입니다.");
        }

        // 메시지가 등록될 채널이 실제로 존재하는지 확인
        if (channelService.findById(message.getChannel().getId()) == null) {
            throw new IllegalArgumentException("존재하지 않는 채널입니다.");
        }

        // 두 가지 확인을 모두 통과하면 메시지 저장
        data.put(message.getId(), message);
        return message;
    }

    @Override
    public Message findById(UUID id) { // ID로 메시지 조회
        return data.get(id); // 해당 메시지 반환, 없으면 null
    }

    @Override
    public List<Message> findAll() { // 모든 메시지 조회
        return new ArrayList<>(data.values()); // 모든 메시지를 목록으로 반환
    }

    @Override
    public Message update(UUID id, Message message) { // 메시지 수정
        if (!data.containsKey(id)) { // 해당 ID가 없다면
            return null; // 수정할 메시지가 없음
        }
        data.put(id, message); // 기존 메시지를 새 객체로 교체
        return message; // 수정한 메시지 반환
    }

    @Override
    public void delete(UUID id) { // 메시지 삭제
        data.remove(id); // 해당 ID의 메시지 삭제
    }
}
