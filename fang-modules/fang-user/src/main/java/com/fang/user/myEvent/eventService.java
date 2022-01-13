package com.fang.user.myEvent;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author:fxm
 * @createTime:2021/10/25 15:08
 */
@Service
public class eventService {

    @EventListener(classes = ApplicationEvent.class)
    void listen(ApplicationEvent event) {
        System.out.println("eventService 监听的事件" + event);
    }
}
