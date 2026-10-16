
package com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.Message;

import com.sprint.mission.discodeit.service.UserService;
import com.sprint.mission.discodeit.service.ChannelService;
import com.sprint.mission.discodeit.service.MessageService;

import com.sprint.mission.discodeit.service.jcf.JCFUserService;
import com.sprint.mission.discodeit.service.jcf.JCFChannelService;
import com.sprint.mission.discodeit.service.jcf.JCFMessageService;

public class JavaApplication {

    public static void main(String[] args) {

        // 서비스 객체 생성
        UserService userService = new JCFUserService();
        ChannelService channelService = new JCFChannelService();
        MessageService messageService =
                new JCFMessageService(userService, channelService);

        // =================================
        // 1. 사용자 테스트
        // =================================

        // 사용자 3명 등록
        User user1 = new User("홍길동");
        User user2 = new User("김철수");
        User user3 = new User("이영희");

        userService.create(user1);
        userService.create(user2);
        userService.create(user3);

        // 전체 사용자 수 확인
        System.out.println("=== 사용자 등록 후 ===");
        System.out.println("사용자 수: " + userService.findAll().size());

        // 존재하는 사용자 조회
        System.out.println("=== 존재하는 사용자 조회 ===");
        System.out.println(userService.findById(user1.getId()).getUsername());

        // 존재하지 않는 사용자 조회
        System.out.println("=== 없는 사용자 조회 ===");
        System.out.println(
                userService.findById(java.util.UUID.randomUUID()) == null
                        ? "없음"
                        : "존재함"
        );

        // 사용자 수정
        user1.update("임찬혁 수정");
        userService.update(user1.getId(), user1);

        // 수정 결과 확인
        System.out.println("=== 사용자 수정 후 ===");
        System.out.println(
                userService.findById(user1.getId()).getUsername()
        );

        // 사용자 삭제
        userService.delete(user2.getId());

        // 삭제 결과 확인
        System.out.println("=== 사용자 삭제 후 ===");
        System.out.println(
                userService.findById(user2.getId()) == null
                        ? "없음"
                        : "존재함"
        );
        System.out.println("남은 사용자 수: " + userService.findAll().size());

        // =================================
        // 2. 채널 테스트
        // =================================

        Channel channel = new Channel("자유 채널");
        channelService.create(channel);

        System.out.println("=== 채널 등록 후 ===");
        System.out.println(
                channelService.findById(channel.getId()).getChannel()
        );
        System.out.println("채널 수: " + channelService.findAll().size());

        // 채널 수정
        channel.update("공지 채널");
        channelService.update(channel.getId(), channel);

        System.out.println("=== 채널 수정 후 ===");
        System.out.println(
                channelService.findById(channel.getId()).getChannel()
        );

        // =================================
        // 3. 메시지 테스트
        // =================================

        // 존재하는 사용자와 채널을 연결해서 메시지 생성
        Message message = new Message("안녕하세요 반가워용", user1, channel);
        messageService.create(message);

        System.out.println("=== 메시지 등록 후 ===");
        System.out.println(
                messageService.findById(message.getId()).getContent()
        );
        System.out.println("메시지 수: " + messageService.findAll().size());

        // 메시지 수정
        message.update("수정한 메시지입니다.");
        messageService.update(message.getId(), message);

        System.out.println("=== 메시지 수정 후 ===");
        System.out.println(
                messageService.findById(message.getId()).getContent()
        );

        // 메시지 삭제
        messageService.delete(message.getId());

        System.out.println("=== 메시지 삭제 후 ===");
        System.out.println(
                messageService.findById(message.getId()) == null
                        ? "없음"
                        : "존재함"
        );
        System.out.println("남은 메시지 수: " + messageService.findAll().size());

        // =================================
        // 4. 채널 삭제
        // =================================

        channelService.delete(channel.getId());

        System.out.println("=== 채널 삭제 후 ===");
        System.out.println(
                channelService.findById(channel.getId()) == null
                        ? "없음"
                        : "존재함"
        );

        // =================================
        // 5. 남은 사용자 확인
        // =================================

        System.out.println("=== 최종 사용자 목록 ===");
        System.out.println("남은 사용자 수: " + userService.findAll().size());

        for (User user : userService.findAll()) {
            System.out.println(user.getUsername());
        }
    }
}
